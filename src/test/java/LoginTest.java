import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    public void checkLogin(){
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        String title= driver.findElement(By.cssSelector(".title")).getText();
        assertEquals(title, "Products", "переход на страницу не выполнен");
    }

    @Test
    public void checkLoginEmptyUserName(){
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        boolean title= driver.findElement(By.xpath("//h3[text()='Epic sadface: Username is required']")).isDisplayed();
        assertTrue(title,"не появилась ошибка");
    }

    @Test
    public void checkLoginEmptyPassword(){
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("");
        driver.findElement(By.id("login-button")).click();
        boolean title= driver.findElement(By.xpath("//h3[text()='Epic sadface: Password is required']")).isDisplayed();
        assertTrue(title,"не появилась ошибка");
    }

    @Test
    public void checkLoginEmptyWrongUserName(){
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user1");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        boolean title= driver.findElement(By.xpath("//h3[text()='Epic sadface: Username and password do not match any user in this service']")).isDisplayed();
        assertTrue(title,"не появилась ошибка");
    }
}
