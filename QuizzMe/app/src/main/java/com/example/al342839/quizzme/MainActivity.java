package com.example.al342839.quizzme;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;

import android.util.Log;
import android.widget.GridView;


public class MainActivity extends AppCompatActivity {

    //GridView categoriasGridView;

    @Override
    public void onProvideAssistData(Bundle data) {
        super.onProvideAssistData(data);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MiBaseDeDatos MDB = new MiBaseDeDatos(getApplicationContext());
        // Escribimos 4 registros en nuestra tabla
        MDB.borrarCATEGORIAS();
        MDB.insertarCATEGORIA("Personajes");
        MDB.insertarCATEGORIA("YouTubers");
        MDB.insertarCATEGORIA("Amor");
        MDB.insertarCATEGORIA("Peliculas");


        // Recuperamos los 4 registros y los mostramos en el log
        int num = MDB.recuperarCATEGORIAS().size();

        Log.d("TOTAL", Integer.toString(num));
        int[] ids = new int[num];
        String[] nombres = new String[num];
        for (int i = 0; i < num; i++) {
            ids[i] = MDB.recuperarCATEGORIAS().get(i).getId();
            nombres[i] = MDB.recuperarCATEGORIAS().get(i).getNombre();
            Log.i(""+ids[i], nombres[i]);
        }

        /*categoriasGridView = (GridView) findViewById(R.id.categoriasGridVew);

        ListAdapter myImageAdapter = new ImageAdapter(this, R.layout.categoria_layout, categorias);
        categoriasGridView.setAdapter(myImageAdapter);



        categoriasGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String peli = categoriasGridView.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(),"Click en registro " + peli, Toast.LENGTH_SHORT).show();

                Intent i = new Intent(MainActivity.this,ImagenPelicula.class);
                i.putExtra("peli",peli);
                startActivity(i);


            }
        });*/




    }
}
