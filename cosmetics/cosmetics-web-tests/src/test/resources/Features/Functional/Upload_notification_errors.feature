Feature: Notification file upload error handling

@regression
Scenario Outline: Verify correct correct is displayed for
Given I login as responsible person user
And I dismiss any existing errors from error tab
And I click on "Add cosmetic products"
And I click "Yes"
And I click "Yes"
When I upload "<Invalid-file>"
Then I should see respective error"<Error>"

Examples: 
|Invalid-file|Error|
|testExportFile.zip		 				|A notification for this product already exists for this responsible person|
|noProductName.zip						|Try again or manually enter the production notification data|
|noRefNumber.zip							|Try again or manually enter the production notification data|
|chromedriver_mac64.zip				|The ZIP file does not contain a product XML file|
|1000.zip							 				|The ZIP file does not contain a product XML file|
|cases.xlsx						 				|The uploaded file is not a ZIP file|
