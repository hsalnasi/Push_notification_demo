// android/app/build.gradle.kts

plugins {
    id("com.android.application")
    kotlin("android")
    id("dev.flutter.flutter-gradle-plugin")
    
    // FIX 1: Firebase Google Services plugin
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.push_notification_final" 
    compileSdk = 34 

    // 🚨 FIX 2: Set consistent JVM source and target compatibility 🚨
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
        isCoreLibraryDesugaringEnabled = true
    }

    // 🚨 FIX 3: Set consistent Kotlin JVM target 🚨
    kotlinOptions {
        jvmTarget = "1.8"
    }

    defaultConfig {
        minSdk = flutter.minSdkVersion 
        targetSdk = 34 
        versionCode = 1
        versionName = "1.0"
    }
    
    buildTypes {
        // FIX 4: Resource shrinking conflict resolution (for 'release' builds)
        named("release") {
            isMinifyEnabled = false
            isShrinkResources = false
            
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

flutter {
    source = "../.."
}

dependencies {
    // Add your dependencies here if needed
    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:2.0.3")
}
