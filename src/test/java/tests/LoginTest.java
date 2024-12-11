package tests;

import jdk.jfr.Description;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Log4j2
public class LoginTest extends BaseTest {

    //запуск теста повторно при его падении retryAnalyzer = Retry.class
    @Test(testName = "Проверка позитивного логина", description = "Проверка позитивного логина", retryAnalyzer = Retry.class, priority = 4)
   @Description("Проверка позитивного логина")
    public void checkLogin() {
        log.info("Checking the login with valid login");
        loginPage.open();
        loginPage.login(user, password);
        assertEquals(
                productsPage.getTitle(),
                "Products",
                "переход на страницу не выполнен");
    }


    //тест временно отключён enabled = false
    @Test(testName = "Проверка ошибки, при пустом логине", description = "Проверка ошибки, при пустом логине", enabled = false, priority = 3)
    public void checkLoginEmptyUserName() {
        log.info("Checking the error message if the login field is empty");
        loginPage.open();
        loginPage.login("", "secret_sauce");
        String errorMassage = loginPage.getErrorMessage();
        assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username is required",
                "сообщение об ошибке неверное" );
    }

    //тест запуститься вторым по очередности priority = 2
    @Test(testName = "Проверка ошибки, при пустом пароля", description = "Проверка ошибки, при пустом пароля", priority = 2)
    @Description("Проверка отображения ошибки, при вводе пустого пароля")
    public void checkLoginEmptyPassword() {
        log.info("Checking the error message if password field is empty");
        loginPage.open();
        loginPage.login("standard_user", "");
        String errorMassage = loginPage.getErrorMessage();
        assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Password is required",
                "сообщение об ошибке неверное");
    }

    //тест запуститься первым по очередности priority = 1
    @Test(testName = "Проверка ошибки, при неверном логине", description = "Проверка ошибки, при неверном логине", priority = 1)
    public void checkLoginEmptyWrongUserName() {
        log.info("Checking the error message if login is invalid");
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user1");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        String title = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
        assertEquals(title, "Epic sadface: Username and password do not match any user in this service", "ошибка не верная");
    }

    @DataProvider(name = "LoginData")
    public Object[][] loginDta() {
        return new Object[][]{
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"standard_user", "", "Epic sadface: Password is required"},
                {"standard_user1", "secret_sauce", "Epic sadface: Username and password do not match any user in this service"},

        };
    }

    @Test(dataProvider = "LoginData")
    public void test(String user, String password, String expectedError) {
        log.info("Checking the error message");
        loginPage.open();
        loginPage.login(user, password);
        String errorMassage = loginPage.getErrorMessage();
        assertEquals(errorMassage,
                expectedError,
                "сообщение об ошибке неверное");
    }
}
