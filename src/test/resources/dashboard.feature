@test
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

#  @dbTest
#  Scenario: Verify tbl_mortagage columns
#    When I send a query to retrieve column names for tbl_mortagage table
#    Then The column names should be the following
#      | id                            |
#      | realtor_status                |
#      | realtor_info                  |
#      | loan_officer_status           |
#      | purpose_loan                  |
#      | est_purchase_price            |
#      | down_payment                  |
#      | down_payment_percent          |
#      | total_loan_amount             |
#      | src_down_payment              |
#      | add_fund_available            |
#      | apply_co_borrower             |
#      | b_firstName                   |
#      | b_middleName                  |
#      | b_lastName                    |
#      | b_suffix                      |
#      | b_email                       |
#      | b_dob                         |
#      | b_ssn                         |
#      | b_marital                     |
#      | b_cell                        |
#      | b_home                        |
#      | c_firstName                   |
#      | c_middleName                  |
#      | c_lastName                    |
#      | c_suffix                      |
#      | c_email                       |
#      | c_dob                         |
#      | c_ssn                         |
#      | c_marital                     |
#      | c_cell                        |
#      | c_home                        |
#      | rent_own_status               |
#      | monthly_rental_payment        |
#      | first_mortagage_total_payment |
#      | employer_name                 |
#      | position                      |
#      | city                          |
#      | state                         |
#      | start_date                    |
#      | end_date                      |
#      | current_job                   |
#      | co_employer_name              |
#      | co_position                   |
#      | co_city                       |
#      | co_state                      |
#      | co_start_date                 |
#      | co_end_date                   |
#      | co_current_job                |
#      | gross_monthly_income          |
#      | monthly_over_time             |
#      | monthly_bonuses               |
#      | monthly_commission            |
#      | monthly_dividents             |
#      | co_gross_monthly_income       |
#      | co_monthly_over_time          |
#      | co_monthly_bonuses            |
#      | co_monthly_commission         |
#      | co_monthly_dividents          |
#      | add_belong                    |
#      | income_source                 |
#      | amount                        |
#      | eConsent_declarer             |
#      | eConsent_declarer_FirstName   |
#      | eConsent_declarer_LastName    |
#      | eConsent_declarer_Email       |
#      | created_on                    |
#      | modified_on                   |
#      | loan_status                   |
#      | user_id                       |
#      | active                        |










