Feature: Dashboard

Background: Common steps for all scenarios
  Given I am on the homepage, first
  Given I'm on the dashboard, now


@dashboardPage
Scenario: Verify dashboard url
  Then I may verify the url "url"

