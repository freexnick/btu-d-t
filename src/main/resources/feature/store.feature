Feature: Test add book in collection functionality

  Scenario: Adding book in collection
    Given chrome browser is open
    When user is on log in page
    And user enters credentials
    When user goes to book store
    When user clicks on Git Pocket Guide button
    When user clicks on Add to your collection

