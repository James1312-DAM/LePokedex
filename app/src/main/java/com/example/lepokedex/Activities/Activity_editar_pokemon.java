package com.example.lepokedex.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.lepokedex.Datos.PokemonDatos;
import com.example.lepokedex.Objetos.Pokemon;
import com.example.lepokedex.R;

public class Activity_editar_pokemon extends AppCompatActivity implements View.OnClickListener {
    EditText ptNombre;
    EditText ptHp;
    EditText ptAtaque;
    EditText ptVelocidad;
    EditText ptDefensa;
    Spinner spinnerEditar;
    Button btGuardar2;
    Button btVolver2;
    Pokemon pokemon; // copia que llega por Intent (sirve para rellenar y para saber el id)
    String[] tipos = {"Agua", "Electrico", "Fuego", "Lucha", "Planta", "Veneno"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_editar_pokemon);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ptNombre = findViewById(R.id.ptNombre);
        ptHp = findViewById(R.id.ptHp);
        ptAtaque = findViewById(R.id.ptAtaque);
        ptVelocidad = findViewById(R.id.ptVelocidad);
        ptDefensa = findViewById(R.id.ptDefensa);
        spinnerEditar = findViewById(R.id.spinnerEditar);
        btGuardar2 = findViewById(R.id.btGuardar2);
        btVolver2 = findViewById(R.id.btVolver2);

        // Spinner con los tipos
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_item, tipos);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerEditar.setAdapter(adapter);

        // Recibir el Pokémon y rellenar el formulario con sus datos
        pokemon = (Pokemon) getIntent().getSerializableExtra("pokemon");

        ptNombre.setText(pokemon.getNombre());
        // String.valueOf, porque setText(int) buscaría un id con ese número
        //Para trabajar con numero es necesario hacerlo asi
        ptHp.setText(String.valueOf(pokemon.getHp()));
        ptAtaque.setText(String.valueOf(pokemon.getAtaque()));
        ptVelocidad.setText(String.valueOf(pokemon.getVelocidad()));
        ptDefensa.setText(String.valueOf(pokemon.getDefensa()));

        // Dejar seleccionado en el Spinner el tipo actual
        //Fuente externa sino siempre se quedaria un mismo tipo seleccionado y cambiaria el tipo de pokemon
        for (int i = 0; i < tipos.length; i++) {
            if (tipos[i].equalsIgnoreCase(pokemon.getTipo())) {
                spinnerEditar.setSelection(i);
            }
        }

        btGuardar2.setOnClickListener(this);
        btVolver2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (btGuardar2.isPressed()) {
            String nombre = ptNombre.getText().toString();
            String hpTexto = ptHp.getText().toString();
            String ataqueTexto = ptAtaque.getText().toString();
            String velocidadTexto = ptVelocidad.getText().toString();
            String defensaTexto = ptDefensa.getText().toString();
            String tipo = spinnerEditar.getSelectedItem().toString();

            if (nombre.isEmpty() || hpTexto.isEmpty() || ataqueTexto.isEmpty()
                    || velocidadTexto.isEmpty() || defensaTexto.isEmpty()) {
                Toast.makeText(this, "Debes rellenar todos los campos", Toast.LENGTH_SHORT).show();
                return;
            }

            int hp = Integer.parseInt(hpTexto);
            int ataque = Integer.parseInt(ataqueTexto);
            int velocidad = Integer.parseInt(velocidadTexto);
            int defensa = Integer.parseInt(defensaTexto);

            Pokemon pokemonDeLaLista = PokemonDatos.buscarPorId(pokemon.getId());

            pokemonDeLaLista.setNombre(nombre);
            pokemonDeLaLista.setHp(hp);
            pokemonDeLaLista.setAtaque(ataque);
            pokemonDeLaLista.setVelocidad(velocidad);
            pokemonDeLaLista.setDefensa(defensa);
            pokemonDeLaLista.setTipo(tipo);

            Toast.makeText(this, "Pokémon actualizado correctamente", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Activity_editar_pokemon.this, MainActivity.class);
            startActivity(intent);
        }
        if (btVolver2.isPressed()) {
            Intent intent = new Intent(Activity_editar_pokemon.this, MainActivity.class);
            startActivity(intent);
        }
    }
}