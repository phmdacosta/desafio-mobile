package pedrodacosta.vitrine.desafio.desafiovitrineapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.GridView
import android.widget.ListView
import android.widget.ProgressBar
import android.widget.TextView
import pedrodacosta.vitrine.desafio.desafiovitrineapp.adapters.CategoriesAdapter
import pedrodacosta.vitrine.desafio.desafiovitrineapp.adapters.VitrineAdapter
import pedrodacosta.vitrine.desafio.desafiovitrineapp.connections.VitrineConnection
import pedrodacosta.vitrine.desafio.desafiovitrineapp.entities.Category
import pedrodacosta.vitrine.desafio.desafiovitrineapp.entities.ItemVitrine

class VitrineActivity : AppCompatActivity(), ConnecationListener {

    lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.vitrine)

        progressBar = findViewById(R.id.progressbar_vitrine) as ProgressBar

        val vitrineConnection = VitrineConnection(this, "")
        vitrineConnection.execute()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = getMenuInflater()
        inflater.inflate(R.menu.options, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item != null && item.itemId == R.id.filtrar) {
            val intent = Intent(this, CategoriesActivity::class.java)
            startActivity(intent)
        }

        return true
    }

    override fun getConnectionResult(result: Any?) {
        val listItemsVitrine: List<ItemVitrine> = result as List<ItemVitrine>

        progressBar.visibility = View.GONE

        if (listItemsVitrine.isEmpty()) {
            val textViewSemProdutos: TextView = findViewById(R.id.sem_produtos_vitrine) as TextView
            textViewSemProdutos.visibility = View.VISIBLE
        } else {
            val gridView: GridView = findViewById(R.id.grid_view_vitrine) as GridView
            val vitrineAdapter = VitrineAdapter(this, listItemsVitrine)
            gridView.setAdapter(vitrineAdapter)
            gridView.visibility = View.VISIBLE
        }
    }
}
