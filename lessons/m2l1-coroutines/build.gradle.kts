plugins {
    kotlin("jvm") version libs.versions.kotlin.get()
}

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation(kotlin("test-junit"))

    implementation(libs.kotlinx.coroutines)

    // Homework Hard
    implementation(libs.jackson.kotlin) // from string to object
    implementation(libs.okhttp) // http client
}
