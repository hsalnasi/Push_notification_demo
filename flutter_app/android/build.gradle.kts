// android/build.gradle.kts (Project-Level)

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        // Standard Android Gradle Plugin dependency (version might vary)
        classpath("com.android.tools.build:gradle:7.3.0") 
        
        // 🚨 CRITICAL FIX: Add the Google Services classpath 🚨
        classpath("com.google.gms:google-services:4.4.0") // Use the latest stable version
        
        // NOTE: The Flutter Gradle Plugin dependency is often handled automatically or 
        // in a separate configuration, but ensure your build works with this structure.
    }
}

// Your existing content starts here
allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

val newBuildDir: Directory =
    rootProject.layout.buildDirectory
        .dir("../../build")
        .get()
rootProject.layout.buildDirectory.value(newBuildDir)

subprojects {
    val newSubprojectBuildDir: Directory = newBuildDir.dir(project.name)
    project.layout.buildDirectory.value(newSubprojectBuildDir)
}
subprojects {
    project.evaluationDependsOn(":app")
}

tasks.register<Delete>("clean") {
    delete(rootProject.layout.buildDirectory)
}