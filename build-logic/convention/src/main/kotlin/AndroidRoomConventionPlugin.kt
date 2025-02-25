import ir.kaaveh.composenews.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidRoomConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            dependencies {
                add("implementation", libs.findBundle("room").get())
                add("kapt", libs.findLibrary("room.compiler").get())
            }
        }
    }
}