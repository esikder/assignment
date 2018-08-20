package step;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class BrowserBeanFactory {


   public static WebDriver driver;

    @Before
    public  WebDriver getDriver() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","/Users/erfanasikder/Documents/Tech/UiTest/src/test/resources/chromedriver");
        driver = new ChromeDriver();

        return driver;
    }

    @After
    public  void closeDown(){
        driver.quit();
    }


}
