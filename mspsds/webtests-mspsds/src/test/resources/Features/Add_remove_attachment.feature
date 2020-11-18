#Author: Nasir Khan
Feature: As a psd-user
         In order for to add more details to a case
         I should be able add/update attachment
  

  Scenario: Validate error message when I don't chose a file
  Given I login as Trading standard user
  And I open case "Auto-test Testproduct, Auto-test dishwasher – chemical hazard"
  And I go to attachment tab
  And I click link "Add attachment"
  When I submit the form
  Then I should see error message "Enter file"
  

  Scenario: Validate error message when I don't enter attachment tile field
  When I add attachment to the case
  And I Keep attachment title field empty
  And I click save attachment
  Then I should see error "Enter title"

  Scenario: Add attachment
  When I fill in attachment title
  And I click save attachment
  #Then I should see "File added sucessfully"
  
 
 Scenario: Validate back link on edit attachment page
 Given I go to attachment tab
 And I click link "Edit image"
 When I click back
 Then I should see page "Overview"
 

 Scenario: Validate back link on edit attachment page
 Given I go to attachment tab
 And I click link "Edit image"
 When I click cancel
 Then I should see page "Overview"
 

  Scenario: Validate back link on delete attachment
  Given I go to attachment tab
  And I click link "Remove image"
  When I click back
  Then I should see page "Overview"
  
 
  Scenario: remove attachment
  Given I go to attachment tab
  And I click link "Remove image"
  And I click save attachment
  Then I should see "File was successfully removed"
  

 Scenario: Validate back link on add attachment
 Given I go to attachment tab
 And I click link "Add attachment"
 When I click back
 Then I should see page "Overview"
 
 
  