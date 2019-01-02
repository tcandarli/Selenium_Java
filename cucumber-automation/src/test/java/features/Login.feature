Feature: Application login 

Scenario: Home page default login 
	Given User is on NetBanking landing page 
	When User login into application with "John" and password "321"
	Then Home page is populated 
	And Cards displayed are "true"
	
Scenario: Home page default login 
	Given User is on NetBanking landing page 
	When User login into application with "Mike" and password "123"
	Then Home page is populated 
	And Cards displayed are "false"