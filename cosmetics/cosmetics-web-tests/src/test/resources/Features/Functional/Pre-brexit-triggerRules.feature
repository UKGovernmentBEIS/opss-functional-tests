Feature: Manual pre-brexit product notification
In order notify product pre-brexit
as a user
I should be a notify with requried information for pre-brexit notification


@regression @trigger-rules @pre-brexit
Scenario: Verify manual journey for pre-brexit notification
Given I login as responsible person user
And I select manually to notify pre-brexit product with single component
When I choose frame formulation 
Then I should see "What is the pH range of the product?"

@pre-brexit @regression
Scenario: Verify after pH it should go to check your answer page
Given I select pH between three and ten as "The minimum pH is 3 or higher, and the maximum pH is 10 or lower"
And I click on continue
Then I should see check your answer page "TestManual-Prod"