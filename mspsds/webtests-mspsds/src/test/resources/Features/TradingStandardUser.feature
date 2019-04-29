Feature: Trading Standard user
	As a trading standard user
	In order to create a case
	I should have expected permissions
	

@regression
Scenario: Login as a trading standard user
Given I login as Trading standard user
|nasiralikhan1982@gmail.com|Nasir@123|
Then I should see "Cases" tab
And I should see "Businesses" tab
And I should see "Products" tab
And I should see "Home" tab





