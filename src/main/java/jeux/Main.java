package jeux;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class Main {
    protected static final Logger parentLogger = LogManager.getLogger();


    public static void main (String[]arg) throws IOException {
        parentLogger.info("Démarrage du jeu");
        Menu menu = new Menu();
        menu.menu1();

    }





}
