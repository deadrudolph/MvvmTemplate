plugins {
    id("com.deadrudolph.kotlin.detekt")
    alias(libs.plugins.com.google.devtools.kspt)
    alias(libs.plugins.androidLibrary) apply false
    alias(libs.plugins.kotlinAndroid) apply false
}

buildscript {

    dependencies {
        classpath(libs.googleServices)
        classpath(libs.androidGradle)
        classpath(libs.kotlinGradle)
    }

    repositories {
        google()
        mavenCentral()

        maven { url = uri("https://plugins.gradle.org/m2/") }
        gradlePluginPortal()
        flatDir {
            dirs("libs")
        }
    }
}
