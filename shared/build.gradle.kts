@file:Suppress("DSL_SCOPE_VIOLATION")

//plugins {
//    kotlin("multiplatform")
//    id("com.android.library")
//}

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kotlin.native.cocoapods)
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.kotlinKsp)
    id("io.realm.kotlin") version "1.10.0"
    kotlin("plugin.serialization") version "1.9.0"
}


@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    targetHierarchy.default()

    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }

    jvm("desktop")

    listOf(
        /* App Store */
        iosArm64(),
        /* Apple Silicon iOS Simulator */
        iosSimulatorArm64(),
        /* Intel macOS Devices */
     //   macosX64()
    ).forEach {

        it.binaries.framework {
            baseName = "shared"
        }
    }

    cocoapods {
        version = "1.0.0"
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        ios.deploymentTarget = libs.versions.ios.deploymentTarget.get()
//        podfile = project.file("../iosApp/Podfile")
        framework {
            baseName = "shared"
            isStatic = true
        }
        extraSpecAttributes["resources"] = "['src/commonMain/resources/**', 'src/iosMain/resources/**','../../design_system/shared/src/commonMain/resources/**']"
    }

//    listOf(
//        iosX64(),
//        iosArm64(),
//        iosSimulatorArm64()
//    ).forEach {
//        it.binaries.framework {
//            baseName = "shared"
//        }
//    }

    sourceSets {
        all {
            languageSettings {
                optIn("org.jetbrains.compose.resources.ExperimentalResourceApi")
            }
        }

        val commonMain by getting {
            dependencies {
                implementation(libs.compose.runtime)
                implementation(libs.compose.foundation)
                implementation(libs.compose.material3)
                api(libs.compose.image.loader)

                implementation(libs.compose.components.resources)
                api(libs.compose.image.loader)
                implementation(libs.kotlinx.datetime)

                // voyager
                implementation(libs.bundles.voyager)
                implementation(libs.voyager.tab.navigator)

                implementation(libs.kotlin.coroutines)
                api(libs.koin.core)
                implementation(libs.koin.annotations)
                implementation(libs.koin.compose)
//                implementation(project(":design_system:shared"))
                //realm db
                implementation(libs.realm.library.base)
                //ktor-client
                implementation(libs.ktor.client.core)
                implementation(libs.ktor.json.serialization)
                implementation(libs.ktor.content.negotiation)
                implementation(libs.ktor.logging)
                implementation(libs.ktor.client.cio)
                implementation(libs.kotlin.serialization)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
    }
}

android {
    namespace = "com.jinana11.photoprint"
    compileSdk = 33
    defaultConfig {
        minSdk = 24
    }
}