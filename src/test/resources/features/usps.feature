@usps
Feature: USPS scenarios

  Background:
    Given I go to "usps" page

  @usps1
  Scenario: Validate ZIP code for Portnov Computer School
    When I go to Lookup ZIP page by address
    And I fill out "4970 El Camino Real" street, "Los Altos" city, "CA" state
    Then I validate "94022" zip code exists in the result

  @usps2
  Scenario: Calculate price
    When I go to Calculate Price Page
    And I select "Canada" with "Postcard" shape
    And I define "2" quantity
    Then I calculate the price and validate cost is "$2.40"

  @usps3
  Scenario: Verify location
    When I perform "Free Boxes" search
    And I set "Mail & Ship" in filters
    Then I verify that "7" results found
    When I select "Priority Mail | USPS" in results
    And I click "Ship Now" button
    Then I validate that Sign In is required

  @usps4
  Scenario: Quadcopters delivery
    When I go to "Help" tab
    And I perform "Quadcopters delivery" help search
    Then I verify that no results of "Quadcopters delivery" available in help search

  @usps5
  Scenario: Phone number of the nearest Mail Pickup
    When I navigate to Find a Location page
    And I filter by "Post Offices" location types, "Pickup Services" services, "Accountable Mail" available services
    And I provide data as "4970 El Camino Real 110" street, "Los Altos" city, "CA" state
    Then I verify phone number is "800-275-8777"

  @usps6
  Scenario: Every door direct mail
    When I go to "Every Door Direct Mail" under "Business"
    And I search for "4970 El Camino Real, Los Altos, CA 94022"
    And I click "Show Table" on the map
    When I click "Select All" on the table
    And I close modal window
    Then I verify that summary of all rows of Cost column is equal Approximate Cost in Order Summary

  @usps7
  Scenario Outline: Validate ZIP code
    When I go to Lookup ZIP page by address
    And I fill out "<street>" street, "<city>" city, "<state>" state
    Then I validate "<zip>" zip code exists in the result
    Examples:
      | street              | city      | state | zip   |
      | 4970 El Camino Real | Los Altos | CA    | 94022 |
      | 11 Wall st          | New York  | NY    | 10005 |
      | 111 S Michigan Ave  | Chicago   | IL    | 60603 |