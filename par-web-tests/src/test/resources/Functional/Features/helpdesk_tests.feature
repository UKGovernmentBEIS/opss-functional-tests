
Feature: Download csv report

@helpdesk
Scenario: verify csv report download
Given I login as "par_helpdesk@example.com"
When I click on "Download CSV partnership report"
Then I should see "Performing CSV Download on selected entities."
