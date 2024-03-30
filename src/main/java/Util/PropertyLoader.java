package Util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

public class PropertyLoader {
    private final String environment;

    public PropertyLoader(String environment) {
        this.environment = environment;
    }

    public String returnConfigValue(final String property) {
        Logger logger = Logger.getLogger(PropertyLoader.class.getName());
        String direction = "data-qa.properties";
        switch (environment) {
            case "qa" -> direction = "data-qa.properties";
            case "uat" -> direction = "data-uat.properties";
            case "live" -> direction = "data-live.properties";
            default -> {
                logger.info("Such environment does not exist");
                System.exit(0);
            }
        }
        Properties properties = new Properties();
        try (InputStream propFileInpStream = PropertyLoader.class.getClassLoader().getResourceAsStream(direction)) {
            properties.load(propFileInpStream);
            return properties.getProperty(property);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return property;
    }
}
