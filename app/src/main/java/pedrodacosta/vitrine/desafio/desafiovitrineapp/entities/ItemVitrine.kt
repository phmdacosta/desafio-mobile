package pedrodacosta.vitrine.desafio.desafiovitrineapp.entities

import org.json.JSONObject

/**
 * Created by Pedro Henrique on 14/01/2018.
 */
class ItemVitrine {
    var id: Long = 0
    lateinit var name: String
    lateinit var iconDesconto: String
    lateinit var buttonFavorito: String
    lateinit var imgItemVitrine: String
    lateinit var descricaoItem: String
    var valorItem: Double = 0.0

    constructor(jObjectItemVitrine: JSONObject) {
        val jObjectSkus = jObjectItemVitrine.getJSONArray("Skus").getJSONObject(0)

        if (!jObjectSkus.isNull("Id"))
            this.id = jObjectSkus.getLong("Id")

        if (!jObjectSkus.isNull("Name"))
            this.name = jObjectSkus.getString("Name")

//        if (!jObjectItemVitrine.isNull(""))
//            this.iconDesconto = jObjectItemVitrine.getString("")

//        if (!jObjectItemVitrine.isNull(""))
//            this.buttonFavorito = jObjectItemVitrine.getString("")

        if (!jObjectSkus.isNull("Images")){
            val jObjectImagem = jObjectSkus.getJSONArray("Images").getJSONObject(0)
            this.imgItemVitrine = jObjectImagem.getString("ImageUrl")
        }

        if (!jObjectItemVitrine.isNull("Description")) {
            this.descricaoItem = jObjectItemVitrine.getString("Description")
        }

        if (!jObjectSkus.isNull("Sellers")) {
            val jObjectSeller = jObjectSkus.getJSONArray("Sellers").getJSONObject(0)
            this.valorItem = jObjectSeller.getDouble("Price")
        }
    }
}