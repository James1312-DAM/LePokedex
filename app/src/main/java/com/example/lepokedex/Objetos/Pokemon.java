package com.example.lepokedex.Objetos;

import java.io.Serializable;

public class Pokemon implements Serializable {
    private int id;
    private String nombre;
    private int hp;
    private int ataque;
    private int defensa;
    private int velocidad;
    private String tipo;

    public Pokemon(int id, String nombre, int hp, int ataque, int defensa, int velocidad, String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.hp = hp;
        this.ataque = ataque;
        this.defensa = defensa;
        this.velocidad = velocidad;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Tipo: "+tipo;
    }

    // Dos Pokémon pueden tener el mismo id porque java busca por referencia asi asi nos aseguramos de buscar bien como en acceso a datos
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pokemon otro = (Pokemon) o;
        return id == otro.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
}
