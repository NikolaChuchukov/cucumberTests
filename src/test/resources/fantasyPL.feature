#setup
@Skip
Feature: Open fantasy premier league home page

Background:
    Given We have opened the browser

Scenario: Check if home page is successfully opened
    When We try to access home page
    Then The home page is successfully opened