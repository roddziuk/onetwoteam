@onetwoteam

Feature: Home Page

  Scenario Outline: Button click
    Given User is connected to the login page
    When user clicks on button "<button>" with "<css>"
    Then user is redirected to right page "<page>"
    Examples:
      | button       | css                | page             |
      | site web     | > div:nth-child(1) | one2team.com     |
      | google drive | > div:nth-child(2) | drive.google.com |
      | planning     | > div:nth-child(4) | chewie.one2team.com |

  Scenario: Logout
    Given User is connected to the login page
    When user disconnects from platform
    Then user is redirected to Login page