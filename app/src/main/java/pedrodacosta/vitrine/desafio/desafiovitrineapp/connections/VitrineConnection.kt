package pedrodacosta.vitrine.desafio.desafiovitrineapp.connections

import org.json.JSONObject
import pedrodacosta.vitrine.desafio.desafiovitrineapp.ConnecationListener
import pedrodacosta.vitrine.desafio.desafiovitrineapp.entities.Category
import pedrodacosta.vitrine.desafio.desafiovitrineapp.entities.ItemVitrine

/**
 * Created by Pedro Henrique on 15/01/2018.
 */
class VitrineConnection(listener: ConnecationListener) : Connection(listener) {

    override fun getUrl(): String {
        return "https://desafio.mobfiq.com.br/Search/Criteria"
    }

    override fun getMethod(): String {
        return "POST"
    }

    override fun parseResult(json: String?): Any? {
        try {
            val listVitrine: ArrayList<ItemVitrine> = ArrayList<ItemVitrine>()

            val jsonObject: JSONObject = JSONObject(json)
            val jArrayItems = jsonObject.getJSONArray("Categories")
            if (jArrayItems.length() > 0) {
                for (i in 0..(jArrayItems.length() - 1)) {
                    listVitrine.add(ItemVitrine(jArrayItems.getJSONObject(i)))
                }
            }

            return listVitrine

        } catch (e: Exception) {

        }

        return null
    }
}