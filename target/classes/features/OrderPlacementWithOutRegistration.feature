Feature: Verify order placement without registration
This feature allows the customer to place an order of his choice from the desired restaurant with out registering in Thiuzbezorgd.

@regression
Scenario: Verify order placement process for the food items(1X Coke, 1X Duck breast with tomato, 1X Pizza salami) with out registration
    Given Customer is on Thuizbezorgd home page
    And Selects restaurant from the list of available restaurants in their postalcode
    When Customer selects the fooditems as of his choice from the menu options
  	And Customer fills in the delivery details and tries to perform ideal payment
   	And Cancels the ideal payment and performs cash payment
    Then Order should be placed successfully

@regression
Scenario: Verify the functionality of deleting an item from order basket
    Given Customer is on Thuizbezorgd home page
    And Selects restaurant from the list of available restaurants in their postalcode
    When Customer selects thier favourite dishes from the menu
    Then If customer removes an item from basket than item should be deleted successfully from the basket

@regression
Scenario: Verify the process of adding comments to individual items while adding them to order basket
    Given Customer is on Thuizbezorgd home page
    And Selects restaurant from the list of available restaurants in their postalcode
    When Customer selects thier favourite dishes from the menu
    And Customer add comments to the indvidual items in the order basket
    And Customer fills in the delivery details and tries to perform ideal payment
    And Cancels the ideal payment and performs cash payment
    Then Order should be placed successfully

@regression
Scenario: Verify the process of changing the quantity of food items within the order basket(Addition)
    Given Customer is on Thuizbezorgd home page
    And Selects restaurant from the list of available restaurants in their postalcode
    When Customer adds the required food items to the basket
    And Later on customer tries to add extra quantity of any food item in the basket
    Then Extra quantity should be placed successfully

@regression
Scenario: Verify the process of changing the quantity of food items within the order basket(Substraction)
    Given Customer is on Thuizbezorgd home page
    And Selects restaurant from the list of available restaurants in their postalcode
    When Customer adds the required food items to the basket
    And Later on customer tries to remove the extra quantity of duck breast item in the basket
    Then Extra quantity should be deleted successfully

@regression
Scenario: Perform field validation on the fields present in order placement page
    Given Customer is on Thuizbezorgd home page
    And Selects restaurant from the list of available restaurants in their postalcode
    When Customer selects thier favourite dishes from the menu
    And Fill in their delivery details
    Then Field validation should be performed on delivery details