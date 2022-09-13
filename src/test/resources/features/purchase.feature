Feature: Order Placement Functionalities
@wip
  Scenario: Checking a successful order
    When User navigates to "Laptops" and adds "Sony vaio i5"
    And User navigates to "Laptops" and adds "Dell i7 8gb"
    And User navigates to "Cart" and deletes "Dell i7 8gb"
    And User clicks on Place order and fills the web form
    And User clicks on Purchase
    And User takes the purchase ID and amount
    And User checks the purchase amount is equals as expected
    Then User clicks on "Ok"
