package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestListener;
import org.testng.annotations.*;
import pages.*;

import java.time.Duration;


public class BaseTest {
    WebDriver driver;
    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    CheckoutOverviewPage checkoutOverviewPage;

    @Parameters({"browser"})
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser) {
        if(browser.equalsIgnoreCase("chrome")){
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            driver = new ChromeDriver(options);
        } else if(browser.equalsIgnoreCase("fireFox")){
            driver = new FirefoxDriver();
        }else if(browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        loginPage=new LoginPage(driver);
        productsPage=new ProductsPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        checkoutOverviewPage =new CheckoutOverviewPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void browserQuit() {
        driver.quit();
    }
}
