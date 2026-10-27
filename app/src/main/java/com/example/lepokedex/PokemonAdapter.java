package com.example.lepokedex;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class PokemonAdapter extends ArrayAdapter<Pokemon> {
    public PokemonAdapter(Context context, int resource,List<Pokemon> persons) {
        super(context, resource, persons);
    }
    @Override
    public View getView(int position,  View convertView, ViewGroup parent) {
        // Position es el numero de fila que se va a generar
        Pokemon p = getItem(position);

        // Comprobamos que no haya ninguna nueva fila disponible
        if (convertView == null) {
            // Saco el layoutInflater del context (activity)
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            /* Campos del inflate
            1º Context: XML usado de plantilla
            2º Parent: Padre del elemento (ListView)
            3º False: Para crear el padre antes que el hijo
             */
            convertView = layoutInflater.inflate(R.layout.item_pokemon, parent, false);
        }
        // Setear informacion de los usuarios
        TextView tvHp = convertView.findViewById(R.id.tvHp);
        TextView tvAtaque = convertView.findViewById(R.id.tvAtaque);
        TextView tvDefensa = convertView.findViewById(R.id.tvDefensa);
        TextView tvVelocidad = convertView.findViewById(R.id.tvVelocidad);

        tvHp.setText(p.getHp());
        tvAtaque.setText(p.getAtaque());
        tvDefensa.setText(p.getDefensa());
        tvVelocidad.setText(p.getVelocidad());

        return convertView;

    }
    // Define cómo se ven los elementos en la lista desplegable cuando tocas el Spinner.
    public View getDropDownView(int position,  View convertView,  ViewGroup parent) {
        // Position es el numero de fila que se va a generar
        Pokemon p = getItem(position);

        // Comprobamos que no haya ninguna nueva fila disponible
        if (convertView == null) {
            // Saco el layoutInflater del context (activity)
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            /* Campos del inflate
            1º Context: XML usado de plantilla
            2º Parent: Padre del elemento (ListView)
            3º False: Para crear el padre antes que el hijo
             */

            /*MODIFICAR ESTA PARTE DEL CODIGO ESTA MAL
            convertView = layoutInflater.inflate(R.layout.spinnerActivityMain, parent, false);
        }
        // Setear informacion de los usuarios
        TextView tvDataPersons = convertView.findViewById(R.id.tvDataPersons);
        tvDataPersons.setText(p.getName() + " " + p.getSurname() + " (" + p.getEmail() + ")");
        */
        return convertView;
    }


}
