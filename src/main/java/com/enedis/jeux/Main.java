package com.enedis.jeux;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;

import java.util.Properties;

public class Main {
    protected static final Logger parentLogger = LogManager.getLogger();


    public static void main(String[] args) throws IOException {
        File dossier = new File("0");
        if (args.length == 1) {
            dossier = new File(args[0]);
        }
        setProperties(String.valueOf(dossier));
        getProperties(" ");
        parentLogger.info("Démarrage du jeu");
        Menu menu = new Menu();
        menu.menu1();
    }


    public static void setProperties(String modeDev) throws IOException {
        Properties prop = new Properties();
        OutputStream output = null;
        output = new FileOutputStream("resources/dev.properties");
        prop.setProperty("ModeDev", modeDev);
        prop.store(output, null);

    }

    public static String getProperties(String propertyName) throws IOException {
        Properties prop = new Properties();
        FileInputStream in = new FileInputStream("resources/dev.properties");
        prop.load(in);
        in.close();
        return prop.getProperty(propertyName);
    }


}