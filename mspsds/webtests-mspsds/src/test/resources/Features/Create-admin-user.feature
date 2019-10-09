
Feature: Add team admin users in keycloack
  

@new-group

Scenario Outline: Add new groups and teams in kc
   Given I login as keycloack Admin user
   When I go to groups
   And I click new
   Then I should be able to create new group "<group-name>"
   And I should be abel to create new team "<group-name>"
   And I add group email box "<email-box>"
   Examples:
   |group-name		|email-box						|
   |test-new-group1|team-mailbox@test.com|
   |test-new-group2||
   |test-new-group3||




  @new-user
  Scenario Outline: Add team admin user in KC
    Given I login as keycloack Admin user
    When I go to users
    And I click add user
    And I enter username "<user-name>"
    And I click save
    Then I should be able to add to "<group-name>"
    And I select role as team_admin
    And I should be able to invite user
    Examples:
    |user-name				  |group-name										|
    |testuser43@test.com|Lincolnshire County Council	|
    |testuser44@test.com|Southampton Council					|