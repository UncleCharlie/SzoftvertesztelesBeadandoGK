
Feature: automation practice login process

  Background:
    Given the homepage is opened
    And the sign in link is clicked

  Scenario:
    Given the Log In Button is clicked
    Then missing email message is shown
