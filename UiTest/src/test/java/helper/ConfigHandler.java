package helper;

import java.io.InputStream;
import java.util.Properties;

public class ConfigHandler {

    public static String getConfigValue(String key)  {
        InputStream inputStream;
        Properties prop = new Properties();
        String propFileName = "config.properties";
        inputStream = ConfigHandler.class.getClassLoader().getResourceAsStream(propFileName);
        try {
        if (inputStream != null)
            prop.load(inputStream);
        }
        catch (Exception e){
            System.out.println(e.getStackTrace());

        }
        return  prop.getProperty(key);
        }


}
