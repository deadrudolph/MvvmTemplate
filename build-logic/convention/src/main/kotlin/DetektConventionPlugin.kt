import com.deadrudolph.conventions.libsDependency
import io.gitlab.arturbosch.detekt.Detekt
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.register
import java.io.File
import java.net.URISyntaxException
import java.net.URL

class DetektConventionPlugin : Plugin<Project> {

    @Suppress("UseRequire")
    @Throws(URISyntaxException::class)
    fun Any.getFileFromResource(fileName: String): File {
        val classLoader: ClassLoader = javaClass.classLoader
        val resource: URL? = classLoader.getResource(fileName)
        return if (resource == null) {
            throw IllegalArgumentException("file not found! $fileName")
        } else {
            val file: File = File.createTempFile("config", ".yml")
            val inputStream = resource.openStream()
            inputStream.use { input ->
                file.outputStream().use { output ->
                    input.copyTo(output)
                }
            }
            file
        }
    }

    @Suppress("SpreadOperator")
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("io.gitlab.arturbosch.detekt")
            }

            val parallelOpt = true
            val sourceOpt = projectDir
            val includeOpt = arrayOf("**/*.kt", "**/*.kts")
            val excludeOpt = arrayOf("**/resources/**", "**/build/**")
            val baseLineOpt = file("$rootDir/detekt/config/baseline.xml")
            val configOpt = this@DetektConventionPlugin.getFileFromResource("detekt/config.yml")
            val ignoreFailuresOpt = false
            val buildUponDefaultConfigOpt = true
            val autoCorrectOpt = true

            tasks.register<Detekt>("detektAll") {
                description = "Runs Detekt on the whole project at once."
                parallel = parallelOpt
                setSource(sourceOpt)
                config.setFrom(configOpt)
                baseline.set(baseLineOpt)
                autoCorrect = autoCorrectOpt
                include(*includeOpt)
                exclude(*excludeOpt)
            }

            tasks.register<io.gitlab.arturbosch.detekt.DetektCreateBaselineTask>("updateDetektBaseline") {
                description = "Overrides current baseline for all modules"
                parallel.set(parallelOpt)
                ignoreFailures.set(ignoreFailuresOpt)
                autoCorrect.set(autoCorrectOpt)
                buildUponDefaultConfig.set(buildUponDefaultConfigOpt)
                setSource(sourceOpt)
                baseline.set(baseLineOpt)
                config.from(configOpt)
                include(*includeOpt)
                exclude(*excludeOpt)
            }

            dependencies {
                add("detektPlugins", libsDependency("detektFormatting"))
            }
        }
    }
}
