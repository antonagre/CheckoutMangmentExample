Feature: Add item to a checkout
  In order to sell an item to a customer
  As a clerk
  I want to add new item so the total checkout is updated

  @tag1
  Scenario: Add item to an empty checkout
    Given a new checkout with code 1
    And the product "Pizza" price is 8
    And the product "Beer" price is 3
    When I add a product with name "Pizza"
    And I add a product with name "Beer"
    Then the checkout has 11 EUR in the total value