package step;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import helper.BrowserLibrary;
import org.openqa.selenium.WebDriver;


public class BrowserBeanFactory {


   public static WebDriver driver;

    @Before
    public  WebDriver getDriver() {
        BrowserLibrary b= new BrowserLibrary();
        driver = b.getbrowser();
        return driver;
    }

    @After
    public  void closeDown(){
        driver.quit();
    }


}
