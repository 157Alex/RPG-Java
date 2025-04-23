package Jueguito.Equipamiento;

import Jueguito.Entidades.Personajes;

import java.util.ArrayList;
import java.util.Scanner;

public class Pechera extends Equipamiento{
    private int defensa;
    private String tipo_material;

    public Pechera(String nombre, int nivel_requerido, int defensa, String tipo_material) {
        super(nombre, nivel_requerido);
        this.defensa = defensa;
        this.tipo_material = tipo_material;
    }

    public void equiparPechera(ArrayList<Personajes> personajes, int personaje_equipar, Equipamiento pechera_null){
        Scanner scanner = new Scanner(System.in);
        int indice=1;
        System.out.println("""
                        ---*/ Pecheras /*---
                        
                        1.- Chaqueta de cuero
                        2.- Pechera de malla
                        3.- Coraza de dragon
                        4.- Desequipar
                        """);
        System.out.print("¿Que quieres equiparte?: ");
        int  pechera = scanner.nextInt();

        if (pechera==1) {
            Pechera pechera1 = new Pechera("Chaqueta de cuero", 1, 5, "cuero");
            personajes.get(personaje_equipar).equipar(personajes,pechera1,personaje_equipar, indice);
        } else if (pechera==2) {
            Pechera pechera1 = new Pechera("Pechera de malla", 5, 10, "malla");
            personajes.get(personaje_equipar).equipar(personajes,pechera1,personaje_equipar, indice);
        } else if (pechera==3) {
            Pechera pechera1 = new Pechera("Coraza de dragon", 15, 15, "escamas de dragon");
            personajes.get(personaje_equipar).equipar(personajes,pechera1,personaje_equipar, indice);
        }else if (pechera==4) {
            personajes.get(personaje_equipar).desequipar(personajes,pechera_null,personaje_equipar, indice);
        }
    }

    @Override
    public void aplicarEfecto(ArrayList<Personajes> personajes, int personaje_equipar) {
        personajes.get(personaje_equipar).setSalud(personajes.get(personaje_equipar).getSalud()+defensa);
    }

    @Override
    public void removerEfecto(ArrayList<Personajes> personajes, int personaje_equipar) {
        personajes.get(personaje_equipar).setSalud(personajes.get(personaje_equipar).getSalud()+defensa);
    }

}
