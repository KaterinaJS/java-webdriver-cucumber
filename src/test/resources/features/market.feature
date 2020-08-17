@market
Feature: Marketing test suite

  @market1
  Scenario: Navigation for quote
    Given I go to "google" page
    When I print page details
    And I go to "quote" page
    And I print page details
    And I go back and forward, then refresh
    And I change resolution to "phone"
    And I change resolution to "desktop"


  @market2
  Scenario: Required fields for quote
    Given I go to "quote" page
    When I print page details
    Then I verify email field behavior
    When I fill out required fields
    And I submit the form
    Then I verify required fields
