Feature: Test Login Functionality

  Scenario: Check login is successful with valid credentials
    Given browser is open
    When user is on login page
    Then users enters username and password
    Then user is navigated to the home page

  Scenario Outline: Check login is successful with dynamic credentials
    Given browser is open
    When user is on login page
    Then users enters "<username>" and "<password>"
    Then user is navigated to the home page

    Examples:

      | username | password       |
      | test123  | Automation@123 |
      | test     | Automation@123 |