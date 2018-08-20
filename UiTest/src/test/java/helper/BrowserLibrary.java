package helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class BrowserLibrary {

    public WebDriver getbrowser() throws IOException {

        System.setProperty("webdriver.chrome.driver", ConfigHandler.getConfigValue("chromePath"));
        WebDriver driver = new ChromeDriver();

        return driver;
    }

}
