Feature: New Direct Partnership For PA To Approve



@nasir
Scenario: Create a new direct partnership
   Given I login as "par_authority@example.com"
   Then I should be able to see "See your partnerships"


@nasir
Scenario: New direct Partnership
	Given I login as "par_authority@example.com"
	When I click on "Apply for a new partnership"
	And I select authority "City Enforcement Squad"
	And I click continue
	And I select partnership type "Direct"
	And I fill in partnership details
	Then I should see partnership creation confirmation "Check partnership information "
	
  When I accept terms and conditions 
  And I click on save
  Then I should see "Invite the business " page
  And I see invite email with the text "A partnership application has been started"
  

  When I click send invite
  Then I should see "Partnership application completed"
	
@nasir
Scenario: New Co-ordinated Partnership
	Given I login as "par_authority@example.com"
	When I click on "Apply for a new partnership"
	And I select authority "Upper West Side Borough Council"
	And I click continue
	And I select partnership type "Co-ordinated"
	And I fill in partnership details
	Then I should see partnership creation confirmation "Check partnership information "
	
  When I accept terms and conditions 
  And I click on save
  Then I should see "Invite the business " page
  And I see invite email with the text "A partnership application has been started"
  

  When I click send invite
  Then I should see "Partnership application completed"
	
@wip
Scenario: Verify notification is sent out when partnership is created
Scenario: Verify authority user can confirm org details

