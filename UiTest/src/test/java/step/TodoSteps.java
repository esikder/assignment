package step;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import page.TodoPage;

public class TodoSteps {
    TodoPage todoPage =  new TodoPage(BrowserBeanFactory.driver);


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
