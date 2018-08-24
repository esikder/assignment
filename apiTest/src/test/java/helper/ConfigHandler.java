package helper;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ConfigHandler {

    public static String getConfigValue(String key)  {
        Properties prop =  new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream("config.properties");
            prop.load(input);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return  prop.getProperty(key);
        }


}
