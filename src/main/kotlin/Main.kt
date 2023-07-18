import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import model.Person
import model.TransformedPerson

fun main() {
    val jsltHandsOn = JsltHandsOn()
    val transformedContentNode = jsltHandsOn.transformJsonContent()
    val transformedContent = jacksonObjectMapper().convertValue(
        transformedContentNode,
        TransformedPerson::class.java
    )
    println("Jslt transformed content --> $transformedContent")
}

fun serializeDeserializeJson(jsonNodeHandsOn: JsonNodeHandsOn) {
    val jsonNode = jsonNodeHandsOn.getJsonNodeFromJson()
    val jsonString = jsonNodeHandsOn.getJsonStringFromJsonNode(jsonNode)

    println("The jsonNode --> $jsonNode")
    println("The jsonString --> $jsonString\n")
}

fun jsonToDataClassExample(jsonNodeHandsOn: JsonNodeHandsOn) {
    val jsonNode = jsonNodeHandsOn.getJsonNodeFromJson()
    val person = jsonNodeHandsOn.getDataClassFromJsonNode(jsonNode, Person::class.java)
    println("---- Person converted from JsonNode ----")
    println(person)
}
