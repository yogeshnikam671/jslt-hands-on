plugins {
    kotlin("jvm") version "1.8.21"
    application
}

group = "org.yogesh"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.schibsted.spt.data:jslt:0.1.14")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.9.4.1")

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(11)
}

application {
    mainClass.set("MainKt")
}