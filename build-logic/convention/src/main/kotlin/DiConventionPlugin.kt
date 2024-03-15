import com.deadrudolph.conventions.implementation
import com.deadrudolph.conventions.ksp
import com.deadrudolph.conventions.libsDependency
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class DiConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.google.devtools.ksp")
            }

            dependencies {
                implementation(libsDependency("dagger"))
                ksp(libsDependency("daggerCompiler"))
            }
        }
    }
}
