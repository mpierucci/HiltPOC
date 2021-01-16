package plugins.language

import com.android.build.gradle.BaseExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.api.plugins.JavaPluginExtension
import plugins.CompositePlugin


/**
 * Applies target and source compatibility to java 8
 *
 * works on android modules and java/kotlin modules
 */
internal class JavaCompatibilityPlugin : CompositePlugin {

    override fun apply(target: Project) {
        target.extensions

        target.extensions.findByType(BaseExtension::class.java)?.let { androidExtension ->
            androidExtension.compileOptions {
                sourceCompatibility = JavaVersion.VERSION_1_8
                targetCompatibility = JavaVersion.VERSION_1_8
            }
            return@apply
        }

        target.extensions.findByType(JavaPluginExtension::class.java)?.let { javaExtension ->
            javaExtension.sourceCompatibility = JavaVersion.VERSION_1_8
            javaExtension.targetCompatibility = JavaVersion.VERSION_1_8
            return@apply
        }

    }
}