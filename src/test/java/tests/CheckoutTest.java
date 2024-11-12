package tests;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class CheckoutTest extends BaseTest {

    @Test
    public void checkCheckout() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickAddButton("Sauce Labs Backpack");
        productsPage.clickShoppingCart();
        yourCart.clickCheckoutButton();
        checkoutPage.enterFirstName("Julia");
        checkoutPage.enterLastName("Zhdanova");
        checkoutPage.enterPostalCode("12345");
        checkoutPage.clickContinueButton();
        assertEquals("переход на страницу не выполнен", "Checkout: Overview", checkoutOverviewPage.getTitle());
    }

    @Test
    public void checkErrorMassageIfFirstNameEmpty() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickAddButton("Sauce Labs Backpack");
        productsPage.clickShoppingCart();
        yourCart.clickCheckoutButton();
        checkoutPage.enterFirstName("");
        checkoutPage.enterLastName("Zhdanova");
        checkoutPage.enterPostalCode("12345");
        checkoutPage.clickContinueButton();
        assertEquals("ошибка не выводится ", "Error: First Name is required", checkoutPage.getErrorMassage());
    }

}