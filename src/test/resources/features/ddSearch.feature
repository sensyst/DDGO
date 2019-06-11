@AC6
Feature: Verify application allows the user to login to HealthCare Volunteer portal using valid Credentials

  Scenario: Test Successful searches
    Given User navigate to DDG Home page
    When User enter keyword <searchKey> to search 
    
    		| Back to the future			| 
    		| BMX Bandits	| 
    		| Rocky IV		|
    		
    Then Verify the top ten relevant results is printed for <searchKey>

