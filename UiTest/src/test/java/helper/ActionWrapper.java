package helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import page.PageObject;

import java.util.List;

@Component
@Controller
public class ActionWrapper extends PageObject {

    @Autowired
    public  ActionWrapper(WebDriver driver){
        super(driver);
    }
    public void clickWebElement(WebElement e)
    {
        WebDriverWait wait =  new WebDriverWait(driver,  Long.parseLong(ConfigHandler.getConfigValue("timeoutInSeconds")));
        wait.until(ExpectedConditions.elementToBeClickable(e));
        e.click();
    }
    public void waitUntilElementNotAvailable(List<WebElement> e) {
        WebDriverWait wait =  new WebDriverWait(driver,  Long.parseLong(ConfigHandler.getConfigValue("timeoutInSeconds")));
        wait.until(ExpectedConditions.invisibilityOfAllElements(e));
    }
    public void waitUntilElementAvailable(WebElement e) {
        WebDriverWait wait =  new WebDriverWait(driver,  Long.parseLong(ConfigHandler.getConfigValue("timeoutInSeconds")));
        wait.until(ExpectedConditions.visibilityOf(e));
    }

}
