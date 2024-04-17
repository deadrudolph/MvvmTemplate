plugins {
    id("com.deadrudolph.android.library")
    id("com.deadrudolph.android.di")
    id("com.deadrudolph.android.test")
}

android {
    namespace = "com.deadrudolph.feature_home"

    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.composeCompiler.get()
    }
}

dependencies {
    implementation(projects.common.commonDi)
    implementation(projects.common.commonDomain)
    implementation(projects.core)
    implementation(projects.navigation)
    implementation(projects.uicomponents)
    implementation(projects.features.home.featureHomeDomain)

    implementation(libs.appcompat)
    implementation(libs.composeUI)
    implementation(libs.composeMaterial)
    implementation(libs.composeUITooling)
    implementation(libs.composeFoundation)
    implementation(libs.dagger)
    ksp(libs.daggerCompiler)

    implementation(libs.fragmentKtx)
    implementation(libs.immutableList)
    implementation(libs.material)
    implementation(libs.viewModelScope)

    implementation(libs.navigation)
}
