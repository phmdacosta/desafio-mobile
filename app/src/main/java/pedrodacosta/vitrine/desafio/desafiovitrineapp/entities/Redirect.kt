package pedrodacosta.vitrine.desafio.desafiovitrineapp.entities

/**
 * Created by Pedro Henrique on 14/01/2018.
 */
class Redirect {
    var id: Long = 0
    var title: String? = ""
        get() {
            if (field == null)
                return ""

            return field
        }
    var searchCriteria: SearchCriteria? = SearchCriteria()
    var type: Int = 0
}