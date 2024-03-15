plugins {
    id("com.deadrudolph.android.library")
    id("com.deadrudolph.android.di")
}

android {
    namespace = "com.deadrudolph.navigation"
}

dependencies {
    implementation(projects.common.commonDi)

    implementation(libs.dagger)
    ksp(libs.daggerCompiler)
    implementation(libs.fragmentKtx)
    implementation(libs.navigation)
}
