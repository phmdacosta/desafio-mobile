package pedrodacosta.vitrine.desafio.desafiovitrineapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import pedrodacosta.vitrine.desafio.desafiovitrineapp.R
import pedrodacosta.vitrine.desafio.desafiovitrineapp.entities.ItemVitrine

/**
 * Created by Pedro Henrique on 14/01/2018.
 */
class VitrineAdapter(context: Context, listItens: List<ItemVitrine>) : BaseAdapter() {

    private var context: Context
    private var inflater: LayoutInflater
    private var listItens: List<ItemVitrine>

    init {
        this.context = context
        this.listItens = listItens
        inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val newConvertView: View
        val viewHolder: ViewHolder
        val itemVitrine = listItens.get(position)

//        if (convertView == null) {
            viewHolder = ViewHolder()
            newConvertView = inflater.inflate(R.layout.item_vitrine, parent, false)
            viewHolder.imgViewIconDesconto = newConvertView.findViewById(R.id.icone_desconto) as ImageView
            viewHolder.imgViewBotaoFavorito = newConvertView.findViewById(R.id.botao_favorito) as ImageButton
            viewHolder.imgViewImgItemVitrine = newConvertView.findViewById(R.id.imagem_item_vitrine) as ImageView
            viewHolder.textViewDescricaoItem = newConvertView.findViewById(R.id.descricao_item_vitrine) as TextView
            viewHolder.textViewValorItem = newConvertView.findViewById(R.id.valor_item_vitrine) as TextView
//        } else {
//            newConvertView = convertView
//            viewHolder = newConvertView.getTag() as ViewHolder
//        }

        Picasso.with(context)
                .load(itemVitrine.imgItemVitrine)
                .into(viewHolder.imgViewImgItemVitrine)

        viewHolder.textViewDescricaoItem.setText(itemVitrine.name)
        viewHolder.textViewValorItem.setText("R$ " + itemVitrine.valorItem.toString())

        return newConvertView
    }

    override fun getItem(position: Int): Any {
        return listItens.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong();
    }

    override fun getCount(): Int {
        return listItens.size
    }

    private class ViewHolder() {
        lateinit var imgViewIconDesconto: ImageView
        lateinit var imgViewBotaoFavorito: ImageButton
        lateinit var imgViewImgItemVitrine: ImageView
        lateinit var textViewDescricaoItem: TextView
        lateinit var textViewValorItem: TextView
    }
}