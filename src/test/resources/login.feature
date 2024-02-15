@amazon
Feature: Login Feature

  Background:
    Given Erdem navigates to the amazon website
    When Erdem clicks to the sign in button and navigates to the amazon login page

  Scenario: User should be able to login with valid credentials
    And Erdem trying to login with valid username and password
    Then Erdem should login to the amazon site successfuly


  Scenario: User should not be login without missing email
    And Erdem trying to login without entering email
    Then Erdem should recieve the email missing error message