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

    val lifecycle_version = "2.6.0"
    val arch_version = "2.1.0"

// ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")
// ViewModel utilities for Compose
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:$lifecycle_version")
// LiveData
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version")
// Lifecycles only (without ViewModel or LiveData)
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycle_version")

// Saved state module for ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-savedstate:$lifecycle_version")

// Annotation processor
    kapt("androidx.lifecycle:lifecycle-compiler:$lifecycle_version")

    implementation ("androidx.navigation:navigation-fragment-ktx:2.7.7")
    implementation ("androidx.navigation:navigation-ui-ktx:2.7.7")

    // Navigation Component
    implementation ("androidx.navigation:navigation-fragment-ktx:2.7.0")
    implementation ("androidx.navigation:navigation-ui-ktx:2.7.0")



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
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")


// gson
    implementation ("com.google.code.gson:gson:2.10.1")

// glide
    implementation ("com.github.bumptech.glide:glide:4.15.0")













}