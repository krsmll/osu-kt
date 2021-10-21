import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.31"
    application
}

group = "me.krsmll"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.2.1")
    implementation("commons-io:commons-io:20030203.000550")
    implementation("org.apache.commons:commons-lang3:3.12.0")

    // Klaxon
    implementation("com.beust:klaxon:5.5")

    // Jsoup
    implementation("org.jsoup:jsoup:1.14.3")

    // Fuel
    implementation("com.github.kittinunf.fuel:fuel:2.3.1")
    implementation("com.github.kittinunf.fuel:fuel-json:2.3.1")
    implementation("com.github.kittinunf.result:result:5.2.0")
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClassName = "MainKt"
}