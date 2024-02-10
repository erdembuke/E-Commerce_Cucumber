Feature: Login Feature

  @n11
  Scenario: Erdem logins to the Website for purchasing items (Negative)
    Given Erdem navigates to the website
    And Erdem clicks to the sign in button and sees the login page
    When Erdem fills the inputs with invalid credentials and clicks login
    Then Erdem should see the error message

  @n11
  Scenario: Erdem logins to the Website for purchasing items
    Given Erdem navigates to the website
    And Erdem clicks to the sign in button and sees the login page
    When Erdem fills the inputs with valid credentials and clicks login
    Then Erdem should login successfully