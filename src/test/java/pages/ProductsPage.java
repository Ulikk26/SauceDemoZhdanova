package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class ProductsPage extends BasePage {

    private final By TITLE = By.cssSelector(".title");
    private final By CART_LINK = By.cssSelector(".shopping_cart_link");
    private final String ADD_TO_CART_PATTERN = "//div[text() = '%s']/ancestor::div[@class = 'inventory_item']//button";

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        log.info("Checking the name of page");
        return driver.findElement(TITLE).getText();
    }

    public void clickAddButton(String product) {
        log.info("Clicking the add button");
        By addToCart = By.xpath(String.format((ADD_TO_CART_PATTERN), product));
        driver.findElement(addToCart).click();
    }

    public void clickShoppingCart() {
        log.info("Clicking the shopping cart button");
        driver.findElement(CART_LINK).click();
    }
}