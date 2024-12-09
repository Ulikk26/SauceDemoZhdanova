package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.*;
import pages.utils.AllureUtils;

import java.time.Duration;

@Listeners(TestListener.class)
public class BaseTest {
    WebDriver driver;
    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    CheckoutOverviewPage checkoutOverviewPage;
    ChromeOptions options = new ChromeOptions();
    @Parameters({"browser"})
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser) {
        if(browser.equalsIgnoreCase("chrome")){
            options.addArguments("headless");
            options.addArguments("start-maximized");
            driver = new ChromeDriver(options);
        } else if(browser.equalsIgnoreCase("fireFox")){
            driver = new FirefoxDriver();
            options.addArguments("headless");

        }else if(browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
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
        if(ITestResult.FAILURE==result.getStatus()){
            AllureUtils.takeScreenshot(driver);
        }
        if(driver!=null) {
            driver.quit();
        }
    }
}
