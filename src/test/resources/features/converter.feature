@converter
Feature: Converter functions

  Background:
    Given I go to "converter" page

  @converter1
  Scenario: Validate Fahrenheit to Celsius
    When I click on "Temperature"
    And I set "Fahrenheit" to "Celsius"
    Then I enter into From field "54" and verify "12.2" result

  @converter2
  Scenario: Validate Pound to Kilogram
    When I click on "Weight"
    And I set "Pound" to "Kilogram"
    Then I enter into From field "170" and verify "77" result

  @converter3
  Scenario: Validate Mile to Kilometer
    When I click on "Length"
    And I set "Mile" to "Kilometer"
    Then I enter into From field "50" and verify "80.4" result

  @converter4
  Scenario Outline: Validate converting
    When I click on "<option>"
    And I set "<convertFrom>" to "<convertTo>"
    Then I enter into From field "<inputValue>" and verify "<outputValue>" result
    Examples:
      | option      | convertFrom | convertTo | inputValue | outputValue |
      | Temperature | Fahrenheit  | Celsius   | 54         | 12.2        |
      | Weight      | Pound       | Kilogram  | 170        | 77          |
      | Length      | Mile        | Kilometer | 50         | 80.4        |
