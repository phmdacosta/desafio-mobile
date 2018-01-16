package pedrodacosta.vitrine.desafio.desafiovitrineapp.entities

import org.json.JSONObject

/**
 * Created by Pedro Henrique on 14/01/2018.
 */
class ItemVitrine {
    lateinit var iconDesconto: String
    lateinit var buttonFavorito: String
    lateinit var imgItemVitrine: String
    lateinit var descricaoItem: String
    lateinit var valorItem: String

    constructor(jObjectItemVitrine: JSONObject) {
        if (jObjectItemVitrine.isNull(""))
            this.iconDesconto = jObjectItemVitrine.getString("")

        if (jObjectItemVitrine.isNull(""))
            this.buttonFavorito = jObjectItemVitrine.getString("")

        if (jObjectItemVitrine.isNull(""))
            this.imgItemVitrine = jObjectItemVitrine.getString("")

        if (jObjectItemVitrine.isNull("")) {
            this.descricaoItem = jObjectItemVitrine.getString("")
        }

        if (jObjectItemVitrine.isNull("")) {
            this.valorItem = jObjectItemVitrine.getString("")
        }
    }
}