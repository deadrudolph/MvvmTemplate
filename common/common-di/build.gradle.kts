plugins {
    id("com.deadrudolph.android.library")
    id("com.deadrudolph.android.di")
}

android {
    namespace = "com.deadrudolph.common_di"

    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.composeCompiler.get()
    }
}
dependencies {
    implementation(libs.composeActivity)
    implementation(libs.dagger)
    ksp(libs.daggerCompiler)
    implementation(libs.kotlinStdlib)
    implementation(libs.viewModelScope)
}
