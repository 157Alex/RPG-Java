package Jueguito.Entidades;

import Jueguito.Equipamiento.Arma;
import Jueguito.Equipamiento.Equipamiento;
import Jueguito.Habilidad;
import Jueguito.Mapa;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Mago extends Personajes{

    public Mago(String nombre, int salud, int nivel, int coordenadaX, int coordenadaY, boolean vivo, int exp, int fuerza, int agilidad, int mana, int dinero, List<Equipamiento> equipamiento) {
        super(nombre, salud, nivel, coordenadaX, coordenadaY, vivo, exp, fuerza, agilidad, mana, dinero, equipamiento);
    }

    @Override
    public void atacar(ArrayList<Criaturas> criaturas, ArrayList<Personajes> personajes, int personaje_atacante, Mapa mapa) {

        int rango_ataque = 2;
        ArrayList<Criaturas> criaturas_rango = new ArrayList<>();

        for (int i = 0; i < criaturas.size(); i++) {
            int distancia = Math.abs(criaturas.get(i).getCoordenadaX() - personajes.get(personaje_atacante).getCoordenadaX()) + Math.abs(criaturas.get(i).getCoordenadaY() - personajes.get(personaje_atacante).getCoordenadaY());
            if (distancia <= rango_ataque) {
                criaturas_rango.add(criaturas.get(i));
            }
        }

        if (criaturas_rango.isEmpty()) {
            System.out.println("\nNo hay criaturas cercanas");
            return;
        }

        System.out.println("\nCriaturas en rango:");
        for (int i = 0; i < criaturas_rango.size(); i++) {
            Criaturas criatura = criaturas_rango.get(i);
            System.out.println((i + 1) + ". " + criatura.getNombre() + " (Salud: " + criatura.getSalud() + ")");
        }

        Scanner scanner = new Scanner(System.in);
        int opcion;
        while (true) {
            System.out.print("\nElige el número de la criatura a atacar: ");
            opcion = (scanner.nextInt() - 1);
            if (opcion >= 0 && opcion < criaturas_rango.size()) {
                break;
            } else {
                System.out.println("Opción inválida. Intenta de nuevo.");
            }
        }
        // Atacar a la criatura seleccionada
        Criaturas objetivo = criaturas_rango.get(opcion);
        System.out.println("\n============================================================================================\n");
        System.out.println("1.- Ataque normal || fuerza " + personajes.get(personaje_atacante).getFuerza());
        System.out.println("2.- Habilidad Especial || Bola de fuego");
        System.out.println("3.- Habilidad");
        System.out.println("4.- Info Habilidad Especial");
        System.out.print("¿Como quieres atacar?: ");
        int ataque = scanner.nextInt();

        switch (ataque) {
            case 1:
                System.out.println("\n" + this.nombre + " ataca a " + objetivo.getNombre() + " causando " + this.fuerza + " de daño.");
                objetivo.recibirDano(this.fuerza);
                mana += 2;
                break;
            case 2:
                if (mana >= 10) {
                    personajes.get(personaje_atacante).usarHabilidades(objetivo, criaturas);
                } else {
                    System.out.println("No tienes mana suficiente");
                }
                break;
            case 3:
                personajes.get(personaje_atacante).ejecutar(objetivo);
                break;
            case 4:
                personajes.get(personaje_atacante).mostrarDescripcion();
                break;

        }
        boolean victoria = false;
        if (ataque == 1 || ataque == 2 || ataque == 3) {
            // Si la criatura sigue viva contraataca
            if (objetivo.setVivo()) {
                Personajes contrataque = personajes.get(personaje_atacante);
                objetivo.atacar(contrataque);
            } else {
                System.out.println(objetivo.getNombre() + " ha sido derrotado. Has ganado " + objetivo.getExp() + "exp");
                mapa.limpiarCriaturasMuertas(objetivo.getCoordenadaY(), objetivo.coordenadaX);
                Personajes personaje = personajes.get(personaje_atacante);
                personaje.setExp(objetivo.getExp(), personaje);
                criaturas.remove(objetivo);
            }
            if (!personajes.get(personaje_atacante).setVivo()) {
                System.out.println("\n"+ nombre + " ha muerto\n");
                mapa.limpiarCriaturasMuertas(personajes.get(personaje_atacante).getCoordenadaY(), personajes.get(personaje_atacante).getCoordenadaX());
                personajes.remove(personaje_atacante);
                if (personajes.isEmpty()) {
                    System.out.println("\n"+
                            "██████╗ ███████╗███████╗███████╗████████╗███████╗██████╗ \n" +
                            "██╔══██╗██╔════╝██╔════╝██╔════╝╚══██╔══╝██╔════╝██╔══██╗\n" +
                            "██║  ██║█████╗  █████╗  █████╗     ██║   █████╗  ██║  ██║\n" +
                            "██║  ██║██╔══╝  ██╔══╝  ██╔══╝     ██║   ██╔══╝  ██║  ██║\n" +
                            "██████╔╝███████╗██║     ███████╗   ██║   ███████╗██████╔╝\n" +
                            "╚═════╝ ╚══════╝╚═╝     ╚══════╝   ╚═╝   ╚══════╝╚═════╝ ");
                    System.exit(0);
                }
            }

            if (criaturas.isEmpty()) {
                System.out.println("\n" +
                        "██╗    ██╗██╗███╗   ██╗\n" +
                        "██║    ██║██║████╗  ██║\n" +
                        "██║ █╗ ██║██║██╔██╗ ██║\n" +
                        "██║███╗██║██║██║╚██╗██║\n" +
                        "╚███╔███╔╝██║██║ ╚████║\n" +
                        " ╚══╝╚══╝ ╚═╝╚═╝  ╚═══╝");
                System.exit(0);
            }
        }
    }


    @Override
    public void usarHabilidades(Criaturas objetivo, ArrayList<Criaturas> criaturas) {
        System.out.println("\n " + this.nombre + " lanza una Bola de Fuego a " + objetivo.getNombre() + "!");

        // Coordenadas del objetivo
        int xObjetivo = objetivo.getCoordenadaX();
        int yObjetivo = objetivo.getCoordenadaY();

        // Recorrer todas las criaturas y hacer daño en área (dentro del radio de 1 casilla)
        for (Criaturas c : criaturas) {
            int distancia = Math.abs(c.getCoordenadaX() - xObjetivo) + Math.abs(c.getCoordenadaY() - yObjetivo);

            if (distancia <= 1) { // Solo afecta a criaturas en el radio de 1 casilla
                System.out.println(c.getNombre() + " recibe " + fuerza + " de daño!");
                c.recibirDano(fuerza);
            }
        }
    }

    @Override
    public void describir() {
        System.out.println("              _,._      \n" +
                "  .||,       /_ _\\\\     \n" +
                " \\.`',/     |'L'| |    \n" +
                " = ,. =      | -,| L    \n" +
                " / || \\    ,-'\\\"/,'`.   \n" +
                "   ||     ,'   `,,. `.  \n" +
                "   ,|____,' , ,;' \\| |  \n" +
                "  (3|\\    _/|/'   _| |  \n" +
                "   ||/,-''  | >-'' _,\\\\ \n" +
                "   ||'      ==\\ ,-'  ,' \n" +
                "   ||       |  V \\ ,|   \n" +
                "   ||       |    |` |   \n" +
                "   ||       |    |   \\  \n" +
                "   ||       |    \\    \\ \n" +
                "   ||       |     |    \\\n" +
                "   ||       |      \\_,-'\n" +
                "   ||       |___,,--\")_\\\n" +
                "   ||         |_|   ccc/\n" +
                "   ||        ccc/       \n" +
                "   ||                   \n" +
                        " nombre= " + nombre + "\n"+
                        " nivel= " + nivel + "\n"+
                        " salud= " + salud + "\n"+
                        " fuerza= " + fuerza + "\n"+
                        " agilidad= " + agilidad + "\n"+
                        " mana= " + mana + "\n"+
                        " dinero= " + dinero + "\n"+
                        " coordenadaY= " + coordenadaY + "\n"+
                        " coordenadaX= " + coordenadaX + "\n");

    }

    @Override
    public void ejecutar(Criaturas objetivo) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                1.- Curarte
                2.- Envenerar
                """);
        System.out.print("\nQue quieres hacer: ");
        int habilidad =scanner.nextInt();

        switch (habilidad){
            case 1:
                salud+=20;
                System.out.println(nombre + " tiene 20 de vida mas, ahora tiene " + salud + " de vida");
                break;
            case 2:
                System.out.println("\n" + this.nombre + " ataca a " + objetivo.getNombre() + " causando " + (this.fuerza+5) + " de daño.");
                objetivo.recibirDano(this.fuerza+5);
                break;
        }
    }

    @Override
    public void mostrarDescripcion() {
        System.out.println("Hace 5 de danio extra progresivo a una criatura o cura 20 de vida");
    }

    @Override
    public void equipar(ArrayList<Personajes> personajes, Equipamiento item, int personaje_equipar, int indice) {
        if (personajes.get(personaje_equipar).getNivel() >= item.getNivel_requerido()) {
            personajes.get(personaje_equipar).reemplazarEquipamiento(indice, item);
            item.aplicarEfecto(personajes,personaje_equipar);
        } else {
            System.out.println("No tienes suficiente nivel para " + item.getNombre() + " ya que tu nivel es de " + personajes.get(personaje_equipar).getNivel() + " y necesitas un nivel de " + item.getNivel_requerido());
        }
        System.out.println("\n============================================================================================\n");
    }

    @Override
    public void desequipar(ArrayList<Personajes> personajes, Equipamiento item, int personaje_equipar, int indice) {
        personajes.get(personaje_equipar).reemplazarEquipamiento(indice,item);
        item.removerEfecto(personajes,personaje_equipar);

    }
}
