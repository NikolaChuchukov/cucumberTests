#ScenarioOutline
@All
Feature: Scenario Outline

Scenario Outline: failed login functionality
    Given We have navigated to PL
    When I enter Email "<email>" and I enter Password "<pass>"
    Then Login fails

 Examples:
    | email   | pass       |
    | email1  | test       |
    | email2  | test       |