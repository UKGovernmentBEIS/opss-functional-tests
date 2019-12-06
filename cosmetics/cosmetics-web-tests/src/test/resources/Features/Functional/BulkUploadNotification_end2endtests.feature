Feature: Bulkupload end to end tests(Pre-brexit
@end2endtest
Scenario: Single-item notification upload with no formulation document
Given I login as responsible person user
And I dismiss any existing errors from error tab
And I click on "Add cosmetic products"
And I click "Yes"
And I click "Yes"
When I upload "SingleItem-Nano-Only-15754954500940363.zip"
Then I should not see any error in error tab
And I should see notification in incomplete tab


Scenario: Singe Item notification no formulation document
Given I login as responsible person user
And I dismiss any existing errors from error tab
And I click on "Add cosmetic products"
And I click "Yes"
And I click "Yes"
When I upload "tSingleItem-Nano-Only-15754954500940363.zip"
Then I should not see any error in error tab
And I should see notification in incomplete tab

Scenario: Single-item notification upload with exact formulation
Given I login as responsible person user
And I dismiss any existing errors from error tab
And I click on "Add cosmetic products"
And I click "Yes"
And I click "Yes"
When I upload "tSingleItem-Nano-Only-15754954500940363.zip"
Then I should not see any error in error tab
And I should see notification in incomplete tab

Scenario: Single-item notification upload with range formulation
Given I login as responsible person user
And I dismiss any existing errors from error tab
And I click on "Add cosmetic products"
And I click "Yes"
And I click "Yes"
When I upload "tSingleItem-Nano-Only-15754954500940363.zip"
Then I should not see any error in error tab
And I should see notification in incomplete tab


Scenario: Single-item notificaiton upload with cmr only
Given I login as responsible person user
And I dismiss any existing errors from error tab
And I click on "Add cosmetic products"
And I click "Yes"
And I click "Yes"
When I upload "tSingleItem-Nano-Only-15754954500940363.zip"
Then I should not see any error in error tab
And I should see notification in incomplete tab

Scenario: Single-item notification upload with nano-material only
Given I login as responsible person user
And I dismiss any existing errors from error tab
And I click on "Add cosmetic products"
And I click "Yes"
And I click "Yes"
When I upload "tSingleItem-Nano-Only-15754954500940363.zip"
Then I should not see any error in error tab
And I should see notification in incomplete tab

Scenario: Single-item notification upload with cmr and nano-material
Given I login as responsible person user
And I dismiss any existing errors from error tab
And I click on "Add cosmetic products"
And I click "Yes"
And I click "Yes"
When I upload "tSingleItem-Nano-Only-15754954500940363.zip"
Then I should not see any error in error tab
And I should see notification in incomplete tab

Scenario: Verify single item file upload with frame formulation  and nano-materials
Given I login as responsible person user
And I dismiss any existing errors from error tab
And I click on "Add cosmetic products"
And I click "Yes"
And I click "Yes"
When I upload "tSingleItem-Nano-Only-15754954500940363.zip"
Then I should not see any error in error tab
And I should see notification in incomplete tab

Scenario: Verify single item notification upload with exact range formulation and nano-materials
Given I login as responsible person user
And I dismiss any existing errors from error tab
And I click on "Add cosmetic products"
And I click "Yes"
And I click "Yes"
When I upload "tSingleItem-Nano-Only-15754954500940363.zip"
Then I should not see any error in error tab
And I should see notification in incomplete tab


 
Given I login as responsible person user
And I dismiss any existing errors from error tab
And I click on "Add cosmetic products"
And I click "Yes"
And I click "Yes"
When I upload "<file>"
Then I should not see any error in error tab
And I should see notification in incomplete tab

Scenario: Verify single item file upload with frame formulation  and nano-materials
Given I login as responsible person user
And I dismiss any existing errors from error tab
And I click on "Add cosmetic products"
And I click "Yes"
And I click "Yes"
When I upload "<file>"
Then I should not see any error in error tab
And I should see notification in incomplete tab

Scenario: Verify single item file upload with exact range formulation and nano-materials
Given I login as responsible person user
And I dismiss any existing errors from error tab
And I click on "Add cosmetic products"
And I click "Yes"
And I click "Yes"
When I upload "<file>"
Then I should not see any error in error tab
And I should see notification in incomplete tab

Scenario: Verify multi item file upload with exact range formulation
Given I login as responsible person user
And I dismiss any existing errors from error tab
And I click on "Add cosmetic products"
And I click "Yes"
And I click "Yes"
When I upload "<file>"
Then I should not see any error in error tab
And I should see notification in incomplete tab

Scenario: Single item upload with nano-materials only
Given I login as responsible person user
And I dismiss any existing errors from error tab
And I click on "Add cosmetic products"
And I click "Yes"
And I click "Yes"
When I upload "<file>"
Then I should not see any error in error tab
And I should see notification in incomplete tab

Scenario: Singe item notification upload with nano and formulation document
Given I login as responsible person user
And I dismiss any existing errors from error tab
And I click on "Add cosmetic products"
And I click "Yes"
And I click "Yes"
When I upload "<file>"
Then I should not see any error in error tab
And I should see notification in incomplete tab
 