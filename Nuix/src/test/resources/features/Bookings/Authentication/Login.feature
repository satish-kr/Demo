@auth
Feature: L_001 Authenticate user with email, Facebook, and Apple login

  Scenario: Login using email
    Given I am on the Bookings Sign in Page
    Then I input email address test@gmail.com and click on continue with email
    And I input password test123 and click on continue button
    Then I should be successfully logged in

