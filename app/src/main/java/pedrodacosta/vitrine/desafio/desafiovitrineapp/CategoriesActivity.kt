package pedrodacosta.vitrine.desafio.desafiovitrineapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ListView
import org.json.JSONObject
import pedrodacosta.vitrine.desafio.desafiovitrineapp.adapters.CategoriesAdapter
import pedrodacosta.vitrine.desafio.desafiovitrineapp.connections.CategoriesConnection
import pedrodacosta.vitrine.desafio.desafiovitrineapp.entities.Category
import pedrodacosta.vitrine.desafio.desafiovitrineapp.entities.ItemVitrine

/**
 * Created by Pedro Henrique on 15/01/2018.
 */
class CategoriesActivity : AppCompatActivity(), ConnecationListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.categories)

        val categoriesConnection: CategoriesConnection = CategoriesConnection(this)
        categoriesConnection.execute()
    }

    override fun getConnectionResult(result: Any?) {
        val listCategories: ArrayList<Category> = result as ArrayList<Category>
        val listView: ListView = findViewById(R.id.list_categories) as ListView
        val categoriesAdapter: CategoriesAdapter = CategoriesAdapter(this, listCategories)
        listView.setAdapter(categoriesAdapter)
    }
}