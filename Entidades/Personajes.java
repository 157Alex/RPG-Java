package Jueguito.Entidades;

import Jueguito.Equipamiento.Arma;
import Jueguito.Equipamiento.Equipamiento;
import Jueguito.Habilidad;
import Jueguito.Mapa;

import java.util.ArrayList;
import java.util.List;

public abstract class Personajes extends Entidad implements Jueguito.Equipamiento.Equipar, Habilidad {

    protected int fuerza;
    protected int agilidad;
    protected int mana;
    protected int dinero;
    protected List<Equipamiento> equipamiento;

    public Personajes(String nombre, int salud, int nivel, int coordenadaX, int coordenadaY, boolean vivo, int exp, int fuerza, int agilidad, int mana, int dinero, List<Equipamiento> equipamiento) {
        super(nombre, salud, nivel, coordenadaX, coordenadaY, vivo, exp);
        this.fuerza = fuerza;
        this.agilidad = agilidad;
        this.mana = mana;
        this.dinero = dinero;
        this.equipamiento = equipamiento;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    abstract public void atacar(ArrayList <Criaturas> criaturas, ArrayList<Personajes> personajes, int personaje_atacante, Mapa mapa);

    abstract public void usarHabilidades(Criaturas objetivo, ArrayList<Criaturas> criaturas);

    public void subirNivel(){
        nivel+=1;
        fuerza += 5;
        agilidad += 2;
        mana += 2;
        dinero += 100;
        salud += 10;
        System.out.println("\n" +
                "██╗     ███████╗██╗   ██╗███████╗██╗         ██╗   ██╗██████╗ ██╗\n" +
                "██║     ██╔════╝██║   ██║██╔════╝██║         ██║   ██║██╔══██╗██║\n" +
                "██║     █████╗  ██║   ██║█████╗  ██║         ██║   ██║██████╔╝██║\n" +
                "██║     ██╔══╝  ╚██╗ ██╔╝██╔══╝  ██║         ██║   ██║██╔═══╝ ╚═╝\n" +
                "███████╗███████╗ ╚████╔╝ ███████╗███████╗    ╚██████╔╝██║     ██╗\n" +
                "╚══════╝╚══════╝  ╚═══╝  ╚══════╝╚══════╝     ╚═════╝ ╚═╝     ╚═╝\n");
    }

    public void mostrarEquipamiento(){
        for (Equipamiento item : equipamiento){
            item.mostrarNombre();
        }
    }

    public void reemplazarEquipamiento(int indice, Equipamiento nuevoItem) {
        equipamiento.set(indice, nuevoItem);
    }
}
