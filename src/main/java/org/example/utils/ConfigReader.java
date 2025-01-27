package org.example.utils;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class ConfigReader {
    /**
     * reads the value of key from config file
     * @param key the name of the key to red
     * @return value of the key
     */

    public static String read(String key){

        Properties properties = new Properties();
        try{
            InputStream inputStream = Files.newInputStream(Paths.get("src/config.properties"));
            properties.load(inputStream);
        } catch (Exception e) {
            System.out.println("Exception" + e);
        }
        return properties.getProperty(key);
    }

    /**
     * simple alias for the read method to get the value of the key
     * @param key the name of the key to red
     * @return value of the key
     */

    public static String get(String key){
        return read(key);
    }
}
