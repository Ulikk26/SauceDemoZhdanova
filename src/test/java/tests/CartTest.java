package tests;

import jdk.jfr.Description;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Log4j2
public class CartTest extends BaseTest {

    //метод будет выполняться всегда вне зависимости от результатов методов, на которые он завязан
    @Test(testName = "Проверка названия добавленного продукта в корзину", description = "Проверка названия добавленного продукта в корзину", alwaysRun = true)
    @Description("Проверка названия добавленного продукта в корзину")
    public void checkAddedOneProductToCart() {
        log.info("Checking the name of the added product");
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickAddButton("Sauce Labs Backpack");
        productsPage.clickShoppingCart();
        String product = cartPage.getNameOfProduct();
        assertEquals(product, "Sauce Labs Backpack", "название продукта не соответствует ожидаемому");
    }

    //повторить тест 2 раза invocationCount = 2
    @Test(testName = "Проверка цены добавленного продукта в корзину", description = "Проверка цены добавленного продукта в корзину", invocationCount = 2)
    @Description("Проверка цены добавленного продукта в корзину")
    public void checkPriceOfProduct() {
        log.info("Checking the price of the added product");
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickAddButton("Sauce Labs Backpack");
        productsPage.clickShoppingCart();
        String price = cartPage.checkPrice("Sauce Labs Backpack");
        assertEquals(price, "$29.99", "цена не соответствует ожидаемому");
    }

    //тест включен в группу slow groups = "slow"
    @Test(testName = "Проверка описания добавленного продукта в корзину", description = "Проверка описания добавленного продукта в корзину", groups = {"slow"})
    @Description("Проверка описания добавленного продукта в корзину")
    public void checkDescriptionOfProduct() {
        log.info("Checking the description of the added product");
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickAddButton("Sauce Labs Backpack");
        productsPage.clickShoppingCart();
        String description = cartPage.checkDescription("Sauce Labs Backpack");
        assertEquals(description, "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.", "описание не соответствует ожидаемому");
    }

    //тест включен в группу fast groups = "fast"
    @Test(testName = "Проверка добавления нескольких продуктов в корзину", description = "Проверка добавления нескольких продуктов в корзину", groups = {"fast"})
    @Description("Проверка добавления нескольких продуктов в корзину")
    public void checkAddedSomeProductsToCart() {
        log.info("Adding some products into cart");
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickAddButton("Sauce Labs Backpack");
        productsPage.clickAddButton("Sauce Labs Bike Light");
        productsPage.clickAddButton("Sauce Labs Bolt T-Shirt");
        productsPage.clickShoppingCart();
        int products = cartPage.checkCountOfProducts();
        assertEquals(products, 3, "количество товаров не соответствует ожидаемому");
    }

    @Test(testName = "Проверка удаления продуктов из корзины", description = "Проверка удаления продуктов из корзины")
    @Description("Проверка удаления продуктов из корзины")
    public void checkRemoveProduct() {
        log.info("Removing the product from the cart");
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickAddButton("Sauce Labs Backpack");
        productsPage.clickShoppingCart();
        cartPage.clickRemoveProduct("Sauce Labs Backpack");
        int productsCount = cartPage.checkCountOfProducts();
        assertEquals(productsCount, 0, "количество продуктов не соответствует ожидаемому");
    }

    @Test(testName = "Проверка удаления одного продукта из нескольких", description = "Проверка удаления одного продукта из нескольких")
    @Description("Проверка удаления одного продукта из нескольких")
    public void checkRemoveOneProductFromSome() {
        log.info("Removing one product from several");
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

    @Test(testName = "Проверка возврата на страницу продуктов", description = "Проверка возврата на страницу продуктов")
    @Description("Проверка возврата на страницу продуктов")
    public void checkReturnToProduct() {
        log.info("Return to Products Page");
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickAddButton("Sauce Labs Backpack");
        productsPage.clickShoppingCart();
        cartPage.clickContinueShoppingButton();
        assertEquals(productsPage.getTitle(), "Products", "переход на страницу не выполнен");
    }
}