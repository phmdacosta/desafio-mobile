package pedrodacosta.vitrine.desafio.desafiovitrineapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class VitrineActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.vitrine)

        /*
        GridView gridview = (GridView) findViewById(R.id.gridview);

                List<ItemObject> allItems = getAllItemObject();
                CustomAdapter customAdapter = new CustomAdapter(MainActivity.this, allItems);
                gridview.setAdapter(customAdapter);

                gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Toast.makeText(MainActivity.this, "Position: " + position, Toast.LENGTH_SHORT).show();
                    }
                });
        */

        /*
        Conexão

        vitrineConnection: VitrineConnection = VitrineConnection()
        vitrineConnection.iniciar()
        */
    }

//    fun connectionReturn(connection: Connection) {
//        val listItemsVitrine: List<ItemVitrine> = conneciton.result() as List<ItemVitrine>
//        val gridView: GridView = findViewById(R.id.grid_view_vitrine) as GridView
//        val vitrineAdapter: VitrineAdapter = VitrineAdapter(this, listItemsVitrine)
//        gridview.setAdapter(vitrineAdapter)
//    }
}
