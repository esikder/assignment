package helper;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigHandler {

    public static String getConfigValue(String key) throws IOException {
        InputStream inputStream;
        Properties prop = new Properties();
        String propFileName = "config.properties";
        inputStream = ConfigHandler.class.getClassLoader().getResourceAsStream(propFileName);

        if (inputStream != null) {
            prop.load(inputStream);
        } else {
            throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
        }
        return  prop.getProperty(key);
    }

}
