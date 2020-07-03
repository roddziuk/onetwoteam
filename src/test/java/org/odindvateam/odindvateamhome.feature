@onetwoteam
Feature: Home Page

  Scenario: Photo button is clickable
    Given User is connected to the login page
    When User is on the home page
    And User clicks on the Photo button
    Then Photo options are displayed
