plugins {
    kotlin("jvm")
}

group = "ru.lev.otuskotlin.taskmanager"
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