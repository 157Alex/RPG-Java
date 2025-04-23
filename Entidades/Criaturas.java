package Jueguito.Entidades;

import Jueguito.Mapa;

import java.util.Random;

public class Criaturas extends Entidad{
    private String tipo;
    private int dano_base;

    public Criaturas(String nombre, int salud, int nivel, int coordenadaX, int coordenadaY, boolean vivo, int exp, String tipo, int dano_base) {
        super(nombre, salud, nivel, coordenadaX, coordenadaY, vivo, exp);
        this.tipo=tipo;
        this.dano_base=dano_base;
    }

    public String getTipo() {
        return tipo;
    }

    public void atacar(Personajes personaje){
        System.out.println(this.nombre + " contraataca a " + personaje.getNombre() + " causando " + this.dano_base + " de daño.");
        personaje.recibirDano(this.dano_base);
    }

    @Override
    public void describir() {

        System.out.println(
                "Nombre= " + nombre  + "\n" +
                "Salud= " + salud + "\n" +
                "Nivel= " + nivel + "\n" +
                "Tipo= " + tipo + "\n" +
                "Dano base= " + dano_base + "\n" +
                "CoordenadaX= " + coordenadaX + "\n" +
                "CoordenadaY= " + coordenadaY + "\n" +
                "Vivo= " + vivo + "\n" +
                "Exp= " + exp + "\n"
                );
    }

    public void printDragon(){
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣤⣶⡋⠁⠀⠀⠀⠀⢀⣀⣀⡀\n" +
                "⠀⠀⠀⠀⠀⠠⠒⣶⣶⣿⣿⣷⣾⣿⣿⣿⣿⣛⣋⣉⠀⠀\n" +
                "⠀⠀⠀⠀⢀⣤⣞⣫⣿⣿⣿⡻⢿⣿⣿⣿⣿⣿⣦⡀⠀⠀\n" +
                "⠀⠀⣶⣾⡿⠿⠿⠿⠿⠋⠈⠀⣸⣿⣿⣿⣿⣷⡈⠙⢆⠀\n" +
                "⠀⠀⠉⠁⠀⠤⣤⣤⣤⣤⣶⣾⣿⣿⣿⣿⠿⣿⣷⠀⠀⠀\n" +
                "⠀⠀⣠⣴⣾⣿⣿⣿⣿⣿⣿⣿⣿⡿⠟⠁⠀⢹⣿⠀⠀⠀\n" +
                "⢠⣾⣿⣿⣿⣿⠟⠋⠉⠛⠋⠉⠁⣀⠀⠀⠀⠸⠃⠀⠀⠀\n" +
                "⣿⣿⣿⣿⠹⣇⠀⠀⠀⠀⢀⡀⠀⢀⡙⢷⣦⣄⡀⠀⠀⠀\n" +
                "⣿⢿⣿⣿⣷⣦⠤⠤⠀⠀⣠⣿⣶⣶⣿⣿⣿⣿⣿⣷⣄⠀\n" +
                "⠈⠈⣿⡿⢿⣿⣿⣷⣿⣿⡿⢿⣿⣿⣁⡀⠀⠀⠉⢻⣿⣧\n" +
                "⠀⢀⡟⠀⠀⠉⠛⠙⠻⢿⣦⡀⠙⠛⠯⠤⠄⠀⠀⠈⠈⣿\n" +
                "⠀⠈⠀⠀⠀⠀⠀⠀⠀⠀⠈⠻⡆⠀⠀⠀⠀⠀⠀⠀⢀⠟\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n");
        describir();
    }

    public void printCriaturas(){
        System.out.println("            _.------.                        .----.__\n" +
                "           /         \\_.       ._           /---.__  \\\n" +
                "          |  O    O   |\\\\___  //|          /       `\\ |\n" +
                "          |  .vvvvv.  | )   `(/ |         | o     o  \\|\n" +
                "          /  |     |  |/      \\ |  /|   ./| .vvvvv.  |\\\n" +
                "         /   `^^^^^'  / _   _  `|_ ||  / /| |     |  | \\\n" +
                "       ./  /|         | O)  O   ) \\|| //' | `^vvvv'  |/\\\\\n" +
                "      /   / |         \\        /  | | ~   \\          |  \\\\\n" +
                "      \\  /  |        / \\ Y   /'   | \\     |          |   ~\n" +
                "       `'   |  _     |  `._/' |   |  \\     7        /\n" +
                "         _.-'-' `-'-'|  |`-._/   /    \\ _ /    .    |\n" +
                "    __.-'            \\  \\   .   / \\_.  \\ -|_/\\/ `--.|_\n" +
                " --'                  \\  \\ |   /    |  |              `-\n" +
                "                       \\uU \\UU/     |  / ");
        describir();
    }

    public void printMinotauro(){
        System.out.println("⠀⠀⠀⠀⢀⣀⣤⣤⣤⣤⣄⡀⠀⠀⠀⠀\n" +
                "⠀⢀⣤⣾⣿⣾⣿⣿⣿⣿⣿⣿⣷⣄⠀⠀\n" +
                "⢠⣾⣿⢛⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⡀\n" +
                "⣾⣯⣷⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧\n" +
                "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "⣿⡿⠻⢿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠻⢿⡵\n" +
                "⣿⡇⠀⠀⠉⠛⠛⣿⣿⠛⠛⠉⠀⠀⣿⡇\n" +
                "⣿⣿⣀⠀⢀⣠⣴⡇⠹⣦⣄⡀⠀⣠⣿⡇\n" +
                "⠋⠻⠿⠿⣟⣿⣿⣦⣤⣼⣿⣿⠿⠿⠟⠀\n" +
                "⠀⠀⠀⠀⠸⡿⣿⣿⢿⡿⢿⠇⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠈⠁⠈⠁⠀⠀⠀⠀⠀⠀");
        describir();
    }

    public void printGrifo(){
        System.out.println("             ______,---'__,---'\n" +
                "         _,-'---_---__,---'\n" +
                "  /_    (,  ---____',\n" +
                " /  ',,   `, ,-'\n" +
                ";/)   ,',,_/,'\n" +
                "| /\\   ,.'//\\\n" +
                "`-` \\ ,,'    `.\n" +
                "     `',   ,-- `.\n" +
                "     '/ / |      `,         _\n" +
                "     //'',.\\_    .\\\\      ,{==>-\n" +
                "  __//   __;_`-  \\ `;.__,;'\n" +
                "((,--,) (((,------;  `--' ");
        describir();
    }

}
