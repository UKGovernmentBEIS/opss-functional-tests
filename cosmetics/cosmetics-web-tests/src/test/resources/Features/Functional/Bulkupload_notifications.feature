
#Sample Feature Definition Template
@tag
Feature: Bulk upload
	As a user
	In order to notify multiple products
	I should be able to do bulk upload
	
	
Scenario: File upload more than 100
Given I login as responsible person user
When I upload 101 files
Then I should see error ""

Scenario: No file upload


@tag1
Scenario: Title of your scenario
Given I want to write a step with precondition
	And some other precondition
When I complete action
	And some other action
	And yet another action
Then I validate the outcomes
	And check more outcomes

@tag2
Scenario Outline: Title of your scenario outline
Given I want to write a step with <name>
When I check for the <value> in step
Then I verify the <status> in step

Examples:
    | name  |value | status |
    | name1 |  5   | success|
    | name2 |  7   | Fail   |
