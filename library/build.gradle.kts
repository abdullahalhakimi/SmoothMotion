plugins {
    id("com.android.kotlin.multiplatform.library")
    alias(libs.plugins.jetbrains.kotlin.multiplatform)
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.jetbrains.kotlin.compose)
    id("maven-publish")
}

kotlin {
    android {
        namespace = "com.abdullahalhakimi.smoothmotion"
        compileSdk = 36
        minSdk = 24
    }

    listOf(
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "library"
            isStatic = true
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(libs.compose.runtime)
                implementation(libs.compose.foundation)
                implementation(libs.compose.material3)
                implementation(libs.compose.ui)
                implementation(libs.compose.animation)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
    }
}
