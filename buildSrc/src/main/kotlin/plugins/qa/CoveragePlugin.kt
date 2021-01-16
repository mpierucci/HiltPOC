package plugins.qa

import com.android.build.gradle.*
import com.android.build.gradle.api.BaseVariant
import org.gradle.api.DomainObjectSet
import org.gradle.api.Project
import org.gradle.kotlin.dsl.create
import org.gradle.kotlin.dsl.get
import org.gradle.kotlin.dsl.register
import org.gradle.testing.jacoco.plugins.JacocoPlugin
import org.gradle.testing.jacoco.tasks.JacocoReport
import plugins.CompositePlugin


/**
 * Applies jacoco plugin and configure its for android modules.
 * Only library and application modules are included
 *
 * Note that as long as java, and kotlin plugin are applied first
 * this will generate jacoco tasks for kotlin modules as well only under the verification folder
 */
internal class CoveragePlugin : CompositePlugin {

    override fun apply(target: Project) {
        target.extensions.create<CoverageExtension>(EXTENSION_COVERAGE)

        applyJacocoPlugin(target)

        enableCoverageOnDebug(target)
    }

    private fun applyJacocoPlugin(target: Project) = target.afterEvaluate {
        val coverageExtension = target.extensions.getByType(CoverageExtension::class.java)
        if (!coverageExtension.isEnabled) return@afterEvaluate

        target.plugins.apply(JacocoPlugin::class.java)

        configureAndroidModulesCoverageTasks(target, coverageExtension.excludes)
    }

    private fun configureAndroidModulesCoverageTasks(target: Project, excludes: List<String>) {
        target.plugins.all {
            if (this is LibraryPlugin) configureLibraryPlugin(target, excludes)
            else if (this is AppPlugin) configureAppPlugin(target, excludes)
        }
    }

    private fun configureLibraryPlugin(project: Project, excludes: List<String>) {
        val libraryExtension = project.extensions.getByType(LibraryExtension::class.java)
        configureJacoco(project, libraryExtension.libraryVariants, excludes)
    }

    private fun configureAppPlugin(project: Project, excludes: List<String>) {
        val appExtension = project.extensions.getByType(AppExtension::class.java)
        configureJacoco(project, appExtension.applicationVariants, excludes)
    }

    private fun configureJacoco(
        project: Project,
        variants: DomainObjectSet<out BaseVariant>,
        excludes: List<String>
    ) = variants.all {
        if (!buildType.isDebuggable) return@all

        val dir = project.buildDir
        val variantName = name
        val variantNameCapitalize = name.capitalize()

        project.tasks.register<JacocoReport>("jacoco${variantNameCapitalize}Report") {
            dependsOn(project.tasks["test${variantNameCapitalize}UnitTest"])

            group = "coverage"

            executionData.setFrom(project.fileTree("$dir") {
                setIncludes(listOf("jacoco/test${variantNameCapitalize}UnitTest.exec"))
            })
            setOnlyIf { executionData.files.any { it.exists() } }

            classDirectories.setFrom(
                project.fileTree("${dir}/intermediates/javac/$variantName") { setExcludes(excludes) },
                project.fileTree("${dir}/tmp/kotlin-classes/$variantName") { setExcludes(excludes) }
            )
            sourceDirectories.setFrom(SOURCE_DIR)
            additionalSourceDirs.setFrom(SOURCE_DIR)

            reports.xml.isEnabled = true
        }
    }

    private fun enableCoverageOnDebug(target: Project) {
        val androidExtension = target.extensions.findByName("android")
        if (androidExtension !is BaseExtension) return

        androidExtension.buildTypes { getByName(VERSION_DEBUG) { isTestCoverageEnabled = true } }
    }

    companion object {

        private const val EXTENSION_COVERAGE = "coverage"

        private const val VERSION_DEBUG = "debug"

        private const val SOURCE_DIR = "src/main/kotlin/"
    }

}

open class CoverageExtension {

    open var isEnabled: Boolean = true

    open var excludes: ArrayList<String> = arrayListOf()

    open fun excludes(vararg excludes: String) = this.excludes.addAll(excludes)
}


