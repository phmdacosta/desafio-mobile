package pedrodacosta.vitrine.desafio.desafiovitrineapp.entities

import org.json.JSONObject

/**
 * Created by Pedro Henrique on 14/01/2018.
 */
class Category {

    var id: Long = 0
    var name: String = ""
    var image: String? = ""
        get() {
            if (field == null)
                return ""

            return field
        }
    var redirect: Redirect? = Redirect()
    var listSubCategories: ArrayList<Category> = ArrayList<Category>()
        get() {
            return field
        }

    init {
    }

    constructor(jObjectCategory: JSONObject) {
        if (jObjectCategory.isNull("Id"))
            this.id = jObjectCategory.getLong("Id")

        if (jObjectCategory.isNull("Name"))
            this.name = jObjectCategory.getString("Name")

        if (jObjectCategory.isNull("Image"))
            this.image = jObjectCategory.getString("Image")

        if (jObjectCategory.isNull("SubCategories")) {
            val jArraySubCategories = jObjectCategory.getJSONArray("SubCategories")
            for (j in 0..(jArraySubCategories.length() - 1)) {
                val subCategory: Category = Category(jArraySubCategories.getJSONObject(j))
                this.listSubCategories.add(subCategory)
            }
        }
    }
}