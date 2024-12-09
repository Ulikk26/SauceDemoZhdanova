package tests;

import jdk.jfr.Description;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CheckoutTest extends BaseTest {

    @Test(testName = "Проверка перехода на страницу Checkout: Overview ", description = "Проверка перехода на страницу Checkout: Overview")
    @Description("Проверка перехода на страницу Checkout: Overview")
    public void checkCheckout() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickAddButton("Sauce Labs Backpack");
        productsPage.clickShoppingCart();
        cartPage.clickCheckoutButton();
        checkoutPage.enterFirstName("");
        checkoutPage.enterLastName("Zhdanova");
        checkoutPage.enterPostalCode("12345");
        checkoutPage.clickContinueButton();
        assertEquals(checkoutOverviewPage.getTitle(), "Checkout: Overview", "переход на страницу не выполнен");
    }

    @Test(testName = "Проверка ошибки , при переходе на страницу Checkout: Overview ", description = "Проверка ошибки , при переходе на страницу Checkout: Overview")
    @Description("Проверка ошибки , при переходе на страницу Checkout: Overview , при пустом поле FirstName")
    public void checkErrorMassageIfFirstNameEmpty() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickAddButton("Sauce Labs Backpack");
        productsPage.clickShoppingCart();
        cartPage.clickCheckoutButton();
        checkoutPage.enterFirstName("");
        checkoutPage.enterLastName("Zhdanova");
        checkoutPage.enterPostalCode("12345");
        checkoutPage.clickContinueButton();
        assertEquals(checkoutPage.getErrorMassage(), "Error: First Name is required", "ошибка не отображается");
    }
}