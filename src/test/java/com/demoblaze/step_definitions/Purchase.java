package com.demoblaze.step_definitions;

import com.demoblaze.pages.PlaceOrderPage;
import com.demoblaze.pages.ProductPage;
import com.demoblaze.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class Purchase {
    ProductPage productPage=new ProductPage();
    PlaceOrderPage placeOrderPage=new PlaceOrderPage();

    int expectedAmount;
    int actualAmount;

    @When("User navigates to {string} and adds {string}")
    public void user_navigates_to_and_adds(String category, String product) {
        productPage.navigateTo(category,product);
        productPage.addToCart();
        productPage.home.click();

    }
    @When("User navigates to {string} and deletes {string}")
    public void user_navigates_to_and_deletes(String cart, String product) {
        Driver.get().findElement(By.linkText(cart)).click();
        productPage.deleteProduct(product);
    }
    @When("User clicks on Place order and fills the web form")
    public void user_clicks_on_place_order_and_fills_the_web_form() {
        expectedAmount= Integer.parseInt(productPage.totalPrice.getText());
        productPage.placeOrder.click();
        placeOrderPage.fillForm();


    }
    @When("User clicks on Purchase")
    public void user_clicks_on_purchase() {
        placeOrderPage.purchase.click();

    }
    @When("User takes the purchase ID and amount")
    public void user_takes_the_purchase_id_and_amount() {

        String orderDetails=placeOrderPage.orderDetails.getText();

        String orderId=orderDetails.split("\n")[0];
        System.out.println("orderId = " + orderId);

        actualAmount = Integer.parseInt(orderDetails.split("\n")[1].split(" ")[1]);
        System.out.println("actualAmount = " + actualAmount);


    }
    @When("User checks the purchase amount is equals as expected")
    public void user_checks_the_purchase_amount_is_equals_as_expected() {

        Assert.assertEquals("Prices are Not equals",expectedAmount,actualAmount);

    }
    @Then("User clicks on {string}")
    public void user_clicks_on(String string) {
        placeOrderPage.ok.click();

    }


}
