
Feature: Manual Journey
In order to notify product on cosmetic service
As a User
I should be able add product manually
	
@regression @manual-journey
Scenario: Validate manual journey screens
Given I login as responsible person user
When I click on "Add cosmetic products"
Then I should see "Has the EU been notified about these products using CPNP?"

When I click "No"
Then I should see "Are you likely to notify the EU about these products?"

When I click "No"
Then I should see manual journey "Are you likely to notify the EU about these products?"

 @regression @manual-journey
Scenario Outline: notify product manually
Given I login as responsible person user
When I click on "Add cosmetic products"
And I select to manual journey
And I enter product name"<product-name>"

And I should see manual journey "Internal reference"
And I enter internal reference number "Auto-manual-product-2949"

And I should see manual-journey step "Is the cosmetic product imported into the UK?"
And I select imported into UK "Yes"
And I enter country imported from"<country>"

And I should see "Is the product intended to be used on children under 3 years old?"
And I click "Yes"
And I click on continue

And I should see manual journey "Multi-item kits"
And I select sold as single component "No, this is a single product"

And I should see trigger rule question "Is the the product available in different shades?"
And I select cosmetic sold as more than one shade "No"

And I should see manual-journey step "What is the physical form of the the product?"
And I select physical form as "Loose powder"

And I should see manual-journey step "What is the the product contained in?"
And I select "A typical non-pressurised bottle, jar, sachet or other package"

And I should see manual journey "Substances known or presumed to cause cancer, mutations or are toxic for reproduction (CMRs)"
And I select "No"

And I should see manual journey "Nanomaterials"
And I select "No"

And I should see manual-journey step "What category of cosmetic product is it?"
And I select product category"<prod-category>"

And I should see manual-journey step "How do you want to give the formulation of the product?"
And I select formulation"Choose a predefined frame formulation"
And I select frame formulation"<frame-formulation>"
And I click on continue
Then I should see manual journey "Poisonous ingredients"
Examples:
|product-name		|country|prod-category													|type												 |frame-formulation						|
|AutoTestProduct|China	|Skin care products - Hand care products|Predefined frame formulation|Skin Care Cream, Lotion, Gel|


Scenario: Validate bulk upload journey screens
Given I login as responsible person user
And I click on "Your cosmetic products"
When I click on "Add cosmetic products"
Then I should see "Have the cosmetic products been notified in the EU?"

When I click "Yes, they are already notified in the EU"
Then I should see "Do you have the files from your EU notification"

When I click "Yes, I have ZIP files containing XML to upload"
Then I should see "Upload your EU notification files"


