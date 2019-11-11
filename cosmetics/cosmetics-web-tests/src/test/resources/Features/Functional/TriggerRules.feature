
Feature: Manual post brexit product notification
In order to notifiy post-brexit product manualluy
as a user
I should be able notify with required information for post-brexit notification
#Validate trigger rules 

@regression @trigger-rules 
Scenario: Verify harmful ingredients question for post-brexit notification
Given I login as responsible person user
And I select manually to notify product with single component
When I choose frame formulation 
Then I should see manual journey "Poisonous ingredients"

@regression @trigger-rules
Scenario: Verify poisonous ingredient gaurd question choice Yes
Given I select "Yes" contains poisonous ingredients
When I click on continue
Then I should see manual journey "Upload list of poisonous ingredients"
And I click back

@regression @trigger-rules
Scenario: verify poisonous gaurd question choice no
Given I select "No" contains poisonous ingredients
When I click on continue
Then I should see "What is the pH range of the product?"
And I click back

@regression @trigger-rules @upload-file
Scenario: Verify poisonous ingredient file upload
Given I select "Yes" contains poisonous ingredients
When I click on continue
And I upload poisonous ingredients file "Ingredients_test.pdf"
And I click on continue
Then I should see "What is the pH range of the product?"


#Validate pH range values
@regression @trigger-rules
Scenario: Validate pH is asked for all manual product notifications
Given I select pH between three and ten as "The minimum pH is 3 or higher, and the maximum pH is 10 or lower"
And I click on continue
Then I should see manual journey "Upload an image of the product label"
And I click back

@regression @trigger-rules
Scenario: Select min pH lower than 3 
Given I select The minimum pH is lower than three "The minimum pH is lower than 3"
And I click on continue
Then I should see min pH free text field
And I should see max pH free text field 
And I click back


@regression @trigger-rules
Scenario: Select min pH lower than 3 
Given I select The maximum pH is higher than ten"The maximum pH is higher than 10"
And I click on continue
Then I should see min pH free text field
And I should see max pH free text field 
And I click back

@regression @trigger-rules
Scenario: product does not have pH
Given I select product doesnt have pH "It does not have a pH"
And I click on continue
Then I should see manual journey "Upload an image of the product label"
And I click back


@regression @trigger-rules
Scenario: pH happy path
Given I select The maximum pH is higher than ten"The maximum pH is higher than 10"
And I click on continue 
And I enter min pH value "2.0"
And I enter max pH value "3.0"
And I click on continue 
Then I should see manual journey "Upload an image of the product label"
And I click back



@regression @trigger-rules
Scenario: Error message on invalid pH values
Given I select The maximum pH is higher than ten"The maximum pH is higher than 10"
And I click on continue 
And I enter min pH value "56"
And I enter max pH value "56"
And I click on continue 
Then I should see error message "Enter a value of 14 or lower for minimum pH"

@regression @trigger-rules
Scenario: Error message on negative pH values
Given I enter min pH value "-5"
And I enter max pH value "-6"
And I click on continue 
Then I should see error message "Enter a maximum pH"
Then I should see error message "Enter a minimum pH"

@regression @trigger-rules
Scenario: verify error message max pH is left empty
Given I enter min pH value "5"
And I enter max pH value " "
And I click on continue 
Then I should see error message "Enter a maximum pH"


@regression @trigger-rules
Scenario: Validate alkaline page when pH more than 10
Given I enter min pH value "10"
And I enter max pH value "11"
And I click on continue 
Then I should see manual journey "Upload an image of the product label"
#Then I should see "List the alkaline agents (including ammonium hydroxide liberators) and their concentration"
#
#@regression @trigger-rules
#Scenario: Validate alkaline agents cannot be empty
#When I click on continue
#Then I should see error message "No substance added"
#
#@regression @trigger-rules
#Scenario: Enter alkaline agents
#Given I enter agents substance "test-alkaline"
#And I enter substance value "8.22"
#When I click on continue
#Then I should see "Does the cosmetic product contain anti-hair loss agents?"
#
#@regression @trigger-rules
#Scenario: Verify anti-hair loss trigger rule
#Given I click "No"
#And I click on continue
#Then I should see "Does the cosmetic product contain anti-pigmenting and depigmenting agents?"
#And I click back
#
#When I click "Yes"
#Then I should see "List the anti-hair loss agents and their concentration"
#
#When I click on continue
#Then I should see error message "No substance added"
#
#Given I click back
#When I click "No"
#Then I should see "Does the cosmetic product contain anti-pigmenting and depigmenting agents?"
#
#@regression @trigger-rules
#Scenario: Verify anti-pigmentation agents trigger rule
#Given I click "Yes"
#Then I should see "List the anti-pigmenting and depigmenting agents and their concentration"
#
#When I click on continue
#Then I should see error message "No substance added"
#
#Given I click back
#When I click "No"
#Then I should see "Does the cosmetic product contain chemical exfoliating agents?"
#
#@regression @trigger-rules
#Scenario: Verify chemical exfoliating agents trigger rule
#Given I click "Yes"
#Then I should see "List the chemical exfoliating agents and their concentration"
#
#When I click on continue
#Then I should see error message "No substance added"
#
#Given I click back
#When I click "No"
#Then I should see "Does the cosmetic product contain more than 0.20% (calculated as retinol) or 0.09 grams (calculated as retinol) of vitamin A or its derivatives?"
#
#@regression @trigger-rules
#Scenario: Verify Vitamin A or its derivatives
#Given I click "Yes"
#Then I should see "List the vitamin A or its derivatives and their concentration"
#
#When I click on continue
#Then I should see error message "No substance added"
#
#Given I click back
#When I click "No"
#Then I should see "Does the cosmetic product contain more than 0.5% xanthine derivatives?"
#
#@regression @trigger-rules
#Scenario: Verify xanthine derivatives trigger rule question
#Given I click "Yes"
#Then I should see "List the xanthine derivatives and their concentration"
#
#When I click on continue
#Then I should see error message "No substance added"
#
#Given I click back
#When I click "No"
#Then I should see "Does the cosmetic product contain cationic surfactants with three or four chains or groups with a length shorter than C12 (including straight, branched, cyclic or aromatic groups)?"
#
#@regression @trigger-rules
#Scenario: Verify cationic surfactants trigger rule question
#Given I click "Yes"
#Then I should see "List the cationic surfactants and their concentration"
#
#When I click on continue
#Then I should see error message "No substance added"
#
#Given I click back
#When I click "No"
#Then I should see "Does the cosmetic product contain propellants?"
#
#@regression @trigger-rules
#Scenario: Verify propellants trigger rule question
#Given I click "Yes"
#Then I should see "List the propellants and their concentration"
#
#When I click on continue
#Then I should see error message "No substance added"
#
#Given I click back
#When I click "No"
#Then I should see "Does the cosmetic product contain hydrogen peroxides?"
#
#@regression @trigger-rules
#Scenario: Verify hydrogen peroxides trigger rule question
#Given I click "Yes"
#Then I should see "List the hydrogen peroxides and their concentration"
#
#When I click on continue
#Then I should see error message "No substance added"
#
#Given I click back
#When I click "No"
#Then I should see "Does the cosmetic product contain compounds releasing hydrogen peroxide?"
#
#@regression @trigger-rules
#Scenario: Verify compounds releasing hydrogen peroxide trigger rule question
#Given I click "Yes"
#Then I should see "List the compounds releasing hydrogen peroxide and their concentration"
#
#When I click on continue
#Then I should see error message "No substance added"
#
#Given I click back
#When I click "No"
#Then I should see "Does the cosmetic product contain reducing agents?"
#
#
#@regression @trigger-rules
#Scenario: Verify reducing agents trigger rule question
#Given I click "Yes"
#Then I should see "List the reducing agents and their concentration"
#
#When I click on continue
#Then I should see error message "No substance added"
#
#Given I click back
#When I click "No"
#Then I should see "Does the cosmetic product contain persulfates?"
#
#@regression @trigger-rules
#Scenario: Verify persulfates agents trigger rule question
#Given I click "Yes"
#Then I should see "List the persulfates and their concentration"
#
#When I click on continue
#Then I should see error message "No substance added"
#
#Given I click back
#When I click "No"
#Then I should see "Does the cosmetic product contain straightening agents?"
#
#@regression @trigger-rules
#Scenario: Verify straightening agents trigger rule question
#Given I click "Yes"
#Then I should see "List the straightening agents and their concentration"
#
#When I click on continue
#Then I should see error message "No substance added"
#
#Given I click back
#When I click "No"
#Then I should see "Does the cosmetic product contain inorganic sodium salts?"
#
#@regression @trigger-rules
#Scenario: Verify inorganic sodium salts agents trigger rule question
#Given I click "Yes"
#Then I should see "List the inorganic sodium salts and their concentration"
#
#When I click on continue
#Then I should see error message "No substance added"
#
#Given I click back
#When I click "No"
#Then I should see "Does the cosmetic product contain fluoride compounds?"
#
#
#@regression @trigger-rules
#Scenario: Verify fluoride compounds agents trigger rule question
#Given I click "Yes"
#Then I should see "List the fluoride compounds and their concentration"
#
#When I click on continue
#Then I should see error message "No substance added"
#
#Given I click back
#When I click "No"
#Then I should see "Does the cosmetic product contain essential oils, camphor, menthol, or eucalyptol?"
#
#@regression @trigger-rules
#Scenario: Verify essential oils, camphor, menthol, or eucalyptol agents trigger rule question
#Given I click "Yes"
#Then I should see "List the essential oils, camphor, menthol, or eucalyptol and their concentration"
#
#When I click on continue
#Then I should see error message "No substance added"
#
#Given I click back
#When I click "No"
#Then I should see "Does the cosmetic product contain ethanols?"
#
#@regression @trigger-rules
#Scenario: Verify ethanols agents trigger rule question
#Given I click "Yes"
#Then I should see free text to enter amount contains in product
#
#When I click on continue
#Then I should see error message "Answer can not be blank"
#
#When I click "No"
#And I click on continue
#Then I should see "Does the cosmetic product contain isopropanols?"
#
#
#@regression @trigger-rules
#Scenario: Verify isopropanols trigger rule question
#Given I click "Yes"
#Then I should see free text to enter amount contains in product
#
#When I click on continue
#Then I should see error message "Answer can not be blank"
#When I click "No"
#Then I should see manual-journey step "Upload an image of the product label"



Scenario: Validate bulk upload journey screens
Given I login user as
|nasiralikhan1982@gmail.com|Test@123|
And I click on "Your cosmetic products"
When I click on "Add cosmetic products"
Then I should see "Have the cosmetic products been notified in the EU?"

When I click "Yes, they are already notified in the EU"
Then I should see "Do you have the files from your EU notification"

When I click "Yes, I have ZIP files containing XML to upload"
Then I should see manual-journey step "Upload your EU notification files"


