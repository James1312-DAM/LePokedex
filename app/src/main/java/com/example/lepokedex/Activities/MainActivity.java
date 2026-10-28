package com.example.lepokedex.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.lepokedex.Adaptadores.PokemonAdapter;
import com.example.lepokedex.Datos.PokemonDatos;
import com.example.lepokedex.Objetos.Pokemon;
import com.example.lepokedex.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    Spinner spinnerActivityMain;
    Button btnFiltrar;
    Button btnNuevoPokemon;
    ListView listView;
    ArrayList<Pokemon> listaPokemon;
    ArrayList<Pokemon> listaFiltrada;
    PokemonAdapter adapterLista;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        PokemonDatos.cargarPokemon();
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        spinnerActivityMain=findViewById(R.id.spinnerActivityMain);
        listView=findViewById(R.id.listView);
        btnFiltrar=findViewById(R.id.btnFiltrar);
        btnNuevoPokemon=findViewById(R.id.btnNuevoPokemon);

        btnFiltrar.setOnClickListener(this);
        btnNuevoPokemon.setOnClickListener(this);

        // Cargar los Pokemon
        PokemonDatos.cargarPokemon();

        listaPokemon = PokemonDatos.listaPokemon;
        listaFiltrada = new ArrayList<>();

        // Crear los tipos del Spinner
        ArrayList<String> tipos = new ArrayList<>();
        tipos.add("agua");
        tipos.add("electrico");
        tipos.add("fuego");
        tipos.add("lucha");
        tipos.add("planta");
        tipos.add("veneno");

        // Configurar Spinner
        ArrayAdapter<String> adapterSpinner = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                tipos
        );

        adapterSpinner.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
        );

        spinnerActivityMain.setAdapter(adapterSpinner);

        // Mostrar inicialmente todos los Pokemon
        listaFiltrada.addAll(listaPokemon);

        adapterLista = new PokemonAdapter(
                this,
                R.layout.item_pokemon,
                listaFiltrada
        );

        listView.setAdapter(adapterLista);

        listView.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(btnFiltrar.isPressed()){
            String tipoSeleccionado = spinnerActivityMain.getSelectedItem().toString();

            listaFiltrada.clear();

            for (Pokemon p : listaPokemon) {
                if (p.getTipo().equalsIgnoreCase(tipoSeleccionado)) {
                    listaFiltrada.add(p);
                }
            }

            adapterLista.notifyDataSetChanged();
        }

        if (btnNuevoPokemon.isPressed()){
            Intent intent = new Intent(this, Activity_crear_pokemon.class);
            startActivity(intent);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Pokemon pokemonSeleccionado = listaFiltrada.get(position);
        Intent intent = new Intent(MainActivity.this, Activity_editar_pokemon.class);
        intent.putExtra("pokemon", pokemonSeleccionado);
        startActivity(intent);
    }
}