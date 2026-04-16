
Feature: ShipAccel application user should be able to import orders from a csv file


Scenario Outline: user should be able to import orders from a file 
    
    Given User launches ShipAccel application using URL
    When User logs in with <Email> and <password>
    Then Login Should be successful and user should land on "/orders" path
    And User should see the "<Orders>" page
    And User should be able to import orders from a csv file
    And Imported orders should be visible in the orders list
    
 Examples:
  	  | Email       							  | password       |
      | shipaccel_ngam_premier_001@yopmail.com    | Horizon#12345  |