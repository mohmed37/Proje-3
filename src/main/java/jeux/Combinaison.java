package jeux;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;


public class Combinaison {
    protected static final Logger parentLogger = LogManager.getLogger();
    Scanner clavier = new Scanner(System.in);
    Random rand = new Random();
    static int nbcombinaison;
    int i = 0;
    char resultat[] = new char[nbcombinaison];
    char resultat2[] = new char[nbcombinaison];
    int k[] = new int[nbcombinaison];
    int v[] = new int[nbcombinaison];
    int c[] = new int[nbcombinaison];
    int t[] = new int[nbcombinaison];
    int code3 = 0;
    int code4 = 0;
    String kstring;
    String tstring;
    int modeDev;
    int modeMastermind;

    /**
     * Méthode pour créer le code secret en mode aléatoire.
     *  @param recherche si le mode de jeu est recherche (true) les chiffres utilisables vont de 0  9.
     *                   si le mode de jeu est mastermind (false) le chifres utilisables vot de 4 à 10.
     *
     */

    void combinaisonAleatoire( boolean recherche) {
        parentLogger.info("combinaison Aleatoire");

        try {
            modeMastermind = Integer.valueOf(Config.getProperties("ModeMastermind"));
            modeDev = Integer.valueOf(Config.getProperties("ModeDev"));
        } catch (IOException e) {
            System.out.println("Il y a eu une erreur avec le chargement du fichier");
            parentLogger.warn("Il y a eu une erreur avec le chargement du fichier properties");
        }


        StringBuilder sb = new StringBuilder();
        for (i = 0; i <= nbcombinaison - 1; i++) {
            if (recherche==true){
                k[i] = rand.nextInt(9);
            }else {
                k[i] = (modeMastermind)+rand.nextInt(10-(modeMastermind));

            }

            sb.append(k[i]);
            kstring = sb.toString();
        }
        parentLogger.info("Combinaison secrète ordinateur : " + kstring);
        if (modeDev == 1){
            System.out.println("Combinaison secrète ordinateur : " + kstring);
        }else {
        }


    }

    /**
     * méthode pour écrire le code secret sur le clavier.
     *  @param recherche si le mode de jeu est recherche (true) les chiffres utilisables vont de 0  9.
     *                   si le mode de jeu est mastermind (false) le chifres utilisables vot de 4 à 10.
     */

    void combinaisonManuel(boolean recherche) {
        parentLogger.info("combinaison Manue");

        System.out.println("Taper votre code");
        int code1 = 0;
        try {
            code1 = clavier.nextInt();
            parentLogger.info("Combinaison manuel code tapé : " +  code1 );

            code3 = code1;
            int nbCommbMax = 1;
            int code2 = code1;
            for (int i = 1; i <= nbcombinaison - 1; i++) {
                nbCommbMax = 10 * nbCommbMax;
            }
            if (code1 < nbCommbMax * 10 || code1 == 0) {
                for (int i = 0; i <= nbcombinaison - 1; i++) {
                    code1 = code2 / nbCommbMax;
                    code2 = code2 % nbCommbMax;
                    c[i] = code1;
                    nbCommbMax = nbCommbMax / 10;

                }
                if (recherche==false){
                    for (int i = 0; i <= nbcombinaison - 1; i++) {
                        if (c[i] <modeMastermind){
                            System.out.println("les chiffres doivent être > ou = à " +modeMastermind );
                            parentLogger.info("chiffre > que  "+modeMastermind);
                            combinaisonManuel(recherche==false);
                        }else {

                        }}}

            } else {
                System.out.println("Le code tapé est plus grand que la combinaison qui est de : " + nbcombinaison + " chiffres");
                parentLogger.info("Combinaison manuel code tapé plus grand que la combinaison: "+ nbcombinaison +"code tapé : "+  code1 );
                combinaisonManuel(recherche==false);

            }
        } catch (InputMismatchException e) {
            System.out.println("Votre saisie est erronée");
            parentLogger.info("Votre saisie est erronée "+code1 );
            clavier = new Scanner(System.in);
            combinaisonManuel(recherche==false);
        }


    }

    /**
     * Méthode pour comparer le code secret avec le code proposé par le joueur.
     *  @param recherche si vrai ou faux on est en style du jeu recherche.
     *  @param  duel si vrai ou faux on est en mode duel.
     */

    void comparaison(boolean recherche, boolean duel) throws IOException {
        parentLogger.info("comparaison");
        int result = 0;
        for (i = 0; i <= nbcombinaison - 1; i++) {
            if (k[i] > c[i]) {
                resultat[i] = '+';
            }
            if (k[i] < c[i]) {
                resultat[i] = '-';
            }
            if (k[i] == c[i]) {
                resultat[i] = '=';
                result++;
            }
        }
        if (nbcombinaison == result) {
            Menu menu= new Menu();

            System.out.print("vous avez gagné");
            System.out.println(" ");
            if (recherche == false && duel == false) {
                menu.finDeCycle(4);
            }
            if (recherche == true && duel == false) {
                menu.finDeCycle(1);
            }
            if (recherche == false && duel == true) {
                menu.finDeCycle(6);
            }
            if (recherche == true && duel == true) {
                menu.finDeCycle(3);
            }

        } else {
            System.out.print("Propasistion : ");
            for (i = 0; i <= nbcombinaison - 1; i++) {
                System.out.print(c[i]);
            }
            if (recherche) {
                System.out.print(" -> Réponse : ");
                System.out.print(resultat);
                System.out.println(" ");
            } else {
                int present = 0;
                int present1 = 0;
                int persentTotal = 0;
                StringBuffer tableau = new StringBuffer(String.valueOf(code3));
                StringBuffer tableau1 = new StringBuffer(kstring);

                for (i = 0; i <= nbcombinaison - 1; i++) {
                    String kb = String.valueOf(k[i]);
                    String nbrecherché = kb;
                    int nb = tableau.indexOf(nbrecherché);
                    if (nb >= 0) {
                        present++;
                    }
                }
                for (i = 0; i <= nbcombinaison - 1; i++) {
                    String kb1 = String.valueOf(c[i]);
                    String nbrecherché1 = kb1;
                    int nb1 = tableau1.indexOf(nbrecherché1);
                    if (nb1 >= 0) {
                        present1++;
                    }
                }
                if (present < present1) {
                    persentTotal = (present - result);
                } else {
                    persentTotal = (present1 - result);
                }
                System.out.print(" -> Réponse : " + persentTotal + " présent(s), " + result + " bien placé(s)");
                System.out.println(" ");
            }
        }
    }

    /**
     * Méthode pour la recherche du code secret par l'ordinateur avec le  mode
     * de jeux "duel".
     *
     * @param ordi ordinateur propose un premier code et dans un second temps il compare son code aléatoire avec     *
     * le code secret.
     * @param recherche si vrai ou faux on est en style du jeu recherche.
     * @param duel  si true nous utilisons le mode duel si false c'est pour les deux autres mode.
     *
     */
    void ordinateur(boolean ordi, boolean recherche,boolean duel) throws IOException {
        parentLogger.info("ordinateur");
        int result1 = 0;
        int min;
        int max=9;

        modeMastermind = Integer.valueOf(Config.getProperties("ModeMastermind"));
        if (recherche==true){
            min=0;
        }else {
            min=modeMastermind;
        }

        StringBuilder sb = new StringBuilder();


        if (ordi) {

            int code1 = 0;
            System.out.println("Taper le code secret");
            try {
                code1 = clavier.nextInt();

                int nbCommbMax = 1;
                code4 = code1;
                int code2 = code1;
                for (int i = 1; i <= nbcombinaison - 1; i++) {
                    nbCommbMax = 10 * nbCommbMax;
                }
                if (code1 < nbCommbMax * 10 || code1 == 0)
                    for (int i = 0; i <= nbcombinaison - 1; i++) {
                        code1 = code2 / nbCommbMax;
                        code2 = code2 % nbCommbMax;
                        v[i] = code1;
                        nbCommbMax = nbCommbMax / 10;

                    }

                else {
                    System.out.println(" ");
                    System.out.println("Le code tapé est plus grande que la combinaison qui est de : " + nbcombinaison + " chiffres");
                    parentLogger.info("Combinaison manuel code tapé plus grand que la combinaison: "+ nbcombinaison +"code tapé : "+  code1 );
                    ordinateur(true, true,false);
                }
            } catch (InputMismatchException e) {
                System.out.println("Votre saisie est erronée");
                parentLogger.info("Votre saisie est erronée "+code1 );
                clavier = new Scanner(System.in);
                ordinateur(true, true,false);
            }

            if (recherche==false){
                for ( i = 0; i <= nbcombinaison - 1; i++) {
                    if (v[i] < modeMastermind){
                        System.out.println("les chiffres doivent être < ou = à " +modeMastermind );
                        parentLogger.info("chiffre < que  "+modeMastermind);
                        ordinateur(true, true,false);
                    }else {

                    }}}
            for (i = 0; i <= nbcombinaison - 1; i++) {
                t[i]= (modeMastermind)+rand.nextInt(10-(modeMastermind));}
        } else {

            for (i = 0; i <= nbcombinaison - 1; i++) {
                if (v[i] > t[i]) {
                    resultat2[i] = '+';
                } else if (v[i] < t[i]) {
                    resultat2[i] = '-';
                } else if (v[i] == t[i]) {
                    resultat2[i] = '=';
                    result1++;
                }
            }
            for (i = 0; i <= nbcombinaison - 1; i++) {
                sb.append(t[i]);
            }
            tstring = sb.toString();
            if (recherche) {
                System.out.print("Propasistion de l'ordinateur: " + tstring + " -> Réponse de l'ordinateur: ");
                System.out.println(resultat2);
            } else {
                int present = 0;
                int present1 = 0;
                int persentTotal = 0;
                StringBuffer tableau2 = new StringBuffer(String.valueOf(code4));
                StringBuffer tableau3 = new StringBuffer(tstring);

                for (i = 0; i <= nbcombinaison - 1; i++) {
                    String tb = String.valueOf(t[i]);
                    String nbrecherché2 = tb;
                    int nb2 = tableau2.indexOf(nbrecherché2);
                    if (nb2 >= 0) {
                        present++;
                    }
                }

                for (i = 0; i <= nbcombinaison - 1; i++) {
                    String tb1 = String.valueOf(v[i]);
                    String nbrecherché3 = tb1;
                    int nb3 = tableau3.indexOf(nbrecherché3);
                    if (nb3 >= 0) {
                        present1++;
                    }
                }
                if (present <= present1) {
                    persentTotal = (present - result1);
                } else {
                    persentTotal = (present1 - result1);
                }
                System.out.print("Proposition : " + tstring);
                System.out.print(" -> Réponse : " + persentTotal + " présent(s), " + result1 + " bien placé(s)");
                System.out.println(" ");
            }
            for (i = 0; i <= nbcombinaison - 1; i++) {
                if (v[i] > t[i] && v[i] != t[i]) {
                    t[i] = ((t[i] + 1) + rand.nextInt(max - t[i]));
                    System.out.println(v[i]+" > "+t[i]);
                }
                if (v[i] < t[i] && v[i] != t[i]) {
                    t[i] = (min+1 ) + rand.nextInt(max-min);
                    System.out.println(v[i]+" < "+t[i]);
                } else if (nbcombinaison == result1) {
                    Menu menu = new Menu();
                    System.out.println(" ");
                    System.out.println("L'ordinateur à gagné");
                    if (recherche == false && duel == false) {
                        menu.finDeCycle(5);
                    }
                    if (recherche == true && duel == false) {
                        menu.finDeCycle(2);
                    }
                    if (recherche == false && duel == true) {
                        menu.finDeCycle(6);
                    }
                    if (recherche == true && duel == true) {
                        menu.finDeCycle(3);
                    }
                }
            }
        }
        System.out.println(" ");
    }

}
