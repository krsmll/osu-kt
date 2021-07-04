import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val klaxonVersion = "5.5"
val jsoupVersion = "1.13.1"
val fuelVersion = "2.3.1"

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
    implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.2.0")
    implementation("commons-io:commons-io:2.6")
    implementation("org.apache.commons:commons-lang3:3.0")

    // Klaxon
    implementation("com.beust:klaxon:$klaxonVersion")

    // Jsoup
    implementation("org.jsoup:jsoup:$jsoupVersion")

    // Fuel
    implementation("com.github.kittinunf.fuel:fuel:$fuelVersion")
    implementation("com.github.kittinunf.fuel:fuel-json:$fuelVersion")
    implementation("com.github.kittinunf.result:result:4.0.0")
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClassName = "MainKt"
}