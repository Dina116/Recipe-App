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




    // Navigation Component
    implementation ("androidx.navigation:navigation-fragment-ktx:2.7.0")
    implementation ("androidx.navigation:navigation-ui-ktx:2.7.0")



    // Lifecycle components
    implementation ("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation ("androidx.lifecycle:lifecycle-common-java8:2.2.0")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0")

    // Room
    implementation ("androidx.room:room-runtime:2.5.0") // Update to a newer version
    kapt ("androidx.room:room-compiler:2.5.0") // Update to a newer version
    implementation ("androidx.room:room-ktx:2.5.0") // Update to a newer version
    androidTestImplementation ("androidx.room:room-testing:2.5.0") // Update to a newer version

    // Kotlin
    implementation ("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.7.10") // Update to a newer version

    // Coroutines
    api ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0" )// Update to a newer version
    api ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.0") // Update to a newer version
    implementation ("org.mindrot:jbcrypt:0.4")


    implementation ("androidx.core:core-ktx:1.10.0" )// Use the latest version
    implementation ("androidx.appcompat:appcompat:1.6.1") // Use the latest version
    implementation ("com.google.android.material:material:1.9.0") // Use the latest version
    implementation ("androidx.constraintlayout:constraintlayout:2.1.4" )// Use the latest version







}