package com.example.demo.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckoutSteps {


    @Given("a new checkout with code {int}")
     public void a_new_checkout_with_code(Integer int1) {
        // Write code here that turns the phrase above into concrete actions

    }

    @Given("the product {string} price is {int}")
    public void the_product_price_is(String string, Integer int1) {
        // Write code here that turns the phrase above into concrete actions

    }

    @When("I add a product with name {string}")
    public void i_add_a_product_with_name(String string) {
        // Write code here that turns the phrase above into concrete actions

    }

    @Then("the checkout has {int} EUR in the total value")
    public void the_checkout_has_eur_in_the_total_value(Integer int1) {
        // Write code here that turns the phrase above into concrete actions

    }







}
