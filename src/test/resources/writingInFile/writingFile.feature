#NoWebTest
@All
Feature: Creating and Writing in file

Scenario: Creating test file
    Given I have created a test file
    When I write a text in it
    Then The file should be saved