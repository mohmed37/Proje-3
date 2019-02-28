package main.java;

public class JeuxRecherche {
    static void chalengerRecherche() {
        Combinaison combinaison = new Combinaison();
        Menu menu =new Menu();
        combinaison.combinaisonAleatoire();
        for (int i = 1; i <= menu.nbtour; i++) {
            combinaison.combinaisonManuel();
            combinaison.comparaison(true, false);
        }
        System.out.print("Vous avez perdu le code secret était : "+combinaison.kstring);
        System.out.println(" ");
        menu.finDeCycle(1);
    }

    static void defenseurRecherche() {
        Combinaison combinaison = new Combinaison();
        Menu menu =new Menu();
        combinaison.ordinateur(true, true,false);
        for (int i = 1; i <= menu.nbtour; i++) {
            combinaison.ordinateur(false, true,false);
        }
        System.out.println("Vous avez gagné!");
        System.out.println(" ");
        menu.finDeCycle(2);
    }

    static void duelRecherche() {
        Combinaison combinaison = new Combinaison();
        Menu menu =new Menu();
        combinaison.ordinateur(true, true,true);
        combinaison.combinaisonAleatoire();
        for (int j = 1; j <= menu.nbtour; j++) {
            combinaison.ordinateur(false, true,true);
            combinaison.combinaisonManuel();
            combinaison.comparaison(true, true);
        }
        System.out.print("Vous n'avez pas pu vous départager et le code secret de l'ordinateur était: "+combinaison.kstring);
        System.out.println(" ");
        menu.finDeCycle(3);
    }
}
