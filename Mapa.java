package Jueguito;

import Jueguito.Entidades.*;

import java.util.ArrayList;

public class Mapa {
    private final int x;
    private final int y;
    private final Entidad [][] mapa;

    public Mapa(int y, int x) {
        this.y = y;
        this.x = x;
        this.mapa = new Entidad[y][x];
    }

    public void creacionMapa (){
        for (int i=0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (mapa[i][j] == null) {
                    System.out.print(" - ");
                } else if (mapa[i][j] instanceof Guerrero){
                    System.out.print("[G]");
                }else if (mapa[i][j] instanceof Arquero){
                    System.out.print("[A]");
                } else if (mapa[i][j] instanceof Mago) {
                    System.out.print("[M]");
                } else if (mapa[i][j] instanceof Criaturas) {
                    System.out.print("[·]");
                }
            }
            System.out.println(" ");
        }
    }

    // Verifica si una posición en el mapa está libre
    public boolean posicionLibre(int x, int y) {
        boolean posicion_libre=false;
        if (mapa[y][x] == null) {
            posicion_libre=true;
        }
        return posicion_libre;
    }


    public void insertarPersonajes(int y, int x, ArrayList<Personajes> personajes ,int contador){
        if (x < 0 || x >= this.x || y < 0 || y >= this.y) {
            System.out.println("Error: Coordenadas fuera del mapa (" + x + ", " + y + ")");
        }else if (posicionLibre(x, y)) {
            mapa[y][x] = personajes.get(contador);
            personajes.get(contador).setCoordenadaY(y);
            personajes.get(contador).setCoordenadaX(x);
        }
    }

    public void generarCriaturas(int y, int x, ArrayList<Criaturas> criaturas, int cantCriaturas){
        if (x < 0 || x >= this.x || y < 0 || y >= this.y) {
            System.out.println("Error: Coordenadas fuera del mapa (" + x + ", " + y + ")");
        }else if (posicionLibre(x, y)) {
            mapa[y][x] = criaturas.get(cantCriaturas);
            criaturas.get(cantCriaturas).setCoordenadaY(y);
            criaturas.get(cantCriaturas).setCoordenadaX(x);
        }
    }

    public void moverPersonajes (int nuevay, int nuevax, int y, int x, ArrayList<Personajes> personajes, int contador){
        if (nuevax < 0 || nuevax >= this.x || nuevay < 0 || nuevay >= this.y) {
            System.out.println("Error: Coordenadas fuera del mapa (" + nuevax + ", " + nuevay + ")");
        }else if (posicionLibre(nuevax, nuevay)) {
            mapa[nuevay][nuevax] = personajes.get(contador);
            mapa[y][x] = null;
            personajes.get(contador).setCoordenadaX(nuevax);
            personajes.get(contador).setCoordenadaY(nuevay);
        }
    }

    public void limpiarCriaturasMuertas(int y, int x) {
        mapa[y][x]=null;
    }
}