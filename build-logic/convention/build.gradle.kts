import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

group = "com.deadrudolph.cam.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}
tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

dependencies {
    compileOnly(libs.androidGradle)
    compileOnly(libs.kotlinGradle)
    implementation(libs.firebaseDistribution)
    implementation(libs.detekt)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "com.deadrudolph.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidLibrary") {
            id = "com.deadrudolph.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("kotlinLibrary") {
            id = "com.deadrudolph.kotlin.library"
            implementationClass = "KotlinLibraryConventionPlugin"
        }
        register("kotlinDetekt") {
            id = "com.deadrudolph.kotlin.detekt"
            implementationClass = "DetektConventionPlugin"
        }
        register("androidTest") {
            id = "com.deadrudolph.android.test"
            implementationClass = "AndroidTestConventionPlugin"
        }
        register("di") {
            id = "com.deadrudolph.android.di"
            implementationClass = "DiConventionPlugin"
        }
    }
}
