plugins {
    id("com.deadrudolph.android.library")
    id("com.deadrudolph.android.di")
}

android {
    namespace = "com.deadrudolph.feature_home_domain"
}

dependencies {
    implementation(projects.common.commonDi)
    implementation(projects.common.commonNetwork)
    implementation(projects.common.commonDomain)

    implementation(libs.dagger)
    ksp(libs.daggerCompiler)
    implementation(libs.immutableList)
    implementation(libs.retrofit)
    implementation(libs.moshiKotlin)
}
