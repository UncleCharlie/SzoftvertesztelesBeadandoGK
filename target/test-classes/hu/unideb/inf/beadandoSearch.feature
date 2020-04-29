
Feature: automation practice search process

  Background:
    Given the homepage is opened

  Scenario Outline:
    Given the search field is populated with '<value>'
    And the search button is clicked
    Then items are found
    Examples:
      | value |
      | dress |
      | hat |
      | t-shirt |
