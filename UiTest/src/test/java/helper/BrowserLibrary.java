package helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserLibrary {
    public WebDriver getbrowser()  {
        WebDriver driver;

        switch(System.getenv("BROWSER")){


                case "chrome":
                System.setProperty("webdriver.chrome.driver", ConfigHandler.getConfigValue("chromePath"));
                driver = new ChromeDriver();
                break;

                case "ff":
                System.setProperty("webdriver.gecko.driver",  ConfigHandler.getConfigValue("ffPath"));
                DesiredCapabilities capabilities = DesiredCapabilities.firefox();
                capabilities.setCapability("marionette", true);
                driver = new FirefoxDriver(capabilities);
                break;

                default:
                System.setProperty("webdriver.chrome.driver", ConfigHandler.getConfigValue("chromePath"));
                driver = new ChromeDriver();
                break;
        }

        return driver;
    }

}
