package plugins

import org.gradle.api.Plugin
import org.gradle.api.Project

internal interface CompositePlugin : Plugin<Project> {

    fun appendNext(next: CompositePlugin) = object : CompositePlugin {
        override fun apply(target: Project) {
            this@CompositePlugin.apply(target)
            next.apply(target)
        }
    }

}