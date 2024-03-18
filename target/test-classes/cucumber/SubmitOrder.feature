
@tag
Feature: Purchase the order from Ecommerce website
  I want to use this template for my feature file

	Background:
	Given I landed on Ecommerce page

  @Regression
  Scenario Outline: Positive  test of submitting the order
    Given Log in with username <name> and password <password>
    When I add product <productName> from cart
    And checkout <productName> and submit the order
    Then "THANKYOU FOR THE ORDER." is displayed on Confirmation page

    Examples: 
      | name  						 | password 		| productName  | 
      | teju4321@gmail.com |Rahulshetty1 	| ZARA COAT 3  |
   
