plugins {
    kotlin("multiplatform")
    id("com.android.application")
    id("org.jetbrains.compose")
}

kotlin {
    androidTarget()
    sourceSets {
        val androidMain by getting {
            dependencies {
                implementation(project(":shared"))
            }
        }
    }
}

android {
    compileSdk = libs.versions.compileSdk.get().toInt()
    namespace = "com.jinana11.photoprint"

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
//    sourceSets["main"].res.srcDirs("../../design_system/shared/src/commonMain/resources")

    defaultConfig {
        applicationId = "com.jinana11.photoprint.android"
        minSdk = libs.versions.minSdk.get().toInt()
        targetSdk = libs.versions.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlin {
        jvmToolchain(libs.versions.jvmToolchain.get().toInt())
    }
}




//plugins {
//    id("com.android.application")
//    kotlin("android")
//}

//android {
//    namespace = "com.jinana11.photoprint.android"
//    compileSdk = 33
//    defaultConfig {
//        applicationId = "com.jinana11.photoprint.android"
//        minSdk = 24
//        targetSdk = 33
//        versionCode = 1
//        versionName = "1.0"
//    }
//    buildFeatures {
//        compose = true
//    }
//    composeOptions {
//        kotlinCompilerExtensionVersion = "1.4.7"
//    }
//    packaging {
//        resources {
//            excludes += "/META-INF/{AL2.0,LGPL2.1}"
//        }
//    }
//    buildTypes {
//        getByName("release") {
//            isMinifyEnabled = false
//        }
//    }
//    compileOptions {
//        sourceCompatibility = JavaVersion.VERSION_1_8
//        targetCompatibility = JavaVersion.VERSION_1_8
//    }
//    kotlinOptions {
//        jvmTarget = "1.8"
//    }
//}

//dependencies {
//    implementation(project(":shared"))
//    implementation("androidx.compose.ui:ui:1.4.3")
//    implementation("androidx.compose.ui:ui-tooling:1.4.3")
//    implementation("androidx.compose.ui:ui-tooling-preview:1.4.3")
//    implementation("androidx.compose.foundation:foundation:1.4.3")
//    implementation("androidx.compose.material:material:1.4.3")
//    implementation("androidx.activity:activity-compose:1.7.1")
//}