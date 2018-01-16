package pedrodacosta.vitrine.desafio.desafiovitrineapp.connections

import org.json.JSONObject
import pedrodacosta.vitrine.desafio.desafiovitrineapp.ConnecationListener
import pedrodacosta.vitrine.desafio.desafiovitrineapp.entities.Category

/**
 * Created by Pedro Henrique on 15/01/2018.
 */
class CategoriesConnection(listener: ConnecationListener) : Connection(listener) {

    override fun getUrl(): String {
        return "https://desafio.mobfiq.com.br/StorePreference/CategoryTree"
    }

    override fun getMethod(): String {
        return "GET"
    }

    override fun parseResult(json: String?): Any? {
        try {
            val listCategories: ArrayList<Category> = ArrayList<Category>()

            val jsonObject: JSONObject = JSONObject(json)
            val jArrayCategories = jsonObject.getJSONArray("Categories")
            if (jArrayCategories.length() > 0) {
                for (i in 0..(jArrayCategories.length() - 1)) {
                    listCategories.add(Category(jArrayCategories.getJSONObject(i)))
                }
            }

            return listCategories

        } catch (e: Exception) {

        }

        return null
    }
}