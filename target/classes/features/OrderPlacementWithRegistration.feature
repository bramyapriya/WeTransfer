Feature: Verify order placement with registration
This feature allows the customer to place an order of his choice from the desired restaurant by logging in to Thuizbezorgd using his personal account
	
@regression
Scenario: Verify the process of ordering the food items(1X Coke, 1X Duck breast with tomato, 1X Pizza salami) at customers new address 
	Given Customer is logged in to Thuizbezorgd  
	And Selects restaurant from the list of available restaurants in their postalcode 
	When Customer selects the fooditems as of his choice from the menu options 
	And Customer fills in the delivery details and tries to perform ideal payment 
	And Cancels the ideal payment and performs cash payment 
	Then Order should be placed successfully 
	
	
@regression
Scenario: Verify the process of placing an order at customer existing address 
	Given Customer is logged in to Thuizbezorgd  
	And Selects restaurant from the list of available restaurants in their postalcode 
	When Customer selects the fooditems as of his choice from the menu options 
	And Customer selects the option of delivering at existing address and tries to perform ideal payment 
	And Cancels the ideal payment and performs cash payment 
	Then Order should be placed successfully