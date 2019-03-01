#Sample Feature Definition Template
@tag
Feature: Populate product info
As a user 
in order to add my cosmetic product
I shoud be able populate from a file import


@regression
Scenario:Verify add product by file import
Given I login user as
|user|pwd|
And I click on "Show my cosmetic products"
And I click on "Try uploading files again"
And I upload file "example-cpnp-export.zip"
Then I should be able to see no errors 
And I should see product added in Unfinished tab


