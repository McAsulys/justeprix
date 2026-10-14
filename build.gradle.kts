plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.compose.multiplatform)
}

kotlin {
    jvmToolchain(21)
}

dependencies {
    implementation(compose.desktop.currentOs)
    implementation(compose.material3)
    implementation(libs.kotlinx.coroutines.swing)
    testImplementation(kotlin("test"))
    testImplementation(libs.junit.jupiter)
}

compose.desktop {
    application {
        mainClass = "MainKt"
    }
}

tasks.test { useJUnitPlatform() }
