@onetwoteam
Feature: Log In

  Scenario: basic auth - Login pass
    Given I am on the page "https://chewie.one2team.com/"
    When I enter "userName" "etudiant3"
    When I enter "passWord" "Etudiant3*"
    When I enter "domainName" "telco"
    And click on button Connexion
    Then login is successful

  Scenario Template: <basic auth - Login fails>
    Given I am on the page "https://chewie.one2team.com/"
    When I enter "userName" "<userName>"
    And I enter "passWord" "<passWord>"
    And I enter "domainName" "<domainName>"
    And click on button Connexion
    Then Error message displayed

    Examples:
      | userName  | passWord   | domainName |
      | aaaa      | Etudiant3* | telco      |
      | etudiant3 | az         | telco      |
      | etudiant3 | Etudiant3* | telc       |

