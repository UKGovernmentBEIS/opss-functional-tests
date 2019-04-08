Feature: MSPSDS-1046 See other team members

@regression
Scenario: Verify user team is displayed
Given I login as OPSS user
|nasirkhan.beis@gmail.com|Nasir@123|
When I am on dashboard
Then I should see my team name "OPSS Processing" displayed

@regression
Scenario: Verify team
When I click team "OPSS Processing"
Then I should see team page "OPSS Processing"
And I should see team member "nasirkhan.beis@gmail.com"
