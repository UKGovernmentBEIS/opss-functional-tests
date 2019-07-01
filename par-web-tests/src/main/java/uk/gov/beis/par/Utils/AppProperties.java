package uk.gov.beis.par.Utils;

import java.io.FileInputStream;
import java.util.Properties;

public class AppProperties  {

    private static Properties properties;
    private static String env = System.getenv("ENV");

    public static String get(String propertyKey) {
        if (System.getProperty(propertyKey) != null) {
            return System.getProperty(propertyKey);
        }
        return getProperties().getProperty(propertyKey);
    }

    private static Properties getProperties() {
        if (properties == null) {
            // Check whether the property file location is specified in environment variable "properties", otherwise default
            final String propertyFile;
            if (env == null) {
                propertyFile = System.getProperty("properties", System.getProperty("user.dir") + "/src/test/resources/TestConfig-test.properties");
            } else {
                propertyFile = System.getProperty("properties", System.getProperty("user.dir") + "/src/test/resources/TestConfig-" + env + ".properties");
            }

            try {
                System.out.println("Loading properties from file: " + propertyFile);
                properties = new Properties();
                properties.load(new FileInputStream(propertyFile));
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }

        return properties;
    }
}
