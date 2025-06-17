plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("org.jetbrains.kotlin.kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.example.moviesapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.moviesapp"
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

    dataBinding {
        enable = true
    }
//    testOptions {
//        unitTests.includeAndroidResources = true
//    }

}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    //Hilt
    implementation("com.google.dagger:hilt-android:2.51.1")
    kapt("com.google.dagger:hilt-compiler:2.51.1")
    //Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.11.0")
    implementation("com.squareup.retrofit2:converter-gson:2.11.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")
    implementation("com.jakewharton.timber:timber:5.0.1")

    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")

    //Glide
    implementation("com.github.bumptech.glide:glide:4.16.0")
    // JUnit 4 – Core testing framework
    testImplementation("junit:junit:4.13.2")

    // Mockito – For mocking dependencies
    testImplementation("org.mockito:mockito-core:5.11.0")

    // Kotlin Coroutines Test (optional for testing suspend functions)
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.8.0")

    // LiveData testing (optional but useful for ViewModel tests)
    testImplementation("androidx.arch.core:core-testing:2.2.0")

    // AssertJ or Truth (optional, for more readable assertions)
    testImplementation("com.google.truth:truth:1.4.2")

    // AndroidX Test - Core (useful for rules like InstantTaskExecutorRule)
    testImplementation("androidx.test:core:1.5.0")

    // AndroidX Test - JUnit
    testImplementation("androidx.test.ext:junit:1.1.5")

}