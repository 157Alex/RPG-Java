package Jueguito.Equipamiento;

import Jueguito.Entidades.Personajes;

import java.util.ArrayList;
import java.util.Scanner;

public class Arma extends Equipamiento{
    private int dano_extra;
    private String tipo_arma;
    static Scanner scanner = new Scanner(System.in);

    public Arma(String nombre, int nivel_requerido, int dano_extra, String tipo_arma) {
        super(nombre, nivel_requerido);
        this.dano_extra = dano_extra;
        this.tipo_arma = tipo_arma;
    }

    public void equiparArmaGuerrero(ArrayList<Personajes> personajes, int personaje_equipar, int indice, Equipamiento arma_null){
        System.out.println("\nEquipamiento de los guerreros: \n");
        System.out.println("""
                    ---*/ ARMAS /*---
                    
                    1.- Rollo de periodico
                    2.- Espada de hierro
                    3.- Excalibur
                    4.- Desequipar
                    """);
        System.out.print("¿Que quieres equiparte?: ");
        int arma = scanner.nextInt();

        if (arma == 1) {
            Arma arma1 = new Arma("Rollo de periodico", 1, 5, "Espada");
            personajes.get(personaje_equipar).equipar(personajes, arma1, personaje_equipar, indice);
        } else if (arma == 2) {
            Arma arma1 = new Arma("Espada de hierro", 5, 10, "Espada");
            personajes.get(personaje_equipar).equipar(personajes, arma1, personaje_equipar, indice);
        } else if (arma == 3) {
            Arma arma1 = new Arma("Excalibur", 10, 15, "Espada");
            personajes.get(personaje_equipar).equipar(personajes, arma1, personaje_equipar, indice);
        } else if (arma == 4) {
            personajes.get(personaje_equipar).desequipar(personajes, arma_null, personaje_equipar, indice);
        }
    }

    public void equiparArmaArquero(ArrayList<Personajes> personajes, int personaje_equipar, int indice, Equipamiento arma_null){
        System.out.println("\nEquipamiento de los arqueros: \n");
        System.out.println("""
                    ---*/ ARMAS /*---
                    
                    1.- Piedras pequeñas
                    2.- "LA CHANCLA"
                    3.- Corazon de cazador
                    4.- Desequipar
                    """);
        System.out.print("¿Que quieres equiparte?: ");
        int arma = scanner.nextInt();


        if (arma == 1) {
            Arma arma1 = new Arma("Piedras pequeñas", 1, 5, "Arco");
            personajes.get(personaje_equipar).equipar(personajes, arma1, personaje_equipar, indice);
        } else if (arma == 2) {
            Arma arma1 = new Arma("LA CHANCLA", 5, 10, "Arco");
            personajes.get(personaje_equipar).equipar(personajes, arma1, personaje_equipar, indice);
        } else if (arma == 3) {
            Arma arma1 = new Arma("Corazon de cazador", 10, 15, "Arco");
            personajes.get(personaje_equipar).equipar(personajes, arma1, personaje_equipar, indice);
        } else if (arma == 4) {
            personajes.get(personaje_equipar).desequipar(personajes, arma_null, personaje_equipar, indice);
        }
    }

    public void equiparArmaMago(ArrayList<Personajes> personajes, int personaje_equipar, int indice, Equipamiento arma_null) {
        System.out.println("\nEquipamiento de los magos: \n");
        System.out.println("""
                    ---*/ ARMAS /*---
                    
                    1.- Palo
                    2.- Baston brillante
                    3.- Varita de Harry Potter
                    4.- Desequipar
                    """);
        System.out.print("¿Que quieres equiparte?: ");
        int arma = scanner.nextInt();

        if (arma == 1) {
            Arma arma1 = new Arma("Palo", 1, 5, "Baculo");
            personajes.get(personaje_equipar).equipar(personajes, arma1, personaje_equipar, indice);
        } else if (arma == 2) {
            Arma arma1 = new Arma("Baston brillante", 5, 10, "Baculo");
            personajes.get(personaje_equipar).equipar(personajes, arma1, personaje_equipar, indice);
        } else if (arma == 3) {
            Arma arma1 = new Arma("Varita de Harry Potter", 10, 15, "Baculo");
            personajes.get(personaje_equipar).equipar(personajes, arma1, personaje_equipar, indice);
        } else if (arma == 4) {
            personajes.get(personaje_equipar).desequipar(personajes, arma_null, personaje_equipar, indice);
        }
    }

    @Override
    public void aplicarEfecto(ArrayList<Personajes> personajes, int personaje_equipar) {
        personajes.get(personaje_equipar).setFuerza(personajes.get(personaje_equipar).getFuerza()+dano_extra);
    }

    @Override
    public void removerEfecto(ArrayList<Personajes> personajes, int personaje_equipar) {
        personajes.get(personaje_equipar).setFuerza(personajes.get(personaje_equipar).getFuerza()-dano_extra);
    }
}
