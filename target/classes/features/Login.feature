Feature: Verify Login
This feature verifies the login page functionality of ThuisBezorgd application

#Positive Scenario
@smoke @regression
Scenario Outline: Login to ThuisBezorgd with valid credentials 
	Given Customer is on ThuisBezorgd home page 
	And Customer navigates to application login page 
	When Customer enters the credentials "<username>" and "<password>" submit the login button 
	Then Customer should be successfully logged in to the application 
	Examples: 
		|username                 |password     |
		|ramyapriyavenki@gmail.com|Amruthasai123|


#Negative Scenario
@smoke @regression  
Scenario Outline: Login to ThuisBezorgd with Invalid credentials 
	Given Customer is on ThuisBezorgd home page 
	And Customer navigates to application login page 
	When Customer enters the credentials "<username>" and "<password>" submit the login button 
	Then Customer should not be able to login to the application 
	Examples: 
		|username                 |password     |
		|ramyapriyavenki@gmail.com|amruthasai123|
		

#Positive Scenario
@smoke @regression
Scenario: Login to ThuisBezorgd with valid credentials to order the food online 
	Given Customer is on ThuisBezorgd home page 
	And Customer navigates to login page 
	When Customer enters username and password and submit the login button 
	Then Customer should be successfully logged in to the application 
