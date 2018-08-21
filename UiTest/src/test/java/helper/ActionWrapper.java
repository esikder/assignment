package helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.PageObject;

import java.util.List;


public class ActionWrapper extends PageObject {


    public  ActionWrapper(WebDriver driver){
        super(driver);
    }
    public void clickWebElement(WebElement e)
    {
        WebDriverWait wait =  new WebDriverWait(driver,  Long.parseLong(ConfigHandler.getConfigValue("timeoutInSeconds")));
        wait.until(ExpectedConditions.and(
                ExpectedConditions.elementToBeClickable(e),
                ExpectedConditions.visibilityOf(e)
                )
        ) ;
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
