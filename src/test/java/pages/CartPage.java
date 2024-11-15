package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

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

    public String getNameOfProduct() {
        return driver.findElement(PRODUCTS_TITLE).getText();
    }

    public String checkPrice(String product) {
        By price = By.xpath(String.format(PRICE_OF_PRODUCT, product));
        return driver.findElement(price).getText();
    }

    public String checkDescription(String product) {
        By description = By.xpath(String.format(DESCRIPTION_OF_PRODUCT, product));
        return driver.findElement(description).getText();
    }

    public int checkCountOfProducts() {
        List<WebElement> products = driver.findElements(LIST_OF_PRODUCTS);
        return products.size();
    }

    public void clickRemoveProduct(String product) {
        By remove = By.xpath(String.format(REMOVE_BUTTON, product));
        driver.findElement(remove).click();
    }

    public void clickContinueShoppingButton() {
        driver.findElement(CONTINUE_SHOPPING_BUTTON).click();
    }

    public void clickCheckoutButton() {
        driver.findElement(CHECKOUT_BUTTON).click();
    }
}
