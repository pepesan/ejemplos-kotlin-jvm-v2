plugins {
    kotlin("jvm") version "1.9.0"
    application
}

group = "com.cursosdedesarrollo"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    // https://mvnrepository.com/artifact/com.google.code.gson/gson
    implementation("com.google.code.gson:gson:2.10.1")
    // https://mvnrepository.com/artifact/io.github.microutils/kotlin-logging-jvm
    implementation("io.github.microutils:kotlin-logging-jvm:3.0.5")
    // https://mvnrepository.com/artifact/org.slf4j/slf4j-api
    implementation("org.slf4j:slf4j-api:2.0.9")
    // https://mvnrepository.com/artifact/org.slf4j/slf4j-simple
    implementation("org.slf4j:slf4j-simple:2.0.9")

    // https://mvnrepository.com/artifact/ch.qos.logback/logback-classic
    implementation("ch.qos.logback:logback-classic:1.4.11")

    // https://mvnrepository.com/artifact/com.mysql/mysql-connector-j
    implementation("com.mysql:mysql-connector-j:8.0.33")

}

tasks.test {
    useJUnitPlatform()
}



tasks.register("tarea-tonta") {
    doLast {
        println("Haciendo tonterías")
    }
}

tasks.register("tarea-tonta2") {
    group = "Custom"
    description = "A lovely greeting task."
    doLast {
        println("Haciendo tonterías 2")
    }
}

abstract class HelloTask : DefaultTask() {
    @TaskAction
    fun hello() {
        println("hello from HelloTask")
    }
}
tasks.register<HelloTask>("hello-task") {
    group = "Custom tasks"
    description = "A lovely greeting task."
}

tasks.register("hello-assemble") {
    group = "Custom"
    description = "A lovely greeting task."
    doLast {
        println("Hello world!")
    }
    dependsOn(tasks.assemble)
}
tasks.register("hello-intro") {
    dependsOn("hello-assemble")
    doLast {
        println("I'm Gradle")
    }
}


open class SlackTask : DefaultTask() {
    @Input
    var messageText: String = ""
    @Input
    var webhookUrl: String = ""

    @TaskAction
    fun showMessage() {
        println("hello from HelloTask message: $messageText  url: $webhookUrl")
    }
}
tasks.register<SlackTask>("slack") {
    messageText = "Hello there!"
    webhookUrl = "your webhook URL here"
}
kotlin {
    jvmToolchain(8)
}

application {
    mainClass.set("00_MainKt")
}