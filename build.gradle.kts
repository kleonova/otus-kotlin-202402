plugins {
    kotlin("jvm") version libs.versions.kotlin.get()
}

group = "ru.lev.otuskotlin"
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