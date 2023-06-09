plugins {
    id("com.android.application")
    kotlin("android")

    //Kapt
    kotlin("kapt")

    //Hilt
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.example.radiapi"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.kitsuapi"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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

    // Fragment
    implementation ("androidx.fragment:fragment-ktx:1.6.0")

    // Core
    implementation("androidx.core:core-ktx:1.10.1")

    // AppCompat
    implementation("androidx.appcompat:appcompat:1.6.1")

    // Material Design
    implementation("com.google.android.material:material:1.9.0")

    // UI Components
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    //Livedata
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.6.1")

    //ViewModel
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")

    //Hilt
    val hilt_version = "2.45"
    implementation("com.google.dagger:hilt-android:$hilt_version")
    kapt("com.google.dagger:hilt-compiler:$hilt_version")

    // Data
    implementation(project(":data"))

    // Presentation
    implementation(project(":presentation"))
}