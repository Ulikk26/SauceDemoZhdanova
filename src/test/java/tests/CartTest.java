package tests;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class CartTest extends BaseTest {

    @Test
    public void checkAddedOneProductToCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickAddButton("Sauce Labs Backpack");
        productsPage.clickShoppingCart();
        String product = yourCart.getNameOfProduct();
        assertEquals("название продукта не соответствует ожидаемому", "Sauce Labs Backpack", product);
    }

    @Test
    public void checkPriceOfProduct() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickAddButton("Sauce Labs Backpack");
        productsPage.clickShoppingCart();
        String price = yourCart.checkPrice("Sauce Labs Backpack");
        assertEquals("цена не соответствует ожидаемому", "$29.99", price);
    }

    @Test
    public void checkDescriptionOfProduct() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickAddButton("Sauce Labs Backpack");
        productsPage.clickShoppingCart();
        String description = yourCart.checkDescription("Sauce Labs Backpack");
        assertEquals("описание не соответствует ожидаемому", "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.", description);
    }

    @Test
    public void checkAddedSomeProductsToCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickAddButton("Sauce Labs Backpack");
        productsPage.clickAddButton("Sauce Labs Bike Light");
        productsPage.clickAddButton("Sauce Labs Bolt T-Shirt");
        productsPage.clickShoppingCart();
        int products = yourCart.checkCountOfProducts();
        assertEquals("переход на страницу не выполнен", 3, products);
    }

    @Test
    public void checkRemoveProduct() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickAddButton("Sauce Labs Backpack");
        productsPage.clickShoppingCart();
        yourCart.clickRemoveProduct("Sauce Labs Backpack");
        int productsCount = yourCart.checkCountOfProducts();
        assertEquals("количество продуктов не соответствует ожидаемому", 0, productsCount);
    }

    @Test
    public void checkRemoveOneProductFromSome() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickAddButton("Sauce Labs Backpack");
        productsPage.clickAddButton("Sauce Labs Bike Light");
        productsPage.clickAddButton("Sauce Labs Bolt T-Shirt");
        productsPage.clickShoppingCart();
        yourCart.clickRemoveProduct("Sauce Labs Bike Light");
        int productsCount = yourCart.checkCountOfProducts();
        assertEquals("количество продуктов не соответствует ожидаемому", 2, productsCount);
    }

    @Test
    public void checkReturnToProduct() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickAddButton("Sauce Labs Backpack");
        productsPage.clickShoppingCart();
        yourCart.clickContinueShoppingButton();
        assertEquals("переход на страницу не выполнен","Products",productsPage.getTitle());
    }

}