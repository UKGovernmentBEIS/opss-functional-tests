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

@manual
Scenario Outline: notify product manually
Given I login as responsible person user
And I click on "Your cosmetic products"
When I click on "Add cosmetic products"
And I select to manual journey
And I enter product name"<product-name>"
And I select imported into UK "Yes"
And I enter country imported from"<country>"
And I select sold as single component "Yes"
And I select cosmetic sold as more than one shade "No"
And I click on continue
And I select nanomaterials as "No"
And I select product category"<prod-category>"
And I select formulation"<type>"
And I select frame formulation"<frame-formulation>"
And I select image to upload
Then I should successfully land on checkyour answers page
And I should see product name"<product-name>"
And I shoud see UKcosmetic product number generated

Examples:
|product-name		|country|prod-category													|type												 |frame-formulation						|
|AutoTestProduct|China	|Skin care products - Hand care products|Predefined frame formulation|Skin Care Cream, Lotion, Gel|
|AutoTestProduct|Vietnam|Skin care products - Hand care products|Predefined frame formulation|Skin Care Cream, Lotion, Gel|

@regression
Scenario: Validate bulk upload journey screens
Given I login as responsible person user
And I click on "Your cosmetic products"
When I click on "Add cosmetic products"
Then I should see "Have the cosmetic products been notified in the EU?"

When I click "Yes, they are already notified in the EU"
Then I should see "Do you have the files from your EU notification"

When I click "Yes, I have ZIP files containing XML to upload"
Then I should see "Upload your EU notification files"


