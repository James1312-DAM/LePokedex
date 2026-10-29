package com.example.lepokedex.Activities;

import static com.example.lepokedex.Datos.PokemonDatos.listaPokemon;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.lepokedex.Objetos.Pokemon;
import com.example.lepokedex.R;

public class Activity_ver_pokemon extends AppCompatActivity implements View.OnClickListener {
    TextView tvNombre;
    TextView tvTipo;
    TextView tvHP;
    TextView tvAtaque;
    TextView tvDefensa;
    TextView tvVelocidad;
    Button btEditar;
    Button btBorrar;
    Button btVolver;
    ImageView imageView;
    Pokemon pokemon; //Declaramos aqui el pokemon para poder borrarlo
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ver_pokemon);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tvNombre = findViewById(R.id.tvNombre);
        tvTipo = findViewById(R.id.tvTipo);
        tvHP = findViewById(R.id.tvHP);
        tvAtaque = findViewById(R.id.tvAtaque);
        tvDefensa = findViewById(R.id.tvDefensa);
        tvVelocidad = findViewById(R.id.tvVelocidad);
        imageView = findViewById(R.id.imageView);
        btEditar = findViewById(R.id.btEditar);
        btBorrar = findViewById(R.id.btBorrar);
        btVolver = findViewById(R.id.btVolver);

         pokemon = (Pokemon) getIntent().getSerializableExtra("pokemon");

        tvNombre.setText(pokemon.getNombre());
        tvTipo.setText("Tipo: " + pokemon.getTipo());
        tvHP.setText("HP: " + pokemon.getHp());
        tvAtaque.setText("Ataque: " + pokemon.getAtaque());
        tvDefensa.setText("Defensa: " + pokemon.getDefensa());
        tvVelocidad.setText("Velocidad: " + pokemon.getVelocidad());

        //Imagen según el tipo
        switch (pokemon.getTipo()) {
            case "agua":
                imageView.setImageResource(R.drawable.img_tipo_agua);
                break;
            case "electrico":
                imageView.setImageResource(R.drawable.img_tipo_electrico);
                break;
            case "fuego":
                imageView.setImageResource(R.drawable.img_tipo_fuego);
                break;
            case "lucha":
                imageView.setImageResource(R.drawable.img_tipo_lucha);
                break;
            case "planta":
                imageView.setImageResource(R.drawable.img_tipo_planta);
                break;
            case "veneno":
                imageView.setImageResource(R.drawable.img_tipo_veneno);
                break;
            default:
                imageView.setImageResource(R.drawable.img_pokeball);
                break;
        }

        btEditar.setOnClickListener(this);
        btBorrar.setOnClickListener(this);
        btVolver.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (btVolver.isPressed()) {
            Intent intent = new Intent(Activity_ver_pokemon.this, MainActivity.class);
            startActivity(intent);
        }

        if (btEditar.isPressed()) {
            Intent intent = new Intent(Activity_ver_pokemon.this, Activity_editar_pokemon.class);
            intent.putExtra("pokemon", pokemon);
            startActivity(intent);
        }

        // 9. BORRAR: remove usa el equals (por id) y avisa de que salió bien
        if (btBorrar.isPressed()) {
            listaPokemon.remove(pokemon);
            Toast.makeText(this, "Pokémon eliminado correctamente", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Activity_ver_pokemon.this, MainActivity.class);
            startActivity(intent);
        }
    }
}