//rootProject.name = "PhotoChance"
//include(":composeApp")
//
//pluginManagement {
//    repositories {
//        google()
//        gradlePluginPortal()
//        mavenCentral()
//        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
//    }
//}
//
//dependencyResolutionManagement {
//    repositories {
//        google()
//        mavenCentral()
//        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
//    }
//}



rootProject.name = "PhotoPrint"
include(":androidApp")
include(":shared")

pluginManagement {
    repositories {
        gradlePluginPortal()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        google()
    }

    plugins {
        val kotlinVersion = extra["kotlin.version"] as String
        val agpVersion = extra["agp.version"] as String
        val composeVersion = extra["compose.version"] as String

        kotlin("jvm").version(kotlinVersion)
        kotlin("multiplatform").version(kotlinVersion)
        kotlin("android").version(kotlinVersion)

        id("com.android.application").version(agpVersion)
        id("com.android.library").version(agpVersion)

        id("org.jetbrains.compose").version(composeVersion)
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}



//pluginManagement {
//    repositories {
//        google()
//        gradlePluginPortal()
//        mavenCentral()
//    }
//}
//
//dependencyResolutionManagement {
//    repositories {
//        google()
//        mavenCentral()
//    }
//}
//
//rootProject.name = "PhotoPrint"
//include(":androidApp")
//include(":shared")


