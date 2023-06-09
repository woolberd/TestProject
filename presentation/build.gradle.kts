plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")

    //Kapt
    kotlin("kapt")

    //Hilt
    id("com.google.dagger.hilt.android")

    //save args
    id ("androidx.navigation.safeargs.kotlin")
}

android {
    namespace = "com.example.presentation"
    compileSdk = 33

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
    buildFeatures {
        //ViewBinding
        viewBinding = true
    }
}

dependencies {

    // Fragment
    implementation("androidx.fragment:fragment-ktx:1.6.0")

    // Core
    implementation("androidx.core:core-ktx:1.10.1")

    // AppCompat
    implementation("androidx.appcompat:appcompat:1.6.1")

    // Material Desing
    implementation("com.google.android.material:material:1.9.0")

    // UI Companents
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    //Livedata
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.1")

    //ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")

    // Navigation
    val navVersion = "2.5.3"
    implementation("androidx.navigation:navigation-fragment-ktx:$navVersion")
    implementation("androidx.navigation:navigation-ui-ktx:$navVersion")

    // Glide
    implementation("com.github.bumptech.glide:glide:4.15.0")
    annotationProcessor("com.github.bumptech.glide:compiler:4.15.0")

    // ViewBindingPropertyDelegate
    val view_binding_property_delegate = "1.5.3"

    // implementation
    implementation("com.github.kirich1409:viewbindingpropertydelegate-noreflection:$view_binding_property_delegate")

    // Hilt
    val hilt_version = "2.45"
    implementation("com.google.dagger:hilt-android:$hilt_version")
    kapt("com.google.dagger:hilt-compiler:$hilt_version")

    // Gson
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    // Domain
    api(project(":domain"))
}