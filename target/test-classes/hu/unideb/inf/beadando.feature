
Feature: PhpTravel login process captcha not clicked

  Background:
    Given the homepage is opened
    And the sign in link is clicked

  Scenario:
    Given the Log In Button is clicked
    Then complete captcha error message is shown

  Scenario:
    Given the captcha box is clicked
    And the Log In Button is clicked
    Then invalid data message is shown
