package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TodoPage  extends PageObject {



    public TodoPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="addTaskInput")
    private WebElement addTaskInput;
    @FindBy(id="taskDetails")
    private WebElement taskDetails;

    public  TodoPage goToUrl(String url){

        driver.get(url);
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
        assert(taskDetails.getText().contains(name));
        return this;
    }
}
