import model.Person

fun main() {
    val jsonNodeHandsOn = JsonNodeHandsOn()
    serializeDeserializeJson(jsonNodeHandsOn)
    jsonNodeHandsOn.serializeMapToJsonNode()
    jsonToDataClassExample(jsonNodeHandsOn)
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
