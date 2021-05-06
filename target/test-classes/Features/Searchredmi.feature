#Author: sangeeth.email@your.domain.com
Feature: the readmi text and price

  #Given user launch flipkart application
  Scenario Outline: validate the readmi text and price
    When user need to close login pops
    When user need to click the search box
    And user enter the product and click search "<product>"
    And user need to get redmi phone text and price
    And user need get lowest price
 	And user need get lowest prices form excel
 	And user need get lowest prices form excels
 	
    Examples: 
      | product      |
      | redmi mobile |
