Feature: Login Feature

  Scenario: User should not be login without missing email
    Given Erdem navigates to the amazon website
    When Erdem clicks to the sign in button and navigates to the login page
    And Erdem trying to login without entering email
    Then Erdem should recieve the email missing error message