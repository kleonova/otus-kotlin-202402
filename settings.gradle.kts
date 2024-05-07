rootProject.name = "otus-kotlin-202402"

pluginManagement {
    plugins {
        kotlin("jvm")
    }
}
plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}

includeBuild("lessons")
includeBuild("food-delivery")
