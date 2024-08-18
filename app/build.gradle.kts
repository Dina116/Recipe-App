plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id ("kotlin-kapt")
    id("kotlin-android")
    id ("androidx.navigation.safeargs.kotlin")




}

android {
    namespace = "com.training.recipeapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.training.recipeapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation (libs.androidx.navigation.fragment.ktx.v270)
    implementation (libs.androidx.navigation.ui.ktx.v270)
    implementation (libs.androidx.lifecycle.extensions)
    implementation (libs.androidx.lifecycle.common.java8)
    implementation (libs.androidx.lifecycle.viewmodel.ktx)
    implementation (libs.androidx.room.runtime) // Update to a newer version
    kapt (libs.androidx.room.compiler) // Update to a newer version
    implementation (libs.androidx.room.ktx) // Update to a newer version
    androidTestImplementation (libs.androidx.room.testing) // Update to a newer version
    implementation (libs.kotlin.stdlib.jdk7) // Update to a newer version
    api (libs.kotlinx.coroutines.core )// Update to a newer version
    api (libs.kotlinx.coroutines.android) // Update to a newer version
    implementation (libs.jbcrypt)
    implementation (libs.androidx.core.ktx.v1100 )// Use the latest version
    implementation (libs.androidx.appcompat) // Use the latest version
    implementation (libs.material) // Use the latest version
    implementation (libs.androidx.constraintlayout )// Use the latest version

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.core.ktx.v1100)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
        implementation(libs.retrofit)
        implementation(libs.converter.gson)
        implementation(libs.kotlin.stdlib)

    implementation(libs.coil.compose)
    implementation(libs.coil)










}