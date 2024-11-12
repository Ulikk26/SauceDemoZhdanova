package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;

import java.time.Duration;

public class BaseTest {
    WebDriver driver;
    LoginPage loginPage;
    ProductsPage productsPage;
    YourCart yourCart;
    CheckoutPage checkoutPage;
    CheckoutOverviewPage checkoutOverviewPage;

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maxinized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        loginPage=new LoginPage(driver);
        productsPage=new ProductsPage(driver);
        yourCart = new YourCart(driver);
        checkoutPage = new CheckoutPage(driver);
        checkoutOverviewPage =new CheckoutOverviewPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void browserQuit() {
        driver.quit();
    }
}
