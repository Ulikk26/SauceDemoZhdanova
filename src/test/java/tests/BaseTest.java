package tests;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.*;

import utils.AllureUtils;
import utils.PropertyReader;

import java.time.Duration;

@Log4j2
@Listeners(TestListener.class)
public class BaseTest {
    WebDriver driver;
    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    CheckoutOverviewPage checkoutOverviewPage;

    String user =System.getProperty("user", PropertyReader.getProperty("user"));
    String password =System.getProperty("password", PropertyReader.getProperty("password"));

    @Parameters({"browser"})
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser) {
        log.info("Open browser {}", browser);
        if(browser.equalsIgnoreCase("chrome")){
            ChromeOptions options = new ChromeOptions();
            options.addArguments("headless");
            options.addArguments("start-maximized");
            driver = new ChromeDriver(options);
        } else if(browser.equalsIgnoreCase("fireFox")){
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("headless");
            driver = new FirefoxDriver(options);

        }else if(browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
            EdgeOptions options =new EdgeOptions();
            options.addArguments("headless");
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage=new LoginPage(driver);
        productsPage=new ProductsPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        checkoutOverviewPage =new CheckoutOverviewPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void browserQuit(ITestResult result) {
        log.info("Close browser");
        if(ITestResult.FAILURE==result.getStatus()){
            AllureUtils.takeScreenshot(driver);
        }
        if(driver!=null) {
            driver.quit();
        }
    }
}
