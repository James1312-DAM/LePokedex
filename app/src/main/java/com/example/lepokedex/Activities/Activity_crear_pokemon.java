package com.example.lepokedex.Activities;

import static com.example.lepokedex.Datos.PokemonDatos.listaPokemon;

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

import com.example.lepokedex.Objetos.Pokemon;
import com.example.lepokedex.Datos.PokemonDatos;
import com.example.lepokedex.R;

public class Activity_crear_pokemon extends AppCompatActivity implements View.OnClickListener {
    EditText ptNombre2;
    EditText ptHp2;
    EditText ptAtaque2;
    EditText ptVelocidad2;
    EditText ptDefensa2;
    Spinner spinnerCrear;
    Button btGuardar3;
    Button btVolver3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        PokemonDatos.cargarPokemon();
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_crear_pokemon);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ptNombre2 = findViewById(R.id.ptNombre2);
        ptHp2 = findViewById(R.id.ptHp2);
        ptAtaque2 = findViewById(R.id.ptAtaque2);
        ptDefensa2 = findViewById(R.id.ptDefensa2);
        ptVelocidad2 = findViewById(R.id.ptVelocidad2);
        spinnerCrear = findViewById(R.id.spinnerCrear);
        btGuardar3 = findViewById(R.id.btGuardar3);
        btVolver3 = findViewById(R.id.btVolver3);

        // Cargar los tipos en el Spinner
        String[] tipos = {
                "Agua", "Electrico", "Fuego",
                "Lucha", "Planta", "Veneno"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                tipos
        );

        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);

        spinnerCrear.setAdapter(adapter);

        btGuardar3.setOnClickListener(this);
        btVolver3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (btGuardar3.isPressed()){
            String nombre = ptNombre2.getText().toString();
            String hpTexto = ptHp2.getText().toString();
            String ataqueTexto = ptAtaque2.getText().toString();
            String defensaTexto = ptDefensa2.getText().toString();
            String velocidadTexto = ptVelocidad2.getText().toString();
            String tipo = spinnerCrear.getSelectedItem().toString();

            if (nombre.isEmpty() || hpTexto.isEmpty() || ataqueTexto.isEmpty()
                    || defensaTexto.isEmpty() || velocidadTexto.isEmpty()) {
                Toast.makeText(this, "Debes rellenar todos los campos", Toast.LENGTH_SHORT).show();
                return;
            }

            int hp = Integer.parseInt(hpTexto);
            int ataque = Integer.parseInt(ataqueTexto);
            int defensa = Integer.parseInt(defensaTexto);
            int velocidad = Integer.parseInt(velocidadTexto);

            // Crear con ID automático
            PokemonDatos.agregarPokemon(nombre, hp, ataque, defensa, velocidad, tipo);
            Toast.makeText(this, "Pokémon creado correctamente", Toast.LENGTH_SHORT).show();
        }
        if (btVolver3.isPressed()) {
            startActivity(new Intent(Activity_crear_pokemon.this, MainActivity.class));
        }
    }
}