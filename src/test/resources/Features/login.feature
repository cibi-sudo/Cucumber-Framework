Feature: Login functionality

  Background:User navigates to login page
    Given User able to see the the brand element

  Scenario:  Login with valid credentials
    When User enters valid username "Admin" into email field
    And User enters valid password "admin123" into password field
    And User clicks on Login button

  Scenario: Login with invalid credentials
    When User enters valid username "username" into email field
    And User enters valid password "password" into password field
    And User clicks on Login button
    Then User should get a proper warning message about credentials mismatch

  Scenario: Login with valid email and invalid password
    When User enters valid username "Admin" into email field
    And User enters valid password "password" into password field
    And User clicks on Login button
    Then User should get a proper warning message about credentials mismatch

  Scenario: Login with invalid username and valid password
    When User enters valid username "username" into email field
    And User enters valid password "admin123" into password field
    And User clicks on Login button
    Then User should get a proper warning message about credentials mismatch

  Scenario: Login without providing any credentials
    When User don't enter username into username field
    And User don't enter password into password field
    And User clicks on Login button
    Then User should get a proper warning message about credentials required