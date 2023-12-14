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
    // https://mvnrepository.com/artifact/org.jetbrains.kotlinx/kotlinx-coroutines-core
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")

}

tasks.test {
    useJUnitPlatform()
}


// Registro de tareas

tasks.register("tarea-tonta") {
    doLast {
        println("Haciendo tonterías")
    }
}

// Registro de tareas con metadatos

tasks.register("tarea-tonta2") {
    group = "Custom"
    description = "A lovely greeting task."
    doLast {
        println("Haciendo tonterías 2")
    }
}

// Clase de Definición de Tarea
abstract class HelloTask : DefaultTask() {
    @TaskAction
    fun hello() {
        println("hello from HelloTask")
    }
}

// Registro de tareas con clase
tasks.register<HelloTask>("hello-task") {
    group = "Custom tasks"
    description = "A lovely greeting task."
}

// Registro de tareas con dependencia builtin
tasks.register("hello-assemble") {
    group = "Custom"
    description = "A lovely greeting task."
    doLast {
        println("Hello world!")
    }
    dependsOn(tasks.assemble)
}

// Registro de tareas con dependencia a custom
tasks.register("hello-intro") {
    dependsOn("hello-assemble")
    doLast {
        println("I'm Gradle")
    }
}

// Registro de clase de tarea con Inputs
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
// Registro de tareas con clase e inputs
tasks.register<SlackTask>("slack") {
    messageText = "Hello there!"
    webhookUrl = "your webhook URL here"
}

// Ejemplos de plugins

// Plugin de definición de tarea
class GreetingPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.task("hello-plugin") {
            doLast {
                println("Hello from the GreetingPlugin")
            }
        }
    }
}

// Registro de plugin
apply<GreetingPlugin>()
// ahora puedo usar la tarea hello-plugin

// Definición de interfaz con Datos del plugin
interface GreetingPluginExtension {
    var message: Property<String>
}
// Definición de clase de plugin con uso del interfaz
class GreetingPlugin2 : Plugin<Project> {
    override fun apply(project: Project) {
        // Add the 'greeting' extension object
       project.task("hello-plugin2") {
            doLast {
                println("Hello from the GreetingPlugin2")
            }
        }
    }
}

// Registro de plugin
apply<GreetingPlugin2>()



kotlin {
    jvmToolchain(8)
}

application {
    mainClass.set("00_MainKt")
}