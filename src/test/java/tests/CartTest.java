package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class CartTest extends BaseTest {

    @Test
    public void checkAddedOneProductToCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickAddButton("Sauce Labs Backpack");
        productsPage.clickShoppingCart();
        String product = cartPage.getNameOfProduct();
        assertEquals(product, "Sauce Labs Backpack", "название продукта не соответствует ожидаемому");
    }

    @Test
    public void checkPriceOfProduct() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickAddButton("Sauce Labs Backpack");
        productsPage.clickShoppingCart();
        String price = cartPage.checkPrice("Sauce Labs Backpack");
        assertEquals(price, "$29.99", "цена не соответствует ожидаемому");
    }

    @Test
    public void checkDescriptionOfProduct() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickAddButton("Sauce Labs Backpack");
        productsPage.clickShoppingCart();
        String description = cartPage.checkDescription("Sauce Labs Backpack");
        assertEquals(description, "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.", "описание не соответствует ожидаемому");
    }

    @Test
    public void checkAddedSomeProductsToCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickAddButton("Sauce Labs Backpack");
        productsPage.clickAddButton("Sauce Labs Bike Light");
        productsPage.clickAddButton("Sauce Labs Bolt T-Shirt");
        productsPage.clickShoppingCart();
        int products = cartPage.checkCountOfProducts();
        assertEquals(products, 3, "количество товаров не соответствует ожидаемому");
    }

    @Test
    public void checkRemoveProduct() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickAddButton("Sauce Labs Backpack");
        productsPage.clickShoppingCart();
        cartPage.clickRemoveProduct("Sauce Labs Backpack");
        int productsCount = cartPage.checkCountOfProducts();
        assertEquals(productsCount, 0, "количество продуктов не соответствует ожидаемому");
    }

    @Test
    public void checkRemoveOneProductFromSome() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickAddButton("Sauce Labs Backpack");
        productsPage.clickAddButton("Sauce Labs Bike Light");
        productsPage.clickAddButton("Sauce Labs Bolt T-Shirt");
        productsPage.clickShoppingCart();
        cartPage.clickRemoveProduct("Sauce Labs Bike Light");
        int productsCount = cartPage.checkCountOfProducts();
        assertEquals(productsCount, 2, "количество продуктов не соответствует ожидаемому");
    }

    @Test
    public void checkReturnToProduct() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickAddButton("Sauce Labs Backpack");
        productsPage.clickShoppingCart();
        cartPage.clickContinueShoppingButton();
        assertEquals(productsPage.getTitle(), "Products", "переход на страницу не выполнен");
    }
}