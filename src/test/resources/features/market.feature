@market
Feature: Marketing test suite

  @market1
  Scenario: Navigation for quote
    Given I go to "google" page
    When I print page details
    And I go to "quote" page
    And I print page details
    And I go to "bing" page
    And I print logs to the console
    And I go back and forward, then refresh
    And I change resolution to "phone"
    And I change resolution to "desktop"


  @market2
  Scenario: Required and optional fields for quote
    Given I go to "quote" page
    When I print page details
    Then I verify email field behavior
    When I fill out required fields
    And I fill out optional fields
    And I submit the form
    Then I verify required fields
    And I verify optional fields

  @market3
  Scenario: Alert, iFrame and Window
    Given I go to "quote" page
    And I "dismiss" third party agreement
    And I wait for 1 sec
    And I fill out "Richard Roe" name and "0123456789" phone contact
    And I wait for 1 sec
    And I verify document list contains "Document 2"
    And I fill out required fields


