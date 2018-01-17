package pedrodacosta.vitrine.desafio.desafiovitrineapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridView
import android.widget.ListView
import pedrodacosta.vitrine.desafio.desafiovitrineapp.adapters.CategoriesAdapter
import pedrodacosta.vitrine.desafio.desafiovitrineapp.adapters.VitrineAdapter
import pedrodacosta.vitrine.desafio.desafiovitrineapp.connections.VitrineConnection
import pedrodacosta.vitrine.desafio.desafiovitrineapp.entities.Category
import pedrodacosta.vitrine.desafio.desafiovitrineapp.entities.ItemVitrine

class VitrineActivity : AppCompatActivity(), ConnecationListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.vitrine)

        val vitrineConnection = VitrineConnection(this, "")
        vitrineConnection.execute()
    }

    override fun getConnectionResult(result: Any?) {
        val listItemsVitrine: List<ItemVitrine> = result as List<ItemVitrine>
        val gridView: GridView = findViewById(R.id.grid_view_vitrine) as GridView
        val vitrineAdapter = VitrineAdapter(this, listItemsVitrine)
        gridView.setAdapter(vitrineAdapter)
    }
}
