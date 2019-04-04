#Sample Feature Definition Template

Feature: Add product manually
	
@regression
Scenario: Validate manual journey screens
Given I login user as
|nasiralikhan1982@gmail.com|Test@123|
And I click on "Your cosmetic products"
When I click on "Add cosmetic products"
Then I should see "Have the cosmetic products been notified in the EU?"

When I click "No, they have not been notified in the EU"
Then I should see "Will these cosmetic products be notified in the EU?"

When I click "No"
Then I should see "Cosmetic product name"

@regression
Scenario: Validate bulk upload journey screens
Given I login user as
|nasiralikhan1982@gmail.com|Test@123|
And I click on "Your cosmetic products"
When I click on "Add cosmetic products"
Then I should see "Have the cosmetic products been notified in the EU?"

When I click "Yes, they are already notified in the EU"
Then I should see "Do you have the files from your EU notification"

When I click "Yes, I have ZIP files containing XML to upload"
Then I should see "Upload your EU notification files"
