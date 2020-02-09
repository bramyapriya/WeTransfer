Feature: Transfer file feature 
	This feature helps to verify the upload process of file using link transfer

@regression 
Scenario: End to End verification of link transfer process for file uploading
	Given User is on WeTransfer homepage 
	When User uploads the file using link transfer 
	Then File should be uploaded 
