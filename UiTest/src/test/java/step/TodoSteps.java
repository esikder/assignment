package step;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import page.TodoPage;

public class TodoSteps {
    TodoPage todoPage =  new TodoPage(BrowserBeanFactory.driver);


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

    @Given("^I am on ToDo list page$")
    public void iAmOnToDoListPage()  {
        todoPage.goToUrl("http://localhost:4000/");
    }
}
