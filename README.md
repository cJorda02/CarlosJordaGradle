# CarlosJordaGradle - Integración con LLM Local 🤖✨

Este proyecto es una aplicación de consola desarrollada en Java como parte de la asignatura de *Entornos de Desarrollo*. El objetivo principal es aprender a gestionar *Gradle* `(Kotlin DSL)`, y generar una conversación interactiva con *IA* a través de `LangChain4j`. Además, se automatizan procesos del sistema.

## 🚀 Funcionalidades
La aplicación permite interactuar con modelos de Inteligencia Artificial ejecutados localmente, garantizando privacidad y rendimiento:

- **Conexión con Ollama**: Comunicación fluida con el servidor local de Ollama para ejecutar modelos como **llama3.1:8b**.
- **Interacción con LLM**: Envío de prompts y recepción de respuestas en tiempo real con la **IA** mediante el modelo de chat.
- **Automatización de Tareas**: Scripts personalizados en **Gradle** para verificar el estado del sistema de IA sin salir del entorno de desarrollo.
- **Soporte Multiplataforma**: Lógica inteligente que detecta el Sistema Operativo (Windows vs Linux) para ejecutar comandos de terminal de forma compatible.

## 📦 Gestión con Gradle
A diferencia de Maven, este proyecto utiliza **Gradle** (Kotlin DSL) para una configuración más flexible y potente en el archivo build.gradle.kts:

- **LangChain4j** (OpenAI Module):
  - *Uso*: Facilita la conexión con la API compatible de **Ollama**.
  - *Dependencia*: `dev.langchain4j:langchain4j-open-ai`.

- **SLF4J Simple**:
  - *Uso*: Gestión de logs para monitorizar el comportamiento interno de la librería y evitar avisos de configuración.

- **Plugin Application**:
  - *Uso*: Permite ejecutar el programa directamente con `./gradlew run` desde la terminal.

## 🛠️ Comandos y Automatización
Se han implementado tareas personalizadas de tipo Exec para facilitar el flujo de trabajo:

- **Git y GitHub**:
   - *Inicialización*: `git init` y creación del repositorio.
   - *Remotos*: Vinculación con GitHub (`git remote add origin ...`).
   - *Historial*: Realización de commits atómicos con mensajes descriptivos.
   - *Sincronización*: Subida de código mediante `git push`.
     
- **Métodos en `build.gradle.kts`**:
  - *`.\gradlew ollamaVersion`*: Comprueba si **Ollama** está instalado y responde correctamente.
  - *`.\gradlew ollamaPs`*: Muestra los modelos que están cargando memoria RAM en ese momento.
  - *`.\gradlew llmInfo`*: Una tarea combinada que ejecuta las anteriores y confirma la finalización de la demo, adaptándose automáticamente a PowerShell o Bash.
