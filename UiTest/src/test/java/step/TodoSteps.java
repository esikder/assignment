package step;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Autowired;
import page.TodoPage;

public class TodoSteps {

    @Autowired
    TodoPage todoPage;

    @Test
    public void test(){
        WebDriver driver = new FirefoxDriver();
    }

    @Given("^I navigate to \"([^\"]*)\"$")
    public void iNavigateTo(String url) throws Throwable {
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
