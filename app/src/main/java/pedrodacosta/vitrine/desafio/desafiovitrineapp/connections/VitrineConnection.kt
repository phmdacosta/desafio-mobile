package pedrodacosta.vitrine.desafio.desafiovitrineapp.connections

import org.json.JSONObject
import pedrodacosta.vitrine.desafio.desafiovitrineapp.ConnecationListener
import pedrodacosta.vitrine.desafio.desafiovitrineapp.entities.Category
import pedrodacosta.vitrine.desafio.desafiovitrineapp.entities.ItemVitrine

/**
 * Created by Pedro Henrique on 15/01/2018.
 */
class VitrineConnection(listener: ConnecationListener, query: String) : Connection(listener) {

    val query: String

    init {
        this.query = query
    }

    override fun getUrl(): String {
        return "https://desafio.mobfiq.com.br/Search/Criteria"
    }

    override fun getMethod(): String {
        return "POST"
    }

    override fun getBodyRequest(): String {
        return "{\n" +
                "  \"Query\" : \"" + query + "\",\n" +
                "  \"Offset\": 0,\n" +
                "  \"Size\": 10\n" +
                "} "
    }

    override fun parseResult(json: String?): ArrayList<ItemVitrine> {
        val listVitrine: ArrayList<ItemVitrine> = ArrayList<ItemVitrine>()

        try {
            val jsonObject: JSONObject = JSONObject(json)
            val jArrayItems = jsonObject.getJSONArray("Products")
            if (jArrayItems.length() > 0) {
                for (i in 0..(jArrayItems.length() - 1)) {
                    listVitrine.add(ItemVitrine(jArrayItems.getJSONObject(i)))
                }
            }

        } catch (e: Exception) {

        }

        return listVitrine
    }
}