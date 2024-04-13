rootProject.name = "otus-kotlin-202402"

pluginManagement {
    plugins {
        kotlin("jvm")
    }
}

includeBuild("lessons")
includeBuild("task-manager")
includeBuild("build-plugin")