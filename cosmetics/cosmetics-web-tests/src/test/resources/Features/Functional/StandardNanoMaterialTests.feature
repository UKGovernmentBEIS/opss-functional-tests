Feature: Standard Nano material journey
As as notify user
In order to notify product with nano material
I should be able to enter nano material

@regression @nano-material
Scenario: Verify standard nano material journey
Given I login as responsible person user
When I select notify product manually 
And I click "No"
And I select Yes it contains nano material
And I click on continue
Then I should see "Is the cosmetic product intended to be rinsed off or left on?"

@regression @nano-material
Scenario: Verify how user is exposed to nano-material question
When I click "Rinse off"
Then I should see "How is the user likely to be exposed to the nanomaterials?"

@regression @nano-material
Scenario: Verify correct Annex displayed as per the inci purpose
When I select user likely to be exposed by "Dermal"
And I select user likely to be exposed by "Oral"
And I click on continue
Then I should see "List the nanomaterials in the cosmetic product"


Scenario: Verify nano material exposure is given in multi selectable checkboxes
Given I am on exposure route page
Then I should see multi selectable exposure route "Dermal"
And I should see multi selectable exposure route "Oral"
And I should see multi selectable exposure route "Inhalation"

 @regression @nano-material
Scenario: Enter Inci name
Given I enter INCI name "test"
And I click on continue
Then I should see "What is the purpose of test?"

@regression @nano-material
Scenario: Annex 4 is displayed when colorant is choosen
Given I select purpose for nanomaterial "Colourant"
And I click on continue
Then I should see regulation "Is test listed in EC regulation 1223/2009, Annex 4?"

@regression @nano-material
Scenario: Annex 5 is displayed when preservative is choosen
Given I click back
And I select purpose for nanomaterial "Preservative"
And I click on continue
Then I should see regulation "Is test listed in EC regulation 1223/2009, Annexes 4 and 5?"

@regression @nano-material
Scenario: Annex 6 is displayed when UV Filter  is choosen
Given I click back
And I select purpose for nanomaterial "UV filter"
And I click on continue
Then I should see regulation "Is test listed in EC regulation 1223/2009, Annexes 4, 5 and 6?"

@regression @nano-material
Scenario: Verify nano-material is used in accordnance with the restiction for each selected purpose
Given I click back
And I select purpose for nanomaterial "Preservative"
And I click on continue
When I click on "Yes" on annex 
And I click on continue
Then I should see "Does the test conform to the restrictions set out in Annexes 4 and 6?"

@regression @nano-material
Scenario: Verify nano-material journey page is complete once restriction page is confirmed
When I click "Yes"
And I click on continue
Then I should see "What category of cosmetic product is it?"



