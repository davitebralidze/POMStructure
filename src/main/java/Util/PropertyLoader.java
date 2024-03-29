package Util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyLoader {
    static String direction = "config.properties";

    public static String returnConfigValue(final String property) {
        Properties properties = new Properties();

        try (InputStream propFileInpStream = PropertyLoader.class.getClassLoader()
                .getResourceAsStream(direction)) {

            properties.load(propFileInpStream);
            return properties.getProperty(property);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return property;
    }
}
