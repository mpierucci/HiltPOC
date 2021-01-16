package plugins

import org.gradle.api.Project
import org.gradle.plugin.use.PluginDependenciesSpec
import org.gradle.plugin.use.PluginDependencySpec

internal fun Project.reportPath() = "$buildDir/reports"


val PluginDependenciesSpec.`module-plugin`: PluginDependencySpec
    get() = id("module-plugin")