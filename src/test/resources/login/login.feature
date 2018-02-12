#ScenarioOutline
@All
Feature: Data tables scenario

Scenario: failed login functionality
    * We have navigated to fantasyPL
    When I enter email and I enter pass
     | nikola.chuchukov@gmail.com   | spider92       |
     | email1  | test       |
     | email2  | test       |
    Then Login should fail

@Skip
Scenario: successful login
    Given We are at relogin page
    When I enter correct email and I enter pass
     | nikola.chuchukov@gmail.com   | spider92       |
     | email1  | test       |
     | email2  | test       |
    Then Login should succeed
