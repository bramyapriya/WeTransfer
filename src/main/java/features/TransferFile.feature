Feature: Transfer file feature 
	This feature helps to perform  health check of the application and also inspects the application url status

@regression 
Scenario: End to End verification of link transfer process 
	Given User is on WeTransfer homepage 
	When User uploads the file using link transfer 
	Then File should be uploaded 
