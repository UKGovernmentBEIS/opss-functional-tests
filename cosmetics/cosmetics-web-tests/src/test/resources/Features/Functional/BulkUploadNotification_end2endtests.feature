Feature: Bulkupload end to end tests(Pre-brexit
As a business user
In order to notifiy a product 
I should be able to upload cpnp extract zip file


#Scenario: Singe Item notification no formulation document
#Given I login as responsible person user
#And I dismiss any existing errors from error tab
#And I click on "Add cosmetic products"
#And I click "Yes"
#And I click "Yes"
#When I upload "SingleItem-Nano-Only-15754954500940363.zip"
#Then I should not see any error in error tab
#And I should see notification in incomplete tab

#Scenario: Single-item notification upload with exact formulation
#Given I login as responsible person user
#And I dismiss any existing errors from error tab
#And I click on "Add cosmetic products"
#And I click "Yes"
#And I click "Yes"
#When I upload ""
#Then I should not see any error in error tab
#And I should see notification in incomplete tab


@regression @bulk-upload
Scenario: Single-item notification upload with range formulation
Given I login as responsible person user
And I dismiss any existing errors from error tab
And I click add comsetics product
And I click "Yes"
And I click "Yes"
When I upload "SingleItem-RangeFormulation-harmful-Ingredients.zip"
Then I should not see any error in error tab
And I should see notification in incomplete tab

@regression @bulk-upload
Scenario: Single-item notificaiton upload with nano and cmr only
Given I login as responsible person user
And I dismiss any existing errors from error tab
And I click add comsetics product
And I click "Yes"
And I click "Yes"
When I upload "SingleItem-CMRs-Nano.zip"
Then I should not see any error in error tab
And I should see notification in incomplete tab

@regression @bulk-upload
Scenario: Single-item notification upload with nano-material only
Given I login as responsible person user
And I dismiss any existing errors from error tab
And I click add comsetics product
And I click "Yes"
And I click "Yes"
When I upload "SingleItem-Nano-Only.zip"
Then I should not see any error in error tab
And I should see notification in incomplete tab

@regression @bulk-upload
Scenario: Verify single item notification upload with exact concentration formulation and nano-materials
Given I login as responsible person user
And I dismiss any existing errors from error tab
And I click add comsetics product
And I click "Yes"
And I click "Yes"
When I upload "SingleItem-Nano-ExactFormulation-pHRange.zip"
Then I should not see any error in error tab
And I should see notification in incomplete tab

@regression @bulk-upload
Scenario: Verify single item file upload with range formulation and nano-materials
Given I login as responsible person user
And I dismiss any existing errors from error tab
And I click add comsetics product
And I click "Yes"
And I click "Yes"
When I upload "SingleItem-Rangeformulation-Nanomaterial.zip"
Then I should not see any error in error tab
And I should see notification in incomplete tab


Scenario: confirm and notify bulk upload flow-nano-only
When I click in-complete tab
And I click select notification "SingleItem-Rangeformulation-Nanomaterial"

Given I login as responsible person user
And I dismiss any existing errors from error tab
And I click add comsetics product
And I click "Yes"
And I click "Yes"
When I upload "SingleItem-Rangeformulation-Nanomaterial.zip"
Then I should not see any error in error tab
And I should see notification in incomplete tab


@regression @bulk-upload
Scenario: Verify multi item file upload with frameformulation and nano-materials
Given I login as responsible person user
And I dismiss any existing errors from error tab
And I click add comsetics product
And I click "Yes"
And I click "Yes"
When I upload "Multi-componentFrameformulationNano-notification.zip"
Then I should not see any error in error tab
And I should see notification in incomplete tab


@regression @bulk-upload
Scenario: Single multi-item upload with nano-materials only
Given I login as responsible person user
And I dismiss any existing errors from error tab
And I click add comsetics product
And I click "Yes"
And I click "Yes"
When I upload "Multi-Item-NanoOnly.zip"
Then I should not see any error in error tab
And I should see notification in incomplete tab

#Scenario: Singe item notification upload with nano and formulation document
#Given I login as responsible person user
#And I dismiss any existing errors from error tab
#And I click on "Add cosmetic products"
#And I click "Yes"
#And I click "Yes"
#When I upload "<file>"
#Then I should not see any error in error tab
#And I should see notification in incomplete tab
 