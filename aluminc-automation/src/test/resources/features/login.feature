Feature: Login page tests

@login
Scenario: Login as guest
	Given the user is on the login page
	When the user logs in as mikesmith
	Then the user should be logged in
	And there should be dashboard
	

Scenario Outline: Login as different users
	Given the user logs in using "<email>" "<password>"
	When the user is on the login page
	Then the user should be logged in
Examples:
		|email					|password		|
		|mikesmith@gmail.com	|123			|
		|marysmith@gmail.com	|123			|
	
	
	
