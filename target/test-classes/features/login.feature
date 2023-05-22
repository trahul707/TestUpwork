Feature: Validate the Login functionality For Facebook

Scenario: Verify login functionality with correct username and password
   Given User launch the facebook
   Given User login to facebook with "testapplication306@gmail.com"
   When User verify login is success
   And User close the browser
   
   
   Scenario Outline: Verify login functionality with incorrect username and password
   Given User launch the facebook
   Given User login to facebook with incorrect password "<Username>"
   When User verify login is failed
   And User close the browser
   
   Examples:
   |Username|
   |testapplication306@gmail.com|
   