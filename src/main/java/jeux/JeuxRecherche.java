package jeux;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class JeuxRecherche {
    protected static final Logger parentLogger = LogManager.getLogger();

    static void chalengerRecherche() throws IOException {
        parentLogger.info("jeu selectionné : Jeux Recherche");

        int nbtour = 0;        
            try {
            nbtour = Integer.valueOf(Config.getProperties("ConfNbTour1"));
            Combinaison.nbcombinaison = Integer.valueOf(Config.getProperties("ConfNbCombinaison"));
            }catch(IOException e){
                System.out.println("Il y a eu une erreur avec le chargement du fichier");
                parentLogger.warn("Il y a eu une erreur avec le chargement du fichier properties");
            }
        Combinaison combinaison = new Combinaison();
        Menu menu =new Menu();
        combinaison.combinaisonAleatoire();
        for (int i = 1; i <= nbtour; i++) {
            combinaison.combinaisonManuel();
            combinaison.comparaison(true, false);
        }
        System.out.print("Vous avez perdu le code secret était : "+combinaison.kstring);
        System.out.println(" ");
        menu.finDeCycle(1);
    }

    static void defenseurRecherche() throws IOException {
        parentLogger.info("jeu selectionné :  defenseur Recherche");
        int nbtour = 0;
        try {
            nbtour = Integer.valueOf(Config.getProperties("ConfNbTour1"));
            Combinaison.nbcombinaison = Integer.valueOf(Config.getProperties("ConfNbCombinaison"));
        }catch(IOException e){
            System.out.println("Il y a eu une erreur avec le chargement du fichier");
            parentLogger.warn("Il y a eu une erreur avec le chargement du fichier properties");
        }
        Combinaison combinaison = new Combinaison();
        Menu menu =new Menu();
        combinaison.ordinateur(true, true,false);
        for (int i = 1; i <= nbtour; i++) {
            combinaison.ordinateur(false, true,false);
        }
        System.out.println("Vous avez gagné!");
        System.out.println(" ");
        menu.finDeCycle(2);
    }

    static void duelRecherche() throws IOException {
        parentLogger.info("jeu selectionné :   duel Recherche");
        int nbtour = 0;
        try {
            nbtour = Integer.valueOf(Config.getProperties("ConfNbTour1"));
            Combinaison.nbcombinaison = Integer.valueOf(Config.getProperties("ConfNbCombinaison"));
        }catch(IOException e){
            System.out.println("Il y a eu une erreur avec le chargement du fichier");
            parentLogger.warn("Il y a eu une erreur avec le chargement du fichier properties");
        }
        Combinaison combinaison = new Combinaison();
        Menu menu =new Menu();
        combinaison.ordinateur(true, true,true);
        combinaison.combinaisonAleatoire();
        for (int j = 1; j <= nbtour; j++) {
            combinaison.ordinateur(false, true,true);
            combinaison.combinaisonManuel();
            combinaison.comparaison(true, true);
        }
        System.out.print("Vous n'avez pas pu vous départager et le code secret de l'ordinateur était: "+combinaison.kstring);
        System.out.println(" ");
        menu.finDeCycle(3);
    }
}
