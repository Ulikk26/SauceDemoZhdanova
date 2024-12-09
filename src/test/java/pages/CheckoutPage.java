package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

    private final By FIRST_NAME_INPUT = By.id("first-name");
    private final By LAST_NAME_INPUT = By.id("last-name");
    private final By POSTAL_CODE_INPUT = By.id("postal-code");
    private final By CONTINUE_BUTTON = By.id("continue");
    private final By ERROR_MASSAGE = By.xpath("//h3[@data-test='error']");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @Step("Ввод данных '{firstName}' в поле First name")
    public void enterFirstName(String firstName) {
        driver.findElement(FIRST_NAME_INPUT).sendKeys(firstName);
    }

    @Step("Ввод данных '{lastName}' в поле Last name")
    public void enterLastName(String lastName) {
        driver.findElement(LAST_NAME_INPUT).sendKeys(lastName);
    }

    @Step("Ввод данных '{postalCode}' в поле Postal code")
    public void enterPostalCode(String postalCode) {
        driver.findElement(POSTAL_CODE_INPUT).sendKeys(postalCode);
    }

    @Step("Нажатие на кнопку Continue")
    public void clickContinueButton() {
        driver.findElement(CONTINUE_BUTTON).click();
    }

    @Step("Получение сообщения об ошибке")
    public String getErrorMassage() {
        return driver.findElement(ERROR_MASSAGE).getText();
    }
}