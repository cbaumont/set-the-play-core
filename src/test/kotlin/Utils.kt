import kotlinx.serialization.json.Json

val json = Json { ignoreUnknownKeys = true }

fun readFromResources(filename: String): String =
    object {}.javaClass.getResource("/$filename")
        ?.readText()
        ?: error("File not found: $filename")
