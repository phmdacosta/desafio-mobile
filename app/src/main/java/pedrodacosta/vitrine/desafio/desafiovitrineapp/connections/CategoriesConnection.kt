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
//        return "https://api.github.com/users/dmnugent80/repos"
    }

    override fun getMethod(): String {
        return "GET"
    }

    override fun parseResult(json: String?): ArrayList<Category>? {
        val listCategories: ArrayList<Category> = ArrayList<Category>()

        try {
            val jsonObject = JSONObject(json)
            if (!jsonObject.isNull("Categories")) {
                val jArrayCategories = jsonObject.getJSONArray("Categories")
                if (jArrayCategories.length() > 0) {
                    for (i in 0..(jArrayCategories.length() - 1)) {
                        listCategories.add(Category(jArrayCategories.getJSONObject(i)))
                    }
                }
            }

        } catch (e: Exception) {

        }

        return listCategories
    }
}