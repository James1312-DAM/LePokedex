package com.example.lepokedex.Adaptadores;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

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

        tvHp.setTextColor(Color.parseColor("#800080"));       // Morado
        tvAtaque.setTextColor(Color.RED);                     // Rojo
        tvDefensa.setTextColor(Color.GREEN);                 // Verde
        tvVelocidad.setTextColor(Color.parseColor("#FF69B4")); // Rosa

        switch (p.getTipo().toLowerCase()) {

            case "agua":
                convertView.setBackgroundColor(Color.parseColor("#81D4FA"));
                break;

            case "electrico":
                convertView.setBackgroundColor(Color.parseColor("#FFF176"));
                break;

            case "fuego":
                convertView.setBackgroundColor(Color.parseColor("#FFAB91"));
                break;

            case "lucha":
                convertView.setBackgroundColor(Color.parseColor("#D7CCC8"));
                break;

            case "planta":
                convertView.setBackgroundColor(Color.parseColor("#A5D6A7"));
                break;

            case "veneno":
                convertView.setBackgroundColor(Color.parseColor("#CE93D8"));
                break;

            default:
                convertView.setBackgroundColor(Color.WHITE);
                break;
        }

        return convertView;
    }
}