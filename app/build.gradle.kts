plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id ("kotlin-kapt")
    id("kotlin-android")
    id ("androidx.navigation.safeargs.kotlin")
    id("kotlin-parcelize")



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
    buildFeatures{
        viewBinding = true
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

// ViewModel
    implementation(libs.androidx.lifecycle.viewmodel.ktx.v260)
// ViewModel utilities for Compose
    implementation(libs.androidx.lifecycle.viewmodel.compose)
// LiveData
    implementation(libs.androidx.lifecycle.livedata.ktx)
// Lifecycles only (without ViewModel or LiveData)
    implementation(libs.androidx.lifecycle.runtime.ktx)

// Saved state module for ViewModel
    implementation(libs.androidx.lifecycle.viewmodel.savedstate)

// Annotation processor
    kapt(libs.androidx.lifecycle.compiler)

    implementation (libs.androidx.navigation.fragment.ktx)
    implementation (libs.androidx.navigation.ui.ktx)

    // Navigation Component
    implementation (libs.androidx.navigation.fragment.ktx.v270)
    implementation (libs.androidx.navigation.ui.ktx.v270)



    // Lifecycle components
    implementation (libs.androidx.lifecycle.extensions)
    implementation (libs.androidx.lifecycle.common.java8)
    implementation (libs.androidx.lifecycle.viewmodel.ktx)

    // Room
    implementation (libs.androidx.room.runtime) // Update to a newer version
    kapt (libs.androidx.room.compiler) // Update to a newer version
    implementation (libs.androidx.room.ktx) // Update to a newer version
    androidTestImplementation (libs.androidx.room.testing) // Update to a newer version

    // Kotlin
    implementation (libs.kotlin.stdlib.jdk7) // Update to a newer version

    // Coroutines
    api (libs.kotlinx.coroutines.core )// Update to a newer version
    api (libs.kotlinx.coroutines.android) // Update to a newer version
    implementation (libs.jbcrypt)


    implementation (libs.androidx.core.ktx.v1100 )// Use the latest version
    implementation (libs.androidx.appcompat) // Use the latest version
    implementation (libs.material) // Use the latest version
    implementation (libs.androidx.constraintlayout )// Use the latest version

// retrofit
    implementation (libs.retrofit)
    implementation (libs.converter.gson)


// gson
    implementation (libs.gson)

// glide
    implementation (libs.glide)

    implementation(libs.kotlinx.serialization.json)

    implementation(libs.glide)
    kapt(libs.compiler)
    implementation(libs.ktor.client.core)
    implementation(libs.ktor.client.cio)
    implementation(libs.kotlinx.coroutines.core.v170)


    implementation(libs.coil) // أو أحدث إصدار متاح







}