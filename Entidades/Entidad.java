package Jueguito.Entidades;

import Jueguito.Mapa;

import java.util.ArrayList;

public abstract class Entidad {
    protected String nombre;
    protected int salud;
    protected int nivel;
    protected int coordenadaX;
    protected int coordenadaY;
    protected boolean vivo;
    protected int exp;

    public Entidad(String nombre, int salud, int nivel, int coordenadaX, int coordenadaY, boolean vivo, int exp) {
        this.nombre = nombre;
        this.salud = salud;
        this.nivel = nivel;
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
        this.vivo = vivo;
        this.exp = exp;
    }

    public void recibirDano(int dano){
        salud-=dano;

        if (salud < 0){
            salud = 0;
        }
    }

    public boolean setVivo(){
        if (salud<=0){
            vivo=false;
        }else {
            vivo=true;
        }
        return vivo;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp, Personajes personajes) {
        this.exp += exp;

        if (this.exp>=100){
            personajes.subirNivel();
            this.exp-=100;
        }
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    public int getSalud() {
        return salud;
    }

    public int getNivel() {
        return nivel;
    }

    public int getCoordenadaX() {
        return coordenadaX;
    }

    public int getCoordenadaY() {
        return coordenadaY;
    }

    public void setCoordenadaX(int coordenadaX) {
        this.coordenadaX = coordenadaX;
    }

    public void setCoordenadaY(int coordenadaY) {
        this.coordenadaY = coordenadaY;
    }

    public String getNombre() {
        return nombre;
    }

    abstract public void describir();

    public void moverArriba(ArrayList<Personajes> personajes, int personaje_mover, Mapa world){
        int nuevay = personajes.get(personaje_mover).getCoordenadaY() - 1;
        int nuevax = personajes.get(personaje_mover).getCoordenadaX();
        world.moverPersonajes(nuevay,nuevax,personajes.get(personaje_mover).getCoordenadaY(),personajes.get(personaje_mover).getCoordenadaX(),personajes,personaje_mover);
    }

    public void moverAbajo(ArrayList<Personajes> personajes, int personaje_mover, Mapa world){
        int nuevay = personajes.get(personaje_mover).getCoordenadaY() + 1;
        int nuevax = personajes.get(personaje_mover).getCoordenadaX();
        world.moverPersonajes(nuevay,nuevax,personajes.get(personaje_mover).getCoordenadaY(),personajes.get(personaje_mover).getCoordenadaX(),personajes,personaje_mover);
    }

    public void moverDerecha(ArrayList<Personajes> personajes, int personaje_mover, Mapa world){
        int nuevay = personajes.get(personaje_mover).getCoordenadaY();
        int nuevax = personajes.get(personaje_mover).getCoordenadaX() + 1;
        world.moverPersonajes(nuevay,nuevax,personajes.get(personaje_mover).getCoordenadaY(),personajes.get(personaje_mover).getCoordenadaX(),personajes,personaje_mover);
    }

    public void moverIzquierda(ArrayList<Personajes> personajes, int personaje_mover, Mapa world){
        int nuevay = personajes.get(personaje_mover).getCoordenadaY();
        int nuevax = personajes.get(personaje_mover).getCoordenadaX() - 1;
        world.moverPersonajes(nuevay,nuevax,personajes.get(personaje_mover).getCoordenadaY(),personajes.get(personaje_mover).getCoordenadaX(),personajes,personaje_mover);
    }
}
