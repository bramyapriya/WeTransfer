Feature: Verify Logout 
	This feature verifies the logout page functionality of ThuisBezorgd application

Background: 
	Given Customer is on ThuisBezorgd home page 
	And Customer navigates to login page 
	When Customer enters username and password and submit the login button 
	
	
@smoke @regression
Scenario: Verify whether customer is successfully logged Out from the application 
	When Customer clicks on logout button 
	Then Customer should be logged out from the aplication successfully