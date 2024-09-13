Feature: Automate login and product selection on Automation Exercise

  Scenario: Login with valid credentials and print product details
    Given User is on login page
    When User logs in with valid credentials "gadgeshwetal@gmail.com" and "Sweety12@"
    Then User clicks on the product section
    And User selects all products and prints their names and prices

  Scenario: Login with invalid credentials
    Given User is on login page
    When User logs in with invalid credentials "invaliduser@gmail.com" and "InvalidPassword"
    Then User should see login error and take screenshot
    And Extent report is generated with details
