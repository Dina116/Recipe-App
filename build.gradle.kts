// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath ("com.android.tools.build:gradle:8.0.2") // Use the latest version compatible with your Gradle
        classpath ("androidx.navigation:navigation-safe-args-gradle-plugin:2.7.0") // Safe Args plugin
    }
}


plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
}