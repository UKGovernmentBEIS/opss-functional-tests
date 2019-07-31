Feature: Opss user
	As an opss user
	In order to create a case
	I should have expected permissions
	

@regression @smoke
Scenario: Login as opss user
Given I login as OPSS user
Then I should see "Cases" tab
And I should see "Businesses" tab
And I should see "Products" tab


@regression
Scenario: Verify each header displays correct respective information
Given I login as OPSS user
When I click on "Businesses" tab
Then I should see "Businesses" list page
When I click on "Products" tab
Then I should see "Products" list page


Scenario: As OPSSuser, I should be able to create a case
Given I login as OPSS user
When I click button "Create new"
And I select case type "Product safety allegation"
And I select reporter as "Local authority (Trading Standards)"
And I enter contact details
And I enter allegation details
Then I should see "Allegation was successfully created"

@regression
Scenario Outline: As OPSSuser, I should be able to create a case
Given I login as OPSS user
When I click button "Create new"
And I select case type "Product safety allegation"
And I select reporter as "Local authority (Trading Standards)"
And I enter contact details
And I enter allegation details for product category "<Prod_cat>"
And I enter hazard type as "<Hazard-type>"
Then I should see "Allegation was successfully created"

Examples:
|Prod_cat								 |Hazard-type					|
|Fancy Dress						 |Penetrating force		|
|Furniture and furnishings|Asphyxiation					|


