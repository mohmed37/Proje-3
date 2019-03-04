package main.resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
    public static String getProperties(String propertyName) throws IOException {
        Properties prop = new Properties();
        FileInputStream in = new FileInputStream("src/main/resources/config.properties");
        prop.load(in);
        in.close();
        return prop.getProperty(propertyName);
    }

}
