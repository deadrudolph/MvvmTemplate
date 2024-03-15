plugins {
    id("com.deadrudolph.android.library")
}

android {
    namespace = "com.deadrudolph.core"
}

dependencies {
    implementation(projects.navigation)

    implementation(libs.activityKtx)
    implementation(libs.appcompat)
    implementation(libs.composeUI)
    implementation(libs.material)
    implementation(libs.dagger)
    implementation(libs.daggerCompiler)
    implementation(libs.fragmentKtx)
    implementation(libs.timber)
}
