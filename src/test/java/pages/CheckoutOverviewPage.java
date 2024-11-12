package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage extends BasePage {

     private final By TITLE = By.cssSelector(".title");

    public CheckoutOverviewPage (WebDriver driver){
        super(driver);
    }

    public String getTitle() {
        return driver.findElement(TITLE).getText();
    }

}