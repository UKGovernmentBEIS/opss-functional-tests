Feature: Standard Nano material journey
As as notify user
In order to notify product with nano material
I should be able to enter nano material

@nano-material
Scenario: Verify standard nano material journey
Given I login as responsible person user
When I select notify product manually 
And I select Yes it contains nano material
And I click on continue
Then I should see "Is the cosmetic product intended to be rinsed off or left on?"

@nano-material
Scenario: Verify how user is exposed to nano-material question
When I click "Rinse off"
Then I should see "How is the user likely to be exposed to the nanomaterials?"

Scenario: Verify nano material exposure is given in multi selectable checkboxes
Given I am on exposure route page
Then I should see multi selectable exposure route "Dermal"
And I should see multi selectable exposure route "Dermal"
And I should see multi selectable exposure route "Dermal"

Scenario: Verify nano material inci to display legislation for each inci purpose type- Passed

Scenario: Verify when inci purpose is colorant then Annex 4 legislation question is triggered- Passed

Scenario: Verify when INCI purpose is preservative then Annex 5 legislation is triggered - Passed

Scenario: Verify when INCI purpose is UV filter then Annex 6 legislation is triggered - Passed



