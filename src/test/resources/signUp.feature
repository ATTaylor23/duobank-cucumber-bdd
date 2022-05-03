Feature: Sign up

Background: Common steps for all scenarios
  Given I am on the homepage

  @signUpPage @url
Scenario: Verify Sign Up page
  When I click on the Sign Up link
  Then The url should be "correct"

  @signUpPage @signUp @testing
Scenario: Verify all input dialogue boxes are available
  When I click on the Sign Up link
  Then I should see the expected List of Strings
    | FIRST NAME    |
    | LAST NAME     |
    | Email address |
    | PASSWORD      |

  @signUpPage @signUp
Scenario: Verify positive sign up without sign in
  When I click on the Sign Up link
  Then I enter each required text
  And I click Sign Up
  Then The new url should be "correct"

  @signUpPage @signUp @signIn
Scenario: Verify positive sign up with sign in
  When I click to sign up
  Then I enter faker generated text
  And I click the Sign Up button
  When The new page appears
  Then I enter the saved faker text
  And I click the Login button
  Then I should see my "full name" on the page

  @signUpPage @url @signIn @failTest
Scenario: Verify negative login with blank input
  When I click the Login button
  Then The "url" should remain the same

  @signUpPage @url @signIn @failTest
Scenario: Verify negative login with generic email and no password
  When I enter a generic "email"
  And Leave the password blank
  Then I click the Login button
  Then The "url" should remain the same

  @signUpPage @signIn @failTest
Scenario: Verify login fail with generic email & generic password
  When I enter a generic "email"
  And I enter an incorrect password
  Then I click the Login button
  Then I should see that it failed

  @signUpPage @url @signIn @failTest
Scenario: Verify negative login without email & random password
  When I do not enter an email
  But I do enter a random "password"
  Then I click the Login button
  Then The "url" should remain the same

  @signUpPage @url
Scenario: Verify page changes through Sign up link
  When I click on the Sign Up link
  Then I see the page change
  When I click on the Sign up link again
  Then I see the page change back to the original

  @signUpPage @text
Scenario: Verify "Welcome Back, Automation Testers!" text
  When I find an element
  Then I should see its text "text"

  @signUpPage @text
Scenario: Verify "Login with email" text
  When I find an element
  Then I should see its text "text"

  @signUpPage@text
Scenario: Verify "Email address" text
  When I find an element
  Then I should see its text "text"

  @signUpPage @text
Scenario: Verify "Password" text
  When I find an element
  Then I should see its text "text"

  @signUpPage @text
Scenario: Verify "Don't have an account?" text
  When I find an element
  Then I should see its text "text"



