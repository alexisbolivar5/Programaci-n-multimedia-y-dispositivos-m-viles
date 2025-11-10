package com.example.intento;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MiAdapter adapter;
    private List<data> listaPeliculas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        listaPeliculas = new ArrayList<>();

        listaPeliculas.add(new data("Los caballeros de la mesa cuadrada", "Terry Jones " , R.drawable.cuadrada));
        listaPeliculas.add(new data("Los juegos del desmadre", "David Zucker",R.drawable.desmadre));
        listaPeliculas.add(new data("Dragones y Mazmorras: honor entre ladrones", "John Francis Daley",R.drawable.dungeons_dragons_honor_entre_ladrones));
        listaPeliculas.add(new data("Record of Lodoss War", "Akihiro Izumi", R.drawable.lodoss));

        recyclerView = findViewById(R.id.recyclerView);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        recyclerView.setHasFixedSize(true);


        adapter = new MiAdapter(listaPeliculas);
        recyclerView.setAdapter(adapter);
    }
}