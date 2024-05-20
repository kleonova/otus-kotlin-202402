plugins {
    alias(libs.plugins.kotlin.jvm)
    id("build-jvm")
}

group = "ru.lev.otus.kotlin.food.delivery"
version = "1.0-SNAPSHOT"

allprojects {
    repositories {
        mavenCentral()
    }
}

subprojects {
    group = rootProject.group
    version = rootProject.version
}

dependencies {
    testImplementation(kotlin("test-junit"))
}