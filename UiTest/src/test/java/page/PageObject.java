package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class PageObject {
    public WebDriver webDriver;


    @Autowired
    public  PageObject(WebDriver driver){
        this.webDriver= driver;
        PageFactory.initElements(driver, this);

    }

    public  WebDriver getDriver(){
        return webDriver;
    }

}
