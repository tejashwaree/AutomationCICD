
@tag
Feature: Login validations
  I want to use this template for my feature file

  @ErrorValidations
  Scenario Outline: Checking login validations
    Given I landed on Ecommerce page
    When Log in with username <name> and password <password>
    Then "Incorrect email or password." is displayed

    Examples: 
      |name  						   | password 		| 
      | teju4321@gmail.com |Rahsdlshetty1 	|
