package step;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import page.TodoPage;

public class TodoSteps {
    TodoPage todoPage =  new TodoPage(BrowserBeanFactory.driver);


    @And("^I enter an item to the list \"([^\"]*)\"$")
    public void enterItemName(String name){
        todoPage.addItem(name);
    }
    @When("^I press Enter$")
    public void iPressEnter()  {
        todoPage.enterItem();
    }


    @Given("^I am on ToDo list page$")
    public void iAmOnToDoListPage()  {
        todoPage.goToUrl();
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


    @Then("^I see \"([^\"]*)\" is available in the ToDo List$")
    public void iSeeIsAvailableInTheToDoList(String name) throws Throwable {
        todoPage.verifyListItem(name);
    }

    @When("^I edit item name to \"([^\"]*)\"$")
    public void iEditItemNameTo(String name) throws Throwable {
       todoPage.editItem(name);
    }
}