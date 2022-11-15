Feature: Sconto Login
  log in the website to seethe users Area

  @validCredentials
  Scenario: succcessful Login
    Given Navigate to Home page
    When Click on Anmelden icon
    Then Login Page displayed

    When Enter the valid credentials
    And Click Anmelden button
    Then Home Page displayed

    When Click on Mein Konto icon
    Then User Name displayed

    @invalidEmail
    Scenario Outline: Login with a wrong email
      Given Navigate to Home page
      When Click on Anmelden icon
      Then Login Page displayed

      When Enter the wrong email and a valid password
      |email  |password  |
      |<email>|<password>|
      And Click Anmelden button
      Then Email Error message displayed
      Examples:
        |email               |password |
        |hiddinkGus@.com    |123456Aa!|
        |hiddinkGus@gmail.  |123456Aa!|
        |hiddinkGusgmail.com|123456Aa!|
        |hiddinkGus@gmailcom|123456Aa!|

      @emptyPassword
      Scenario: Login with a wrong email
        Given Navigate to Home page
        When Click on Anmelden icon
        Then Login Page displayed

        When Enter the valid email and empty password
        And Click Anmelden button
        Then Demands for valid password message appeared
