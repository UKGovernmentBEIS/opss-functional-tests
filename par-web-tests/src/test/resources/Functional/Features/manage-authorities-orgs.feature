
Feature: Manage authorities and organisations
As a helpdek user 
In order update authories or organisations details
I should be able to manage authorities and organisations
 
@regression
Scenario: Verify only help desk user can see manage organisations
Given I login as "par_helpdesk@example.com"
When I click on dashboard link "par_helpdesk@example.com"
Then I should see "Manage authorities" link
And I should see "Manage organisations" link

@regression 
Scenario: Verify authority user should not be able to see manage authorities
Given I login as "par_authority@example.com"
When I click on dashboard link "par_authority@exmaple.com"
Then I should not see "Manage authorities" link

@regression
Scenario: Verify org user should not be able to see manage organisation
Given I login as "par_business@example.com"
When I click on dashboard link "par_authority@exmaple.com"
Then I should not see "Manage authorities" link

@authority @regression
Scenario: Verify list of authorities displayed for helpdesk user
Given I login as "par_helpdesk@example.com"
When I click on dashboard link "par_helpdesk@example.com"
And I click on "Manage authorities"
Then I should see "Authorities Dashboard"
And I should see "Manage authority" against each authority


@authority @regression
Scenario: Verify list of organisation displayed for helpdesk user
Given I login as "par_helpdesk@example.com"
When I click on dashboard link "par_helpdesk@example.com"
And I click on "Manage organisations"
Then I should see "Organisation Dashboard"
And I should see "Manage organisation" against each organisation


Scenario: Verify only help desk user can see manage authorities

Scenario: Verify when help desk user click on manage authorities then It should display list of authorities 

Verify pagination the list page works fine as expected.

Verify when help desk user click on manage organisations then it should display list of organisations

Verify pagination works as expected on organisation list page.