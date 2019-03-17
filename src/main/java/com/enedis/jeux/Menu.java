package com.enedis.jeux;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    protected static final Logger parentLogger = LogManager.getLogger();
    int choix1 = 0;
    int choix2 = 0;
    Scanner clavier = new Scanner(System.in);



        int menu1 () throws IOException {

            Menu menu=new Menu();
            parentLogger.info("Selection du style de jeux");
            System.out.println("Avec quel style de jeux voulez-vous jouer?");
            System.out.println(" - 1 - Recherche +/- ");
            System.out.println(" - 2 - Mastermind ");
            try {
                choix1 = clavier.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Votre saisie erronée");
                parentLogger.warn("Mauvaise saisie : " +choix1);
                return menu.menu1();
            }
            if (choix1 > 0 && choix1 <= 2) {
                parentLogger.info("Selection du style de jeux");
                System.out.println("Avec quel mode de jeu voulez-vous jouer?");
                System.out.println(" - 1 - Challenger ");
                System.out.println(" - 2 - Défenseur ");
                System.out.println(" - 3 - Duel");
                try {
                    choix2 = clavier.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Votre saisie est erronée");
                    parentLogger.warn("Mauvaise saisie : " +choix2);
                    return menu.menu1();
                }
            } else {
                System.out.println("Vous n'avez pas choisi parmis les modes de jeux proposés");
                parentLogger.warn("Mauvaise saisie : " +choix1);
                return menu1();
            }

            if (choix2 > 0 && choix2 <= 3) {
                if (choix1 == 1 && choix2 == 1) {
                    JeuxRecherche.chalengerRecherche();
                }
                if (choix1 == 1 && choix2 == 2) {
                    JeuxRecherche.defenseurRecherche();
                }
                if (choix1 == 1 && choix2 == 3) {
                    JeuxRecherche.duelRecherche();
                }
                if (choix1 == 2 && choix2 == 1) {
                    JeuxMastermind.challengerMastermind();
                }
                if (choix1 == 2 && choix2 == 2) {
                    JeuxMastermind.defenseurMastermind();
                }
                if (choix1 == 2 && choix2 == 3) {
                    JeuxMastermind.duelMastermind();
                }
            } else {
                System.out.println("Vous n'avez pas choisi parmis les modes de jeux proposés");
                parentLogger.warn("Mauvaise saisie : " +choix2);
                return menu.menu1();
            }
            return menu1();
        }
        void finDeCycle ( int choixDuJeu) throws IOException {

            parentLogger.info("Fin du cycle selection : Que voulez vous faire");
            int choixmenu = 0;
            Menu menu =new Menu();

            System.out.println("Que voulez vous faire? :");
            System.out.println(" ");
            System.out.println("- 1 - Rejouer au même jeu");
            System.out.println("- 2 - Jouer à un autre jeu");
            System.out.println("- 3 - Quitter le jeu");
            try {
                choixmenu = clavier.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Votre saisie erronée");
                parentLogger.warn("Mauvaise saisie : " +choixmenu);
                menu.finDeCycle(choixDuJeu = choixDuJeu);
            }
            if (choixmenu == 1) {
                if (choixDuJeu == 1) {
                    JeuxRecherche.chalengerRecherche();
                }
                if (choixDuJeu == 2) {
                    JeuxRecherche.defenseurRecherche();
                }
                if (choixDuJeu == 3) {
                    JeuxRecherche.duelRecherche();
                }
                if (choixDuJeu == 4) {
                    JeuxMastermind.challengerMastermind();
                }
                if (choixDuJeu == 5) {
                    JeuxMastermind.defenseurMastermind();
                }
                if (choixDuJeu == 6) {
                    JeuxMastermind.duelMastermind();
                }
            }
            if (choixmenu == 2) {
                menu.menu1();
            }

            if (choixmenu == 3) {
                System.out.println("Fin du jeu ");
                parentLogger.info("Fin du jeu");
                System.exit(0);
            } else {
                System.out.println("Vous n'avez pas choisi parmis les choix proposés");
                parentLogger.warn("Mauvaise saisie : " +choixDuJeu);
                menu.finDeCycle(choixDuJeu = choixDuJeu);
            }
        }

    }


