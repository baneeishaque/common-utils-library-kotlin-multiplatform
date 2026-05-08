import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi

plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    alias(libs.plugins.androidLibrary)
}

group = "ndk.banee"
version = "1.0-SNAPSHOT"

val BASE_NAME = "common_lib"

@OptIn(ExperimentalKotlinGradlePluginApi::class)
kotlin {

    applyDefaultHierarchyTemplate()

    jvm {
//        jvmToolchain(20)
        testRuns["test"].executionTask.configure {
            useJUnitPlatform()
        }
    }

    android {
        namespace = "ndk.banee.common_library"
        compileSdk = 34
        minSdk = 24
        compilerOptions {
            jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17)
        }
    }

    mingwX64 {
        binaries {
            sharedLib {
                //TODO : Rename sub module to avoid basename property
                baseName = BASE_NAME
            }
        }
    }

    /*linuxX64 {
        binaries {
            sharedLib {
                baseName = BASE_NAME
            }
        } 
    }*/

    sourceSets.all {
        languageSettings.apply {
            languageVersion = "2.4"
            apiVersion = "2.4"
            progressiveMode = true
            optIn("ExperimentalStdlibApi,ExperimentalEncodingApi")
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.11.0")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.11.0")
                implementation(project.dependencies.platform("io.ktor:ktor-bom:3.5.0-eap-1611"))
                implementation("io.ktor:ktor-client-core")
                implementation("io.ktor:ktor-client-auth")
                implementation("io.ktor:ktor-client-content-negotiation")
                implementation("io.ktor:ktor-client-logging")
                implementation("io.ktor:ktor-serialization-kotlinx-json")
                implementation("com.soywiz.korlibs.klock:klock:4.0.10")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val mingwX64Main by getting {
            dependencies {
//                implementation("io.ktor:ktor-client-curl")
                implementation("io.ktor:ktor-client-winhttp")
            }
        }
        /*val linuxX64Main by getting {
            dependencies {
                implementation("io.ktor:ktor-client-curl")
                // implementation("io.ktor:ktor-client-cio")
            }
        }*/
    }

}
