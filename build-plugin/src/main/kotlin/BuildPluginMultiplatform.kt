import org.gradle.api.Plugin
import org.gradle.api.Project

class BuildPluginMultiplatform: Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        pluginManager.apply("org.jetbrains.kotlin.multiplatform")
        group = rootProject.group
        version = rootProject.version
    }
}

