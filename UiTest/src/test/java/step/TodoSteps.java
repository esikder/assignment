package step;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.TodoPage;

public class TodoSteps {
    WebDriver driver;
    TodoPage todoPage;




    @Given("^I navigate to \"([^\"]*)\"$")
    public void iNavigateTo(String url) throws Throwable {
        System.setProperty("webdriver.chrome.driver","/Users/erfanasikder/Documents/Tech/UiTest/src/test/resources/chromedriver");
        driver = new ChromeDriver();
        todoPage.goToUrl(url);
    }
    @And("^I enter \"([^\"]*)\"$")
    public void enterItemName(String name){
        todoPage.addItem(name);
    }
    @When("^I press Enter$")
    public void iPressEnter()  {
        todoPage.enterItem();
    }

    @Then("^I see \"([^\"]*)\" being added in the ToDo list$")
    public void iSeeBeingAddedInTheToDoList(String arg0) throws Throwable {

    }
}
