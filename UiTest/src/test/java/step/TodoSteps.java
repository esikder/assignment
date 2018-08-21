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
    public void iSeeBeingAddedInTheToDoList(String name) throws Throwable {
       todoPage.verifyListItem(name);
    }

    @Given("^I am on ToDo list page$")
    public void iAmOnToDoListPage()  {
        todoPage.goToUrl("http://localhost:4000/");
    }





    @When("^I delete \"([^\"]*)\"$")
    public void iDelete(String name) throws Throwable {
        todoPage.deleteItem(name);
    }

    @Then("^I should not see \"([^\"]*)\" in the ToDo list$")
    public void iShouldNotSeeInTheToDoList(String name) throws Throwable {
       todoPage.waitUntilElementIsNotDelete(name);
    }

    @When("^I select an item$")
    public void iCheckAndItem() throws Throwable {
       todoPage.selectItem();
    }

    @Then("^the item should be completed$")
    public void theItemShouldBeCompleted() throws Throwable {
        todoPage.verifyTaskStatusIsCompleted();
    }
}
