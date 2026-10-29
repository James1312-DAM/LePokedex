package com.example.lepokedex.Adaptadores;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import com.example.lepokedex.Objetos.Pokemon;
import com.example.lepokedex.R;

import java.util.List;

public class PokemonAdapter extends ArrayAdapter<Pokemon> {

    public PokemonAdapter(Context context, int resource, List<Pokemon> persons) {
        super(context, resource, persons);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Pokemon p = getItem(position);

        if (convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            convertView = layoutInflater.inflate(R.layout.item_pokemon, parent, false);
        }

        TextView tvHp = convertView.findViewById(R.id.tvHp);
        TextView tvAtaque = convertView.findViewById(R.id.tvAtaque);
        TextView tvDefensa = convertView.findViewById(R.id.tvDefensa);
        TextView tvVelocidad = convertView.findViewById(R.id.tvVelocidad);
        TextView tvNombre = convertView.findViewById(R.id.tvNombre);

        tvHp.setText(String.valueOf(p.getHp()));
        tvAtaque.setText(String.valueOf(p.getAtaque()));
        tvDefensa.setText(String.valueOf(p.getDefensa()));
        tvVelocidad.setText(String.valueOf(p.getVelocidad()));
        tvNombre.setText(String.valueOf(p.getNombre()));

        // Colores de los números (definidos en colors.xml)
        tvHp.setTextColor(ContextCompat.getColor(getContext(), R.color.morado));
        tvAtaque.setTextColor(ContextCompat.getColor(getContext(), R.color.rojo));
        tvDefensa.setTextColor(ContextCompat.getColor(getContext(), R.color.verde));
        tvVelocidad.setTextColor(ContextCompat.getColor(getContext(), R.color.rosa));

        // 6. Color de fondo de la fila según el tipo (definidos en colors.xml)
        switch (p.getTipo().toLowerCase()) {

            case "agua":
                convertView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.fondoagua));
                break;

            case "electrico":
                convertView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.fondoelectrico));
                break;

            case "fuego":
                convertView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.fondofuego));
                break;

            case "lucha":
                convertView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.fondolucha));
                break;

            case "planta":
                convertView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.fondoplanta));
                break;

            case "veneno":
                convertView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.fondoveneno));
                break;

            default:
                convertView.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.white));
                break;
        }

        return convertView;
    }
}