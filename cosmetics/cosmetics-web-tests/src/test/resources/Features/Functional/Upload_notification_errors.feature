#Sample Feature Definition Template
@tag
Feature: Notification file upload error handling

@error
Scenario Outline: Verify correct correct is displayed for
Given I login user as
|nasiralikhan1982@gmail.com|Test@123|
And I click on "Show my cosmetic products"
And I click on "Add cosmetic products"
When I upload "<Invalid-file>"
Then I should see respective error"<Error>"
Examples: 
|Invalid-file|Error|
|testExportFile.zip		 				|A notification for this product already exists for this responsible person|
|noProductName.zip						|A notification for this product already exists for this responsible person|
|noRefNumber.zip							|Try again or manually register the product|
|chromedriver_mac64.zip				|The ZIP file does not contain a product XML file|
|1000.zip							 				|The ZIP file does not contain a product XML file|
|cases.xlsx						 				|The uploaded file is not a ZIP file|
