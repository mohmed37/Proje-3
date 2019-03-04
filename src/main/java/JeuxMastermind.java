package main.java;

import main.resources.Config;

import java.io.IOException;

public class JeuxMastermind {

    static void challengerMastermind() {
        int nbtour = 0;
        try {
            nbtour = Integer.valueOf(Config.getProperties("ConfNbTour1"));
            Combinaison.nbcombinaison = Integer.valueOf(Config.getProperties("ConfNbCombinaison"));
        }catch(IOException e){
            System.out.println("Il y a eu une erreur avec le chargement du fichier properties:");
        }
        Combinaison combinaison = new Combinaison();
        Menu menu =new Menu();
        combinaison.combinaisonAleatoire();
        for (int i = 1; i <= nbtour; i++) {
            combinaison.combinaisonManuel();
            combinaison.comparaison(false, false);
        }
        System.out.print("Vous avez perdu le code secret était : "+combinaison.kstring);
        System.out.println(" ");
        menu.finDeCycle(4);
    }

    static void defenseurMastermind() {
        int nbtour = 0;
        try {
            nbtour = Integer.valueOf(Config.getProperties("ConfNbTour1"));
            Combinaison.nbcombinaison = Integer.valueOf(Config.getProperties("ConfNbCombinaison"));
        }catch(IOException e){
            System.out.println("Il y a eu une erreur avec le chargement du fichier properties:");
        }

        Combinaison combinaison = new Combinaison();
        Menu menu =new Menu();
        combinaison.ordinateur(true, false,false);
        for (int i = 1; i <= nbtour; i++) {
            combinaison.ordinateur(false, false,false);
        }
        System.out.println("Vous avez gagné!");
        System.out.println(" ");
        menu.finDeCycle(5);
    }

    static void duelMastermind() {
        int nbtour = 0;
        try {
            nbtour = Integer.valueOf(Config.getProperties("ConfNbTour1"));
            Combinaison.nbcombinaison = Integer.valueOf(Config.getProperties("ConfNbCombinaison"));
        }catch(IOException e){
            System.out.println("Il y a eu une erreur avec le chargement du fichier properties:");
        }
        Combinaison combinaison = new Combinaison();
        Menu menu =new Menu();
        combinaison.ordinateur(true, false,true);
        combinaison.combinaisonAleatoire();
        for (int j = 1; j <= nbtour; j++) {
            combinaison.ordinateur(false, false,true);
            combinaison.combinaisonManuel();
            combinaison.comparaison(false, true);
        }
        System.out.print("Vous n'avez pas pu vous départager et le code secret de l'ordinateur était: "+combinaison.kstring);
        System.out.println(" ");
        menu.finDeCycle(6);
    }
}
