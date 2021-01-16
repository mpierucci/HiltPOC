package plugins

import com.android.build.gradle.BaseExtension
import dependencies.Test
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal class TestPlugin : CompositePlugin {

    companion object {
        private const val UNIT_TEST_IMPLEMENTATION = "testImplementation"
        private const val INSTRUMENTATION_TEST_IMPLEMENTATION = "androidTestImplementation"
    }

    override fun apply(target: Project) {
        target.dependencies {
            add(UNIT_TEST_IMPLEMENTATION, Test.jUnit)
            add(UNIT_TEST_IMPLEMENTATION, Test.mockitoKotlin)
            add(UNIT_TEST_IMPLEMENTATION, Test.truth)
        }

        target.extensions.findByType(BaseExtension::class.java) ?: return

        target.dependencies {
            add(INSTRUMENTATION_TEST_IMPLEMENTATION, Test.testRunner)
            add(INSTRUMENTATION_TEST_IMPLEMENTATION, Test.truth)
            add(INSTRUMENTATION_TEST_IMPLEMENTATION, Test.Esspresso.core)
            add(INSTRUMENTATION_TEST_IMPLEMENTATION, Test.Esspresso.idlingResources)
            add(INSTRUMENTATION_TEST_IMPLEMENTATION, Test.Esspresso.contrib)
            add(INSTRUMENTATION_TEST_IMPLEMENTATION, Test.Esspresso.jUnit)
        }
    }
}