package step;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class BrowserBeanFactory {


   public static WebDriver driver;

    @Before
    public  WebDriver getDriver() throws InterruptedException, IOException {
        InputStream inputStream;
        Properties prop = new Properties();
        String propFileName = "config.properties";
        inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

        if (inputStream != null) {
            prop.load(inputStream);
        } else {
            throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
        }


        System.setProperty("webdriver.chrome.driver",prop.getProperty("chromePath"));
        driver = new ChromeDriver();

        return driver;
    }

    @After
    public  void closeDown(){
        driver.quit();
    }


}
