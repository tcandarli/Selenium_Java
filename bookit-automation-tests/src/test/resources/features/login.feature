Feature: Login 

Scenario: Login as teacher 
	Given the user is on the login page 
	When the user logs in as a teacher 
	Then the user should be logged in 
	
Scenario: Login as a team lead 
	Given the user is on the login page 
	When the user logs in as a team lead
	Then the user should be logged in 
	