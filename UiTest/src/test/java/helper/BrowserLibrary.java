package helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;

public class BrowserLibrary {
    public WebDriver getbrowser() throws IOException {
        WebDriver driver;

        switch(System.getenv("BROWSER")){

            case "chrome":
                System.setProperty("webdriver.chrome.driver", ConfigHandler.getConfigValue("chromePath"));
                driver = new ChromeDriver();
                break;
            case "ff":
                System.setProperty("webdriver.gecko.driver", ConfigHandler.getConfigValue("ffPath"));
                driver = new FirefoxDriver();
                break;
            default:
                System.setProperty("webdriver.chrome.driver", ConfigHandler.getConfigValue("chromePath"));
                driver = new ChromeDriver();
                break;


        }




        return driver;
    }

}
