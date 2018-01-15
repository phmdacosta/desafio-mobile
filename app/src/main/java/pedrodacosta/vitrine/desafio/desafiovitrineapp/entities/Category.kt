package pedrodacosta.vitrine.desafio.desafiovitrineapp.entities

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
    var listSubCategories: List<Category>? = ArrayList<Category>()
        get() {
            if (field == null)
                return ArrayList<Category>()

            return field
        }
}