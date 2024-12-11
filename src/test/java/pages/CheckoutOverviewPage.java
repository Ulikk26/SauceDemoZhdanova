package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class CheckoutOverviewPage extends BasePage {

    private final By TITLE = By.cssSelector(".title");

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    @Step("Проверка названия страницы")
    public String getTitle() {
        log.info("Checking the name of page");
        return driver.findElement(TITLE).getText();
    }
}