import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.schibsted.spt.data.jslt.Parser
import java.io.File
import java.io.FileReader

class JsltHandsOn {

    fun transformJsonContent(): JsonNode {
        val jsonString = FileReader(File("src/main/resources/sample.json")).readText()
        val jsonMap = jacksonObjectMapper().readValue<Map<String, Any>>(jsonString)


        val jsltString = FileReader(File("src/main/resources/sample.jslt")).readText()
        val jsltExpression = Parser.compileString(jsltString)

        val jsltMap = mapOf("props" to jsonMap)
        val jsonNode = jacksonObjectMapper().convertValue(jsltMap, JsonNode::class.java)

        val transformedJsonNode = jsltExpression.apply(jsonNode)
        println("The transformed JsonNode --> $transformedJsonNode")
        return transformedJsonNode
    }
}