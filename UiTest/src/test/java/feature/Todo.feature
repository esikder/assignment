
Feature: ToDo List test containing following features :
  As a user I should be able to add , edit, update, delete and complete item in todo list.

  @de
  Scenario: I add item to ToDo list
    Given I am on ToDo list page
    And I enter "dd"
    When I press Enter
    Then I see "dd" being added in the ToDo list