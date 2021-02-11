Feature: Add item to a checkout
  In order to sell an item to a customer
  As a clerk
  I want to add new item so the total checkout is updated

  @tag1
  Scenario: Add item to an empty checkout
    Given a new checkout with code 1
    And the product "Aceite" price is 5
    And the product "Sal" price is 1
    When I add a product with name "Aceite"
    And I add a product with name "Sal"
    Then the checkout has 6 EUR in the total value