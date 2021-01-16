package plugins

import com.android.build.gradle.BaseExtension
import org.gradle.api.Project

internal class AndroidPlugin : CompositePlugin {

    override fun apply(target: Project) {

        target.extensions.findByType(BaseExtension::class.java)?.let {
            applyDefaultConfigurations(it)
        }
    }

    private fun applyDefaultConfigurations(androidExtension: BaseExtension) {
        androidExtension.compileSdkVersion(SDK_COMPILE_VERSION)
        androidExtension.buildToolsVersion(BUILD_TOOLS_VERSION)

        androidExtension.defaultConfig {

            targetSdkVersion(SDK_TARGET_VERSION)
            minSdkVersion(SDK_MIN_VERSION)

            testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        }
    }

    companion object {

        private const val SDK_COMPILE_VERSION = 29
        private const val BUILD_TOOLS_VERSION = "29.0.3"
        private const val SDK_TARGET_VERSION = SDK_COMPILE_VERSION
        private const val SDK_MIN_VERSION = 21
    }
}