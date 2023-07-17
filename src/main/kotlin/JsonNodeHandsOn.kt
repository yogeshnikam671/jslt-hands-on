import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import model.Person
import java.io.File
import java.io.FileReader

class JsonNodeHandsOn {

    fun getJsonNodeFromJson(): JsonNode {
        val sampleFile = File("src/main/resources/sample.json")
        val jsonString = FileReader(sampleFile).readText()

        // errors have to be handled as well. runCatching is a concise way to handle them.
        // explore runCatching in kotlin
        val jsonNode = jacksonObjectMapper().readTree(jsonString) // we can even pass the sampleFile

        println("---- Serialize and Deserialize JSON ----")
        accessAndPrintJsonNodeElements(jsonNode)
        return jsonNode
    }

    fun getJsonStringFromJsonNode(jsonNode: JsonNode): String {
        return jacksonObjectMapper().writeValueAsString(jsonNode)
    }

    fun serializeMapToJsonNode() {
        val map = mapOf(
            "a" to 1,
            "b" to 2
        )
        val jsonNode = jacksonObjectMapper().convertValue(map, JsonNode::class.java)
        println("---- Serialize Map to JsonNode ----")
        println(jsonNode.get("a"))
        println(jsonNode.get("b"))
        println()
    }

    fun getDataClassFromJsonNode(jsonNode: JsonNode, clazz: Class<Person>): Person {
        return jacksonObjectMapper().convertValue(jsonNode, clazz)
    }

    private fun accessAndPrintJsonNodeElements(jsonNode: JsonNode) {
        println("Name : ${jsonNode.get("name")}")
        println("Age : ${jsonNode.get("age")}")
        println("Hobbies: ")
        jsonNode.get("hobbies").forEachIndexed { index, it ->
            println("${index + 1}. ${it.asText()}")
        }
        println("PinCode: ${jsonNode["address"]["pinCode"].asInt()}\n")
    }
}