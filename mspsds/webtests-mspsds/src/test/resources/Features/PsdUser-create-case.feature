Feature: PSD user
	As an psd user
	In order to create a case
	I should have expected permissions
	
@regression @ts-user
Scenario: As Trading standard user, I should be able to create a case
Given I login as Trading standard user
When I click button "Open a new case"
And I enter product details for product category "Clothing, textiles and fashion items"
And I click continue
Then I should see page "Why are you reporting this product?"

When I select compliance type "unsafe"
And I click continue
Then I should see page "Supply chain information"

#Enter supply chain information
When I select which parts of chain do you know as "Retailer"
And I click continue
Then I should see page "Retailer details"

#Enter Retailer business details
When I enter business tradign name "Test Tesco"
And I enter legal name "Auto-test"
And I click continue
Then I should see page "Has any corrective action been agreed or taken?"

#Enter corrective action no
When I select corrective action "No"
And I click continue
Then I should see page "Other information and files"

When I click continue
Then I should see page "Add your own reference number"

When I click "No"
And I click create case
Then I should see page "Case created"

@ts-user @regression
Scenario: Add comment activity
Given I login as Trading standard user
And I open case "Auto-test Testproduct, Auto-test dishwasher – Chemical"
When I go to activity log
Then I should be able to add activity "Comment"




Scenario: Add email via activity
Scenario: Add test results via activity







