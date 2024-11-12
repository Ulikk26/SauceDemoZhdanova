package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    public void checkLogin(){
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertEquals(
                productsPage.getTitle(),
                "Products",
                "переход на страницу не выполнен");
    }

    @Test
    public void checkLoginEmptyUserName(){
        loginPage.open();
        loginPage.login("", "secret_sauce");
        String errorMassage = loginPage.getErrorMessage();
        assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username is required",
                "сообщение об ошибке неверное"
        );
    }

    @Test
    public void checkLoginEmptyPassword(){
        loginPage.open();
        loginPage.login("standard_user", "");
        String errorMassage = loginPage.getErrorMessage();
        assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Password is required",
                "сообщение об ошибке неверное");
    }

    @Test
    public void checkLoginEmptyWrongUserName(){
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user1");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        boolean title= driver.findElement(By.xpath("//h3[text()='Epic sadface: Username and password do not match any user in this service']")).isDisplayed();
        assertTrue(title,"сообщение об ошибке неверное");
    }

}
