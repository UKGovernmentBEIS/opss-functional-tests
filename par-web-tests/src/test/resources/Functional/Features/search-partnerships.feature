Feature: Search Partnerships

@test1 @regression
Scenario Outline: Search Partnerships
   Given I login as "par_authority@example.com"
   When I click on "Search for a partnership"
   And I enter search term "<Search>"
   Then I should be able to find partnerships related to search term "<Search>" 
   
   Examples:
   |Search|
   |Tesco|
   |Sainsbury|
   |Asda|
  