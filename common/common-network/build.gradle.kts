plugins {
    id("com.deadrudolph.android.library")
    id("com.deadrudolph.android.di")
}

android {
    namespace = "com.deadrudolph.common_network"

    buildFeatures {
        buildConfig = true
    }

    buildTypes {
        getByName("debug") {
            buildConfigField(
                "String",
                "baseUrl",
                "\"https://reqres.in/api/\""
            )
        }

        getByName("release") {
            buildConfigField(
                "String",
                "baseUrl",
                "\"https://reqres.in/api/\""
            )
        }
    }
}

dependencies {
    implementation(projects.common.commonDi)
    implementation(projects.common.commonDomain)

    implementation(libs.dagger)
    ksp(libs.daggerCompiler)
    implementation(libs.httpLoggingInterceptor)
    implementation(libs.kotlinStdlib)
    implementation(libs.moshiKotlin)
    implementation(libs.moshiAdapters)
    implementation(libs.retrofit)
    implementation(libs.retrofitMoshiConverter)

    debugImplementation(libs.chuck)

    releaseImplementation(libs.chuckNoOp)
}
