Feature: Validate the CRUD operations

Scenario Outline: Verify Create operation 
   Given User enters headers, Params, body "<title>" "<body>" "<userId>"
   When User calls "Create" using "Post" http request
   And user gets the reponse
   And User verify "id" in response body "101"
   And User verify that status code is 201
   And user store "userId" value from response
   
   Examples:
   |title|body|userId|
   |test CRUD|Script to test CRUD operation|2|
   
   Scenario: Verify Read operation
   Given User enters param "userId" got from other api response
   When User calls "Read" using "Get" http request
   And user gets the reponse
  Then User verify that status code is 200
  
  Scenario: Verify Update operation
   Given User updates headers, Params, body "<title>" "<body>" "<userId>" "<id>"
   When User calls "Update" using "Put" http request
   And user gets the reponse
  Then User verify that status code is 200
   
   Examples:
   |title|body|userId|id|
   |test update|Script to test update operation|2|2|
   
   Scenario: Verify delete operation
   Given User updates headers, Params, body "<title>" "<body>" "<userId>" "<id>"
   When User calls "Delete" using "Delete" http request
   And user gets the reponse
  Then User verify that status code is 200
  
   
   Examples:
   |title|body|userId|id|
   |test update|Script to test update operation|2|2|
   
  