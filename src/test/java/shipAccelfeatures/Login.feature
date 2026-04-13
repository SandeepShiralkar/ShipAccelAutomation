
Feature: ShipAccel Application login and logout


Scenario Outline: User should be able to login successfully 
    
    Given User launches ShipAccel application using URL
    When User logs in with <Email> and <password>
    Then Login Should be successful and user should land on "/orders" path
    And User should see the "<Orders>" page
    And User Signs out from the ShipAccel application
    And User should be navigated to the login page and see Email field.
    
  Examples:
  	    | Email       								| password       | header |
        | shipaccel_ngam_premier_001@yopmail.com    | Horizon#12345  | Orders |
       
    
   