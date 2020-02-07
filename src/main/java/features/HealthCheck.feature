Feature: HealthCheck 
	This feature helps to perform  health check of the application and also inspects the application url status

@ramya
Scenario: Check whether application homepage is loaded properly or not 
	When User navigates to homepage 
	Then Home page should be loaded successfully 
	
@regression 
Scenario: Check for the broken links in the application 
	When User checks for the status of all links in the application 
	Then User should get the information related to active and broken url 
