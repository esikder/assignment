package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObject {
    public final WebDriver driver;

    public  PageObject(WebDriver driver){
        this.driver= driver;
        PageFactory.initElements(driver, this);

    }



}
