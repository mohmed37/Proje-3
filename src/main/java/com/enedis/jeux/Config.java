package com.enedis.jeux;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Méthode getProperties pou récuperer les éléments dans le fichier config.properties
 */



public class Config {
    public static String getProperties(String propertyName) throws IOException {
        Properties prop = new Properties();
        FileInputStream in = new FileInputStream("resources/config.properties");
        prop.load(in);
        in.close();
        return prop.getProperty(propertyName);
    }

}
