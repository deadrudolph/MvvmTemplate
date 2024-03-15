plugins {
    id("com.deadrudolph.android.library")
    id("com.deadrudolph.android.di")
}

android {
    namespace = "com.deadrudolph.common_domain"
}
dependencies {
    implementation(libs.dagger)
    ksp(libs.daggerCompiler)
    implementation(libs.kotlinStdlib)
}
