Feature: Dashboard

Background: Common steps for all scenarios
  Given I am on the homepage, first
  Given I'm on the dashboard, now


  @db
  Scenario: Verify dashboard url
    Then I may verify the url "url"

  @db
  Scenario: Verify deletion through database
    Then I sign out completely
    Given I'm signed out
    Then I enter new random user info
    When This happens I should be able to sign in through UI using the new user info
    Then I may delete this new user info through the database
    And verify this deletion by failing to sign in with the same information

  @db
  Scenario: Verify sign up through database
    Then I sign out completely
    Given I'm signed out
    Then I enter new user info through the database
    When This happens I should be able to verify by attempting to sign in through the UI

  @db
  Scenario: Verify entry through UI
    Then I fill out the entire application
    When This happens the borrower's name should be present

  @db
  Scenario Outline: Verify PREAPPROVAL DETAILS page through Scenario Outline
    Then I fill out the required fields using the following credentials
      | Realtor Information | Estimated Purchase Price | Down Payment Amount |
      | <RI>                | <EPP>                    | <DPA>               |
    When This happens I should be able to verify through the credentials presence
    And See the correct math through the Loan Amount remaining total

    Examples:
      | RI                 | EPP    | DPA    |
      | Jakie Yerbury      | 525000 | 26250  |
      | Gunter Bucktharp   | 900000 | 207000 |
      | Barbara-anne Alton | 210000 | 31500  |
      | Guss Waterdrinker  | 230000 | 207000 |
      | Lance Weald        | 75     | 20     |








