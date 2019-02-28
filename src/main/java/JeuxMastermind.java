package main.java;

public class JeuxMastermind {

    static void challengerMastermind() {
        Combinaison combinaison = new Combinaison();
        Menu menu =new Menu();
        combinaison.combinaisonAleatoire();
        for (int i = 1; i <= menu.nbtour; i++) {
            combinaison.combinaisonManuel();
            combinaison.comparaison(false, false);
        }
        System.out.print("Vous avez perdu le code secret était : "+combinaison.kstring);
        System.out.println(" ");
        menu.finDeCycle(4);
    }

    static void defenseurMastermind() {

        Combinaison combinaison = new Combinaison();
        Menu menu =new Menu();
        combinaison.ordinateur(true, false,false);
        for (int i = 1; i <= menu.nbtour; i++) {
            combinaison.ordinateur(false, false,false);
        }
        System.out.println("Vous avez gagné!");
        System.out.println(" ");
        menu.finDeCycle(5);
    }

    static void duelMastermind() {
        Combinaison combinaison = new Combinaison();
        Menu menu =new Menu();
        combinaison.ordinateur(true, false,true);
        combinaison.combinaisonAleatoire();
        for (int j = 1; j <= menu.nbtour; j++) {
            combinaison.ordinateur(false, false,true);
            combinaison.combinaisonManuel();
            combinaison.comparaison(false, true);
        }
        System.out.print("Vous n'avez pas pu vous départager et le code secret de l'ordinateur était: "+combinaison.kstring);
        System.out.println(" ");
        menu.finDeCycle(6);
    }
}
