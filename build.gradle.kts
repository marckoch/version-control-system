import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.10"
    application
}

group = "me.marckoch"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

// special treatment because we receive input from StdIn
val run by tasks.getting(JavaExec::class) {
    standardInput = System.`in`
}

application {
    mainClassName = (properties["mainClass"] ?: "stage1.MainKt") as String
}