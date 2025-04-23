package Jueguito.Equipamiento;

import Jueguito.Entidades.Personajes;

import java.util.ArrayList;

public interface Equipar {

    void equipar(ArrayList<Personajes> personajes, Equipamiento item, int num_personaje, int indice);

    void desequipar (ArrayList<Personajes> personajes, Equipamiento item, int num_personaje, int indice);
}
