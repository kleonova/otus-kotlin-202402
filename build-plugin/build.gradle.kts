plugins {
    `kotlin-dsl`
}

group = "ru.lev.otuskotlin.buildplugin"
version = "1.0-SNAPSHOT"

gradlePlugin {
    plugins {
        register("build-jvm") {
            id = "build-jvm"
            implementationClass = "ru.lev.otuskotlin.buildplugin.BuildPluginJvm"
        }
        register("build-kmp") {
            id = "build-kmp"
            implementationClass = "ru.lev.otuskotlin.buildplugin.BuildPluginMultiplatform"
        }
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin")
}

