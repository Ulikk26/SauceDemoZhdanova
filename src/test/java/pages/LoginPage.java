package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class LoginPage extends BasePage {

    private final By USER_INPUT = By.id("user-name");
    private final By PASSWORD_INPUT = By.id("password");
    private final By LOGIN_BUTTON = By.id("login-button");
    private final By ERROR_MASSAGE = By.xpath("//h3[@data-test='error']");
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие страницы логина")
    public void open() {
        log.info("Opening the login page");
        driver.get("https://www.saucedemo.com/");
    }

    @Step("Вход в систему с логином {user} и паролем {password}")
    public void login(String user, String password) {
        log.info("Login with user {} and password {}", user, password );
        driver.findElement(USER_INPUT).sendKeys(user);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
    }

    @Step("Получение сообщения об ошибке")
    public String getErrorMessage() {
        log.info("Getting the error message" );
        return driver.findElement(ERROR_MASSAGE).getText();
    }
}