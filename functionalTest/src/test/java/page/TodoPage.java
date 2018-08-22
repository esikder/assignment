package page;

import helper.ActionWrapper;
import helper.ConfigHandler;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TodoPage  extends PageObject {

    public TodoPage(WebDriver driver){
        super(driver);
    }

    @FindBy(id="addTaskInput")
    private WebElement addTaskInput;
    @FindBy(id="taskDetails")
    private WebElement taskDetails;
    @FindBy(id="taskDetails")
    private List<WebElement> taskDetailsList;
    @FindBy(id="deleteTask")
    private WebElement deleteButton;
    @FindBy(id="deleteTask")
    private List<WebElement> deleteButtons;
    @FindBy(id="taskSelect")
    private WebElement selectTask;

    ActionWrapper action=new ActionWrapper(driver);

    public  TodoPage goToUrl(){
        driver.get(ConfigHandler.getConfigValue("baseURI")+
                ConfigHandler.getConfigValue("port"));
        return this;
    }

    public  TodoPage addItem(String itemName){
        addTaskInput.sendKeys(itemName);
        return this;
    }
    public  TodoPage enterItem(){
        addTaskInput.sendKeys(Keys.ENTER);
        return this;
    }
    public  TodoPage verifyListItem(String name){
        action.waitUntilElementAvailable(deleteButton);
        Boolean found = false;
            for (WebElement item : taskDetailsList) {
                if (item.getAttribute("value").contains(name)){
                    found = true;
                    break;
                }
        }
        Assert.assertTrue(found);
        return this;

    }

    public TodoPage deleteItem(String name) {
        WebElement deleteSpecificItem= null;
        for (WebElement item : taskDetailsList) {
            if(item.getAttribute("value").contains(name))
                deleteSpecificItem =  item.findElement(By.xpath("following-sibling::span[@id='deleteTask']"));
        }
        deleteSpecificItem.click();
        return this;
    }

    public TodoPage waitUntilElementIsNotDelete(String name) {
        action.waitUntilElementNotAvailable(deleteButtons);
        return this;
    }

    public TodoPage selectItem() {
        action.clickWebElement(selectTask);
        return this;
    }

    public TodoPage verifyTaskStatusIsCompleted() {
        action.waitUntilElementAvailable(taskDetails);
        Assert.assertTrue(taskDetails.getAttribute("class").contains("todo__done"));
        return this;
    }

    public void editItem(String name) {
        taskDetails.clear();
        taskDetails.sendKeys(name);
        taskDetails.sendKeys(Keys.ENTER);
    }
}
