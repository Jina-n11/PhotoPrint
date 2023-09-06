@file:Suppress("DSL_SCOPE_VIOLATION")
//
//group = "org.thechance"
//version = "1.0-SNAPSHOT"

allprojects {
    repositories {
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}

plugins {
//    alias(libs.plugins.buildProperties)
    alias(libs.plugins.kotlin.multiplatform) apply false
    alias(libs.plugins.kotlin.native.cocoapods) apply false
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.jetbrains.compose)
}


//plugins {
//    alias(libs.plugins.multiplatform).apply(false)
//    alias(libs.plugins.compose).apply(false)
//    alias(libs.plugins.cocoapods).apply(false)
//    alias(libs.plugins.android.application).apply(false)
//    alias(libs.plugins.kotlinx.serialization).apply(false)
//}

//plugins {
//    //trick: for the same plugin versions in all sub-modules
//    id("com.android.application").version("8.0.0").apply(false)
//    id("com.android.library").version("8.0.0").apply(false)
//    kotlin("android").version("1.8.21").apply(false)
//    kotlin("multiplatform").version("1.8.21").apply(false)
//}
//
//tasks.register("clean", Delete::class) {
//    delete(rootProject.buildDir)
//}
