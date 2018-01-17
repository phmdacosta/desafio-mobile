package pedrodacosta.vitrine.desafio.desafiovitrineapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import pedrodacosta.vitrine.desafio.desafiovitrineapp.R
import pedrodacosta.vitrine.desafio.desafiovitrineapp.entities.Category

/**
 * Created by Pedro Henrique on 15/01/2018.
 */
class CategoriesAdapter(context: Context, listItens: List<Category>) : BaseAdapter(){

    private var context: Context
    private var inflater: LayoutInflater
    private var listItens: List<Category>

    init {
        this.context = context
        this.listItens = listItens
        inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val newConvertView: View
        val viewHolder: ViewHolder
        val category: Category = listItens.get(position)

        if (convertView == null) {
            viewHolder = ViewHolder()
            newConvertView = inflater.inflate(R.layout.item_category, parent, false)
            viewHolder.imgViewIconCategory = newConvertView.findViewById(R.id.icone_category) as ImageView
            viewHolder.textViewDescricaoCategory = newConvertView.findViewById(R.id.descricao_category) as TextView
        } else {
            newConvertView = convertView
            viewHolder = newConvertView.getTag() as ViewHolder
        }

        val iconItem: String? = category.image
        if (iconItem != null && iconItem.length > 0) {
            //TODO set image on category's ImageView
            //viewHolder.imgViewIconCategory.setVisibility(View.VISIBLE)
        }
        viewHolder.textViewDescricaoCategory.setText(category.name)

        return newConvertView
    }

    override fun getItem(position: Int): Any {
        return listItens.get(position)
    }

    override fun getItemId(position: Int): Long {
        return listItens.get(position).id;
    }

    override fun getCount(): Int {
        return listItens.size
    }

    private class ViewHolder() {
        lateinit var imgViewIconCategory: ImageView
        lateinit var textViewDescricaoCategory: TextView
    }
}