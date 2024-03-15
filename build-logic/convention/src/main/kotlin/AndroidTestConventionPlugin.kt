import com.android.build.gradle.BaseExtension
import com.deadrudolph.conventions.libsDependency
import com.deadrudolph.conventions.testImplementation
import com.deadrudolph.conventions.testRuntimeOnly
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

class AndroidTestConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            extensions.configure<BaseExtension> {
                testOptions {
                    unitTests.all {
                        it.useJUnitPlatform()
                    }
                }
            }
            dependencies {
                testImplementation(platform(libsDependency("junit5-bom")))
                testRuntimeOnly(libsDependency("junit5-engine"))
                testImplementation(libsDependency("junit5-api"))
                testImplementation(libsDependency("junit5-params"))
            }
        }
    }
}
