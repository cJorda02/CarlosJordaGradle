plugins {
    id("java")
    id("application")
}

group = "com.carlosjorda.tema4gradle"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    implementation(platform("dev.langchain4j:langchain4j-bom:1.10.0"))
    implementation("dev.langchain4j:langchain4j-open-ai")
    implementation("dev.langchain4j:langchain4j-open-ai:0.33.0")
    implementation("org.slf4j:slf4j-simple:2.0.7")
}

tasks.test {
    useJUnitPlatform()
}

application {
    // para poder ejecutar la app desde terminal
    mainClass.set("com.carlosjorda.tema4gradle.Main")
}

tasks.register<Exec>("ollamaVersion") {
    group = "verification" // Esto es opcional, para organizarlo en IntelliJ
    description = "Muestra la versión de Ollama instalada"

    // Configuración para Windows usando PowerShell
    commandLine("powershell", "-NoProfile", "-Command", "ollama --version")
}

tasks.register<Exec>("ollamaPs") {
    group = "verification"
    description = "Muestra los modelos de Ollama que están cargados actualmente en memoria"

    // Configuración para Windows usando PowerShell
    commandLine("powershell", "-NoProfile", "-Command", "ollama ps")
}

tasks.register("llmInfo") {
    group = "verification"
    description = "Ejecuta ollamaVersion, ollamaPs y muestra un mensaje final"

    // Definimos el orden: esta tarea DEPENDE de las otras dos
    dependsOn("ollamaVersion", "ollamaPs")

    // Esto se ejecuta DESPUÉS de las tareas de las que depende
    doLast {
        println("Demo finalizada")
    }
}