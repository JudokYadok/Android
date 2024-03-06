import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

plugins {
    id ("com.android.application")
    id ("org.jetbrains.kotlin.android")
    id ("kotlin-android")
    id ("kotlin-kapt")
    id ("com.google.gms.google-services")
}

android {
    namespace = "com.example.nunettine"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.nunettine"
        minSdk = 24
        targetSdk = 33
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
    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
}

dependencies {

    // core
    implementation ("androidx.core:core-ktx:1.9.0")

    // app compat
    implementation ("androidx.appcompat:appcompat:1.5.1")

    // material
    implementation ("com.google.android.material:material:1.7.0")

    // constraint layout
    implementation ("androidx.constraintlayout:constraintlayout:2.1.4")

    // viewmodel
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.1")

    // lifecycle
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.5.1")

    // coroutines
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")

    // fragment ktx
    implementation ("androidx.fragment:fragment-ktx:1.5.4")

    // desugar jdk
    coreLibraryDesugaring ("com.android.tools:desugar_jdk_libs:1.2.2")


    implementation ("com.kizitonwose.calendar:view:2.4.1")
    implementation ("com.kizitonwose.calendar:compose:2.4.1")

    // timber
    implementation ("com.jakewharton.timber:timber:5.0.1")


    // Retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("com.squareup.retrofit2:adapter-rxjava2:2.9.0")
    implementation ("com.squareup.retrofit2:converter-scalars:2.9.0")
    implementation ("com.google.code.gson:gson:2.9.0")


    // Glide
    implementation ("com.github.bumptech.glide:glide:4.11.0")
    annotationProcessor ("com.github.bumptech.glide:compiler:4.11.0")


    // picasso
    implementation ("com.squareup.picasso:picasso:2.8")


    // kakao
    implementation ("com.kakao.sdk:v2-user:2.12.1")


    // google play services
    implementation ("com.google.firebase:firebase-core:21.1.1")
    implementation ("com.google.gms:google-services:4.3.8")
    implementation ("com.google.firebase:firebase-auth:22.3.0")
    implementation (platform("com.google.firebase:firebase-bom:32.7.0"))
    implementation ("com.google.android.gms:play-services-auth:20.7.0")
    implementation ("com.google.firebase:firebase-auth-ktx:22.3.0")
    implementation ("com.google.firebase:firebase-analytics")

    // RoomDB
    implementation ("androidx.room:room-ktx:2.4.1")
    implementation ("androidx.room:room-runtime:2.4.1")

    testImplementation ("junit:junit:4.13.2")
    androidTestImplementation ("androidx.test.ext:junit:1.1.3")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.4.0")

    implementation ("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.0")

    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0")
}