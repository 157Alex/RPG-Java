package Jueguito.Equipamiento;

import Jueguito.Entidades.Personajes;

import java.util.ArrayList;
import java.util.Scanner;

public class Pantalones extends Equipamiento{
    private int defensa;
    private int durabilidad;

    public Pantalones(String nombre, int nivel_requerido, int defensa, int durabilidad) {
        super(nombre, nivel_requerido);
        this.defensa = defensa;
        this.durabilidad = durabilidad;
    }

    public void equiparPantalones(ArrayList<Personajes> personajes, int personaje_equipar, Equipamiento pantalones_null){
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                ---*/ Pantalones /*---
                
                1.- Taparrabos
                2.- Pantalones de malla
                3.- Pantalones de escamas de dragon
                4.- Desequipar
                """);
        int indice=2;
        System.out.print("¿Que quieres equiparte?: ");
        int pantalones = scanner.nextInt();

        if (pantalones == 1) {
            Pantalones pantalones1 = new Pantalones("Taparrabos", 1, 5, 50);
            personajes.get(personaje_equipar).equipar(personajes,pantalones1,personaje_equipar,indice);
        } else if (pantalones == 2) {
            Pantalones pantalones1 = new Pantalones("Pantalones de malla", 5, 10, 100);
            personajes.get(personaje_equipar).equipar(personajes,pantalones1,personaje_equipar,indice);
        } else if (pantalones == 3) {
            Pantalones pantalones1 = new Pantalones("Pantalones de escamas de dragon", 10, 15, 150);
            personajes.get(personaje_equipar).equipar(personajes,pantalones1,personaje_equipar,indice);
        }else if (pantalones==4) {
            personajes.get(personaje_equipar).desequipar(personajes,pantalones_null,personaje_equipar, indice);
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
