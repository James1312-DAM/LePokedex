
package com.example.lepokedex.Datos;

import com.example.lepokedex.Objetos.Pokemon;

import java.util.ArrayList;

public class PokemonDatos {

    public static ArrayList<Pokemon> listaPokemon = new ArrayList<>();

    public static void cargarPokemon() {

        listaPokemon.clear();

        listaPokemon.add(new Pokemon(1, "Bulbasaur", 45, 49, 49, 45, "planta"));
        listaPokemon.add(new Pokemon(2, "Ivysaur", 60, 62, 63, 60, "planta"));
        listaPokemon.add(new Pokemon(3, "Venusaur", 80, 82, 83, 80, "planta"));

        listaPokemon.add(new Pokemon(4, "Charmander", 39, 52, 43, 65, "fuego"));
        listaPokemon.add(new Pokemon(5, "Charmeleon", 58, 64, 58, 80, "fuego"));
        listaPokemon.add(new Pokemon(6, "Charizard", 78, 84, 78, 100, "fuego"));

        listaPokemon.add(new Pokemon(7, "Squirtle", 44, 48, 65, 43, "agua"));
        listaPokemon.add(new Pokemon(8, "Wartortle", 59, 63, 80, 58, "agua"));
        listaPokemon.add(new Pokemon(9, "Blastoise", 79, 83, 100, 78, "agua"));

        listaPokemon.add(new Pokemon(10, "Pikachu", 35, 55, 40, 90, "electrico"));
        listaPokemon.add(new Pokemon(11, "Raichu", 60, 90, 55, 110, "electrico"));
        listaPokemon.add(new Pokemon(12, "Magnemite", 25, 35, 70, 45, "electrico"));

        listaPokemon.add(new Pokemon(13, "Machop", 70, 80, 50, 35, "lucha"));
        listaPokemon.add(new Pokemon(14, "Machoke", 80, 100, 70, 45, "lucha"));
        listaPokemon.add(new Pokemon(15, "Machamp", 90, 130, 80, 55, "lucha"));

        listaPokemon.add(new Pokemon(16, "Ekans", 35, 60, 44, 55, "veneno"));
        listaPokemon.add(new Pokemon(17, "Koffing", 40, 65, 95, 35, "veneno"));
        listaPokemon.add(new Pokemon(18, "Grimer", 80, 80, 50, 25, "veneno"));
    }
}
