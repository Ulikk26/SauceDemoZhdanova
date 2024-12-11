package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

@Log4j2
public class CartPage extends BasePage {

    private final By PRODUCTS_TITLE = By.cssSelector(".inventory_item_name");
    private final String PRICE_OF_PRODUCT = "//div[text() = '%s']//following::div[@class='inventory_item_price']";
    private final String DESCRIPTION_OF_PRODUCT = "//div[text() = '%s']//following::div[@class='inventory_item_desc']";
    private final By LIST_OF_PRODUCTS = By.xpath("//div[@data-test='inventory-item']");
    private final String REMOVE_BUTTON = "//div[text() = '%s']//following::button[text()='Remove']";
    private final By CONTINUE_SHOPPING_BUTTON = By.id("continue-shopping");
    private final By CHECKOUT_BUTTON = By.id("checkout");


    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Step("Проверка названия добавленного товара")
    public String getNameOfProduct() {
        log.info("Checking the name of the product");
        return driver.findElement(PRODUCTS_TITLE).getText();
    }

    @Step("Проверка цены добавленного товара")
    public String checkPrice(String product) {
        log.info("Checking the price of the product");
        By price = By.xpath(String.format(PRICE_OF_PRODUCT, product));
        return driver.findElement(price).getText();
    }

    @Step("Проверка описания добавленного товара")
    public String checkDescription(String product) {
        log.info("Checking the description of the product");
        By description = By.xpath(String.format(DESCRIPTION_OF_PRODUCT, product));
        return driver.findElement(description).getText();
    }

    @Step("Проверка количества добавленных товаров в корзину")
    public int checkCountOfProducts() {
        log.info("Checking count products into cart");
        List<WebElement> products = driver.findElements(LIST_OF_PRODUCTS);
        return products.size();
    }

    @Step("Удаление продукта из корзины")
    public void clickRemoveProduct(String product) {
        log.info("Removing the product from the cart");
        By remove = By.xpath(String.format(REMOVE_BUTTON, product));
        driver.findElement(remove).click();
    }

    @Step("Нажатие на кнопку CONTINUE")
    public void clickContinueShoppingButton() {
        log.info("Clicking the continue button");
        driver.findElement(CONTINUE_SHOPPING_BUTTON).click();
    }

    @Step("Нажатие на кнопку Checkout ")
    public void clickCheckoutButton() {
        log.info("Clicking the checkout button");
        driver.findElement(CHECKOUT_BUTTON).click();
    }
}
