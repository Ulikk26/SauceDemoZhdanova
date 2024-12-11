package tests;

import jdk.jfr.Description;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Log4j2
public class CheckoutTest extends BaseTest {

    @Test(testName = "Проверка перехода на страницу Checkout: Overview ", description = "Проверка перехода на страницу Checkout: Overview")
    @Description("Проверка перехода на страницу Checkout: Overview")
    public void checkCheckout() {
        log.info("Going to page Checkout: Overview");
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickAddButton("Sauce Labs Backpack");
        productsPage.clickShoppingCart();
        cartPage.clickCheckoutButton();
        checkoutPage.enterFirstName("Julia");
        checkoutPage.enterLastName("Zhdanova");
        checkoutPage.enterPostalCode("12345");
        checkoutPage.clickContinueButton();
        assertEquals(checkoutOverviewPage.getTitle(), "Checkout: Overview", "переход на страницу не выполнен");
    }

    @Test(testName = "Проверка ошибки , при переходе на страницу Checkout: Overview ", description = "Проверка ошибки , при переходе на страницу Checkout: Overview")
    @Description("Проверка ошибки , при переходе на страницу Checkout: Overview , при пустом поле FirstName")
    public void checkErrorMassageIfFirstNameEmpty() {
        log.info("Checking the error message if the firstName field is empty");
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