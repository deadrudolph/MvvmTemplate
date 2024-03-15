plugins {
    id("com.deadrudolph.android.application")
    id("com.deadrudolph.android.test")
    id("com.deadrudolph.android.di")
}

android {

    namespace = "com.deadrudolph.template_mvvm"

    defaultConfig {
        applicationId = "com.deadrudolph.template_mvvm"
    }

    buildFeatures {
        compose = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.composeCompiler.get()
    }
}

dependencies {
    implementation(projects.common.commonDi)
    implementation(projects.core)
    implementation(projects.navigation)
    implementation(projects.uicomponents)
    implementation(projects.features.home.featureHome)
    implementation(projects.features.profile.featureProfile)

    implementation(libs.appcompat)
    implementation(libs.coreKtx)
    implementation(libs.material)
    implementation(libs.timber)
    implementation(libs.composeActivity)
    implementation(libs.composeUI)
    implementation(libs.composeMaterial)
    implementation(libs.composeUITooling)
    implementation(libs.composeFoundation)

    implementation(libs.navigation)
}
