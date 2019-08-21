Feature: New Direct Partnership For PA To Approve




Scenario: Create a new direct partnership
   Given I login as "par_authority@example.com"
   Then I should be able to see "See your partnerships"



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
	
	
	
	
	
    @directpartneship
    Scenario: New Direct Partnership

        # CHECK FEEDBACK LINK
        Then the element "#block-sitewidehelpdeskmessage" contains the text "If you need assistance please call 0121 345 1201 or email pa@beis.gov.uk"

        # PARTNERSHIP APPLY

        When I complete valid direct partnership application details

        # ADD ORGANISATION DETAIL

        When I complete valid organisation details for direct partnership "Organisation For Direct Partnership"

        # REVIEW THE APPLICATION

        And I complete review and submit valid direct partnership application

        # INVITATIONS

        Then the direct partnership creation email template is correct

    @coordinatedpartnership
    Scenario: New coordinated Partnership

        # PARTNERSHIP APPLY

        When I complete valid coordinated partnership application details

        # ADD ORGANISATION DETAIL

        When I complete valid organisation details for coordinated partnership "Organisation For Coordinated Partnership"
        
        # REVIEW THE APPLICATION
        
        And I complete review and submit valid direct partnership application
        
        # INVITATION
        
        Then the coordinated partnership creation email template is correct
    
        @coordinatedpartnership
    Scenario: New coordinated Partnership

        # PARTNERSHIP APPLY

        When I complete valid coordinated partnership application details

        # ADD ORGANISATION DETAIL

        When I complete valid organisation details for coordinated partnership "Organisation For No Members Coordinated Partnership"
        
        # REVIEW THE APPLICATION
        
        And I complete review and submit valid coordinated partnership application
        
        # INVITATION
        
        Then the coordinated partnership creation email template is correct
