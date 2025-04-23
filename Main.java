package Jueguito;

import Jueguito.Entidades.*;
import Jueguito.Equipamiento.Arma;
import Jueguito.Equipamiento.Equipamiento;
import Jueguito.Equipamiento.Pantalones;
import Jueguito.Equipamiento.Pechera;

import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Personajes> personajes = new ArrayList<>();
    private static ArrayList<Criaturas>  criaturas = new ArrayList<>();
    public static Mapa world;
    static Arma arma_null = new Arma("Sin equipamiento", 1, 0, null);
    static Pechera pechera_null = new Pechera("Sin equipamiento", 1, 0, null);
    static Pantalones pantalones_null = new Pantalones("Sin equipamiento", 1, 0, 0);

    public static void main(String[] args) {

        System.out.println("\n============================================================================================\n");
        System.out.println("      **     **     **      **     **           *******   *******    ******** \n" +
                "     /**    ****   /**     /**    ****         /**////** /**////**  **//////**\n" +
                "     /**   **//**  /**     /**   **//**        /**   /** /**   /** **      // \n" +
                "     /**  **  //** //**    **   **  //**       /*******  /******* /**         \n" +
                "     /** ********** //**  **   **********      /**///**  /**////  /**    *****\n" +
                " **  /**/**//////**  //****   /**//////**      /**  //** /**      //**  ////**\n" +
                "//***** /**     /**   //**    /**     /**      /**   //**/**       //******** \n" +
                " /////  //      //     //     //      //       //     // //         ////////  ");
        System.out.println("\n============================================================================================\n");
        System.out.println("¡Empecemos configurando tu partida!");
        System.out.println("\n============================================================================================\n");

        Creacion();
        MenuGeneralComandosJuego();
    }

    public static void Creacion() {
        System.out.println("¿De que tamaño quieres que sea el mapa?");
        System.out.print("Ancho: ");
        int x = scanner.nextInt();
        System.out.print("Alto: ");
        int y = scanner.nextInt();
        world = new Mapa(y, x);
        System.out.println(" ");
        world.creacionMapa();

        System.out.println("\n============================================================================================\n");

        System.out.print("¿Cuantas criaturas quieres crear?: ");
        int num_criaturas = scanner.nextInt();
        scanner.nextLine();

        Random criaturasRandom = new Random();
        String nombre;
        String tipo_entidad;
        int revision=0;

        for (int cantCriaturas = 0; cantCriaturas < num_criaturas; cantCriaturas++) {
            System.out.println("\n============================================================================================\n");
            System.out.println("""
                    1.- Conjunto de criaturas
                    2.- Grifo
                    3.- Esqueleto
                    4.- Dragon
                    """);
            System.out.print("¿Cual quieres que sea tu criatura numero " + (cantCriaturas + 1) + "?: ");
            tipo_entidad = scanner.nextLine();

            while (revision == 0) {
                if (!tipo_entidad.equals("1") && !tipo_entidad.equals("2") && !tipo_entidad.equals("3") && !tipo_entidad.equals("4")) {
                    System.out.print("¿Cual quieres que sea tu criatura numero " + (cantCriaturas + 1) + "?: ");
                    tipo_entidad = scanner.nextLine();
                } else {
                    revision++;
                }
            }

            int y_criatura = criaturasRandom.nextInt(y);
            int x_criatura = criaturasRandom.nextInt(x);

            if (!world.posicionLibre(x_criatura, y_criatura)) {
                while (!world.posicionLibre(x_criatura, y_criatura)){
                    y_criatura = criaturasRandom.nextInt(y);
                    x_criatura = criaturasRandom.nextInt(x);
                }
            }
            System.out.print("\n¿Como le quieres llamar?: ");
            nombre = scanner.nextLine();
            switch (tipo_entidad){
            case "1":
                criaturas.add(new Criaturas(nombre, criaturasRandom.nextInt(40) + 20, criaturasRandom.nextInt(19) + 1, x_criatura, y_criatura, true, criaturasRandom.nextInt(30) + 20, "Conjunto de criaturas", criaturasRandom.nextInt(40) + 5));
                world.generarCriaturas(criaturas.get(cantCriaturas).getCoordenadaY(), criaturas.get(cantCriaturas).getCoordenadaX(), criaturas, cantCriaturas);
                break;

            case "2":
                criaturas.add(new Criaturas(nombre, criaturasRandom.nextInt(80) + 20, criaturasRandom.nextInt(19) + 1, x_criatura, y_criatura, true, criaturasRandom.nextInt(60) + 20, "Grifo", criaturasRandom.nextInt(40) + 20));
                world.generarCriaturas(criaturas.get(cantCriaturas).getCoordenadaY(), criaturas.get(cantCriaturas).getCoordenadaX(), criaturas, cantCriaturas);
                break;

            case "3":
                criaturas.add(new Criaturas(nombre, criaturasRandom.nextInt(40) + 20, criaturasRandom.nextInt(19) + 1, x_criatura, y_criatura, true, criaturasRandom.nextInt(30) + 20, "Esqueleto", criaturasRandom.nextInt(40) + 5));
                world.generarCriaturas(criaturas.get(cantCriaturas).getCoordenadaY(), criaturas.get(cantCriaturas).getCoordenadaX(), criaturas, cantCriaturas);
                break;

            case "4":
                criaturas.add(new Criaturas(nombre, criaturasRandom.nextInt(100) + 20, criaturasRandom.nextInt(19) + 1, x_criatura, y_criatura, true, criaturasRandom.nextInt(100) + 20, "Dragon", criaturasRandom.nextInt(40) + 30));
                world.generarCriaturas(criaturas.get(cantCriaturas).getCoordenadaY(), criaturas.get(cantCriaturas).getCoordenadaX(), criaturas, cantCriaturas);
                break;
            }
        }
        System.out.println("\n============================================================================================\n");

        System.out.print("¿Cuantos personajes quieres crear?: ");
        int numPersonaje = scanner.nextInt();
        scanner.nextLine();
        int coordenada_x_personajes = 0;
        int coordenada_y_personajes = 0;
        ArrayList<Equipamiento> equipamiento = null;

        for (int cantPersonajes = 0; cantPersonajes < numPersonaje; cantPersonajes++) {
            System.out.println("\n============================================================================================\n");
            System.out.println("""
                    1.- Guerrero
                    2.- Arquero
                    3.- Mago
                    """
            );
            System.out.print("¿Cual quieres que sea tu personaje numero " + (cantPersonajes + 1) + "?: ");
            tipo_entidad = scanner.nextLine();

            while (revision == 1) {
                if (!tipo_entidad.equals("1") && !tipo_entidad.equals("2") && !tipo_entidad.equals("3")) {
                    System.out.print("¿Cual quieres que sea tu personaje numero " + (cantPersonajes + 1) + "?: ");
                    tipo_entidad = scanner.nextLine();
                }else {
                    revision++;
                }
            }

            System.out.print("\n¿Como quieres llamarle?: ");
            nombre = scanner.nextLine();

            if (coordenada_x_personajes == x) {
                coordenada_y_personajes = coordenada_y_personajes + 1;
                coordenada_x_personajes = 0;

            }
            if (!world.posicionLibre(coordenada_x_personajes, coordenada_y_personajes)) {
                while (!world.posicionLibre(coordenada_x_personajes, coordenada_y_personajes)) {
                    coordenada_y_personajes = criaturasRandom.nextInt(y);
                    coordenada_x_personajes = criaturasRandom.nextInt(x);
                }
            }

            switch (tipo_entidad) {
                case "1":
                    equipamiento= new ArrayList<>();
                    personajes.add(new Guerrero(nombre, criaturasRandom.nextInt(60) + 20, 1, coordenada_x_personajes, coordenada_y_personajes, true, 0, criaturasRandom.nextInt(20) + 20, 5, 10, 0, equipamiento));
                    world.insertarPersonajes(coordenada_y_personajes, coordenada_x_personajes, personajes, cantPersonajes);
                    break;


                case "2":
                    equipamiento= new ArrayList<>();
                    personajes.add(new Arquero(nombre, criaturasRandom.nextInt(60) + 20, 1, coordenada_x_personajes, coordenada_y_personajes, true, 0, criaturasRandom.nextInt(20) + 10, 10, 10, 0, equipamiento));
                    world.insertarPersonajes(coordenada_y_personajes, coordenada_x_personajes, personajes, cantPersonajes);
                    break;

                case "3":
                    equipamiento= new ArrayList<>();
                    personajes.add(new Mago(nombre, criaturasRandom.nextInt(60) + 20, 1, coordenada_x_personajes, coordenada_y_personajes, true, 0, criaturasRandom.nextInt(20) + 10, 5, 15, 0, equipamiento));
                    world.insertarPersonajes(coordenada_y_personajes, coordenada_x_personajes, personajes, cantPersonajes);
                    break;
            }
            coordenada_x_personajes++;

            equipamiento.add(arma_null);
            equipamiento.add(pechera_null);
            equipamiento.add(pantalones_null);
        }
        System.out.println("\n============================================================================================\n");
    }

    public static void MenuGeneralComandosJuego() {
        world.creacionMapa();
        System.out.println("\n============================================================================================\n");
        System.out.println("""
                1.- Despazarte
                2.- Atacar
                3.- Equiparte
                4.- Stats personajes
                5.- Stats criaturas
                6.- Salir
                """
        );
        System.out.print("¿Qué quieres hacer?: ");
        String opcion_menu = scanner.nextLine();
        System.out.println("\n============================================================================================\n");

        switch (opcion_menu) {

            case "1":
                desplazarse();
                break;

            case "2":
                atacar();
                break;

            case "3":
                equipar();
                break;

            case "4":
                mostrarStats();
                break;

            case "5":
                mostrarStatsCriaturas();
                break;

            case "6":
                System.exit(0);
                break;

            default:
                System.out.println("\nOpcion invalida, vuelva a elegir\n");
                MenuGeneralComandosJuego();
                break;
        }
    }

    public static void desplazarse() {

        for (int veces = 0; veces < personajes.size(); veces++) {
            System.out.println(veces + 1 + ".- " + personajes.get(veces).getNombre() + " || x: " + (personajes.get(veces).getCoordenadaX() + 1) + " || y: " + (personajes.get(veces).getCoordenadaY() + 1));
        }

        System.out.print("\nElije el personaje que quieres mover: ");
        int personaje_mover = scanner.nextInt();
        personaje_mover = personaje_mover - 1;

        System.out.println("\n============================================================================================\n");

        System.out.println("W/S/A/D");
        System.out.println("Para salir: Z\n");
        System.out.println("¿A donde quieres moverte?: ");
        scanner.nextLine();
        String movimiento = scanner.nextLine();

        if (movimiento.equalsIgnoreCase("w") || movimiento.equalsIgnoreCase("s") || movimiento.equalsIgnoreCase("a") || movimiento.equalsIgnoreCase("d")) {
            switch (movimiento) {
                case "w", "W":
                    personajes.get(personaje_mover).moverArriba(personajes, personaje_mover, world);
                    MenuGeneralComandosJuego();
                    break;

                case "s", "S":
                    personajes.get(personaje_mover).moverAbajo(personajes, personaje_mover, world);
                    MenuGeneralComandosJuego();
                    break;

                case "a", "A":
                    personajes.get(personaje_mover).moverIzquierda(personajes, personaje_mover, world);
                    MenuGeneralComandosJuego();
                    break;

                case "d", "D":
                    personajes.get(personaje_mover).moverDerecha(personajes, personaje_mover, world);
                    MenuGeneralComandosJuego();
                    break;

                case "z", "Z":
                    System.out.println("Saliendo . . .");
                    MenuGeneralComandosJuego();
                    break;

            }
        }else {
            System.out.println("Comando incorrecto");
            MenuGeneralComandosJuego();
        }
    }

    public static void equipar() {

        for (int veces = 0; veces < personajes.size(); veces++) {
            System.out.print((veces + 1) + ".- " + personajes.get(veces).getNombre());
            personajes.get(veces).mostrarEquipamiento();
            System.out.println(" ");
        }
        System.out.println("\n============================================================================================\n");

        System.out.print("Elije el personaje al que quieres equipar: ");
        int personaje_equipar = scanner.nextInt();
        personaje_equipar = personaje_equipar - 1;

        if (personajes.get(personaje_equipar) instanceof Guerrero) {
            arma_null.equiparArmaGuerrero(personajes,personaje_equipar,0,arma_null);
        } else if (personajes.get(personaje_equipar) instanceof Arquero) {
            arma_null.equiparArmaArquero(personajes,personaje_equipar,0,arma_null);
        } else if (personajes.get(personaje_equipar) instanceof Mago) {
            arma_null.equiparArmaMago(personajes,personaje_equipar,0,arma_null);
        }
        pechera_null.equiparPechera(personajes, personaje_equipar, pechera_null);
        pantalones_null.equiparPantalones(personajes,personaje_equipar,pantalones_null);
        scanner.nextLine();
        MenuGeneralComandosJuego();
    }

    public static void mostrarStats(){
        for (int veces =0; veces< personajes.size();veces++){
            System.out.println((veces+1) + ".- " + personajes.get(veces).getNombre());
        }
        System.out.println("\n============================================================================================\n");

        System.out.print("Elije el personaje: ");
        int personaje_stats = scanner.nextInt();
        personaje_stats=personaje_stats-1;

        personajes.get(personaje_stats).describir();
        personajes.get(personaje_stats).mostrarEquipamiento();
        System.out.println("\n============================================================================================\n");
        scanner.nextLine();
        MenuGeneralComandosJuego();
    }

    public static void mostrarStatsCriaturas(){
        for (int veces =0; veces < criaturas.size(); veces++){
            System.out.println((veces+1) + ".- " + criaturas.get(veces).getNombre() + " || x:" + (criaturas.get(veces).getCoordenadaX()+1) + " || y: " + (criaturas.get(veces).getCoordenadaY()+1));
        }
        System.out.println("\n============================================================================================\n");

        System.out.print("Elije la criatura: ");
        int personaje_stats = scanner.nextInt();
        personaje_stats=personaje_stats-1;

        if (Objects.equals(criaturas.get(personaje_stats).getTipo(), "Dragon")){
            criaturas.get(personaje_stats).printDragon();
        }else if (Objects.equals(criaturas.get(personaje_stats).getTipo(), "Esqueleto")){
            criaturas.get(personaje_stats).printMinotauro();
        }else if (Objects.equals(criaturas.get(personaje_stats).getTipo(), "Grifo")){
            criaturas.get(personaje_stats).printGrifo();
        }else if (Objects.equals(criaturas.get(personaje_stats).getTipo(), "Conjunto de criaturas")){
            criaturas.get(personaje_stats).printCriaturas();
        }
        System.out.println("\n============================================================================================\n");
        scanner.nextLine();
        MenuGeneralComandosJuego();
    }

    public static void atacar(){

        for (int veces = 0; veces < personajes.size(); veces++) {
            System.out.println((veces + 1) + ".- " + personajes.get(veces).getNombre() + " || salud: " + personajes.get(veces).getSalud() + " || fuerza: " + personajes.get(veces).getFuerza());
        }
        System.out.println("\n============================================================================================\n");

        System.out.print("Elije el personaje con el que quieres atacar: ");
        int personaje_atacante = scanner.nextInt();
        personaje_atacante = personaje_atacante - 1;

        personajes.get(personaje_atacante).atacar(criaturas,personajes,personaje_atacante,world);
        System.out.println("\n============================================================================================\n");

        scanner.nextLine();
        MenuGeneralComandosJuego();
    }
}