package Jueguito.Equipamiento;

import Jueguito.Entidades.Personajes;

import java.util.ArrayList;

abstract public class Equipamiento {
    private String nombre;
    private int nivel_requerido;

    public Equipamiento(String nombre, int nivel_requerido) {
        this.nombre = nombre;
        this.nivel_requerido = nivel_requerido;
    }

    public abstract void aplicarEfecto (ArrayList<Personajes> personajes, int personaje);

    public abstract void removerEfecto (ArrayList<Personajes> personajes, int personaje);

    public void mostrarNombre(){
        System.out.print(" || " + nombre);
    }

    public String getNombre() {
        return nombre;
    }

    public int getNivel_requerido() {
        return nivel_requerido;
    }


}
