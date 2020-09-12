@quote
Feature: Marketing test suite

@quote1
Scenario: Required fields for quote
Given I open "quote" page
And I print page details oop
When I fill out required fields for "user" oop
And I submit the form oop
Then I verify required fields for "user" oop