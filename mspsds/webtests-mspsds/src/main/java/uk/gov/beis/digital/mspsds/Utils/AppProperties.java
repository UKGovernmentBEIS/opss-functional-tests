package uk.gov.beis.digital.mspsds.Utils;

import java.io.FileInputStream;
import java.util.Properties;

public class AppProperties  {
	private static Properties properties = null;

    private static String env = System.getenv("ENV");

    

    public static Properties getProperties() {


        if (properties == null) {
            System.out.println("Properties file area");
            // Check whether the property file location is specified in environment variable "properties"
            // otherwise default
            final String propertyFile;
            if (env == null) {
                propertyFile = System.getProperty("properties", System.getProperty("user.dir") + "/src/test/resources/TestConfig-test.properties");
            } else {
            	//to run on test build on jenkins with env as parameter to pass. 
            	
                propertyFile = System.getProperty("properties", System.getProperty("user.dir") + "/src/test/resources/TestConfig-" + env + ".properties");
            }

            System.out.println("using property file from " + propertyFile);

            try {
                System.out.println("Loading properties from file " + propertyFile);
                properties = new Properties();
                properties.load(new FileInputStream(propertyFile));
            } catch (Throwable e) {
                e.printStackTrace();
            } // try
        } // if

        return properties;
    }


    public static String get(String propertyKey) {
        if (propertyKey.equalsIgnoreCase("browser") ||
                propertyKey.equalsIgnoreCase("env")) {

            if (System.getProperty(propertyKey) != null) {
                return System.getProperty(propertyKey);
            }
        }

        return getProperties().getProperty(propertyKey);
    }

}
