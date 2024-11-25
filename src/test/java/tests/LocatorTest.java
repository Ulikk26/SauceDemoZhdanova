package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LocatorTest extends BaseTest {

    @Test
    public void locatorTest() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("login-button"));
        driver.findElement(By.name(("password")));
        driver.findElement(By.className("login_logo"));
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.tagName("img"));
        driver.findElement(By.linkText("LinkedIn"));
        driver.findElement(By.linkText("LinkedIn"));
        driver.findElement(By.partialLinkText("Face"));
        driver.findElement(By.xpath("//a[@data-test='shopping-cart-link']"));
        driver.findElement(By.xpath("//span[text()='Products']"));
        driver.findElement(By.xpath("//div[contains (@data-test, 'inventory-item')]"));
        driver.findElement(By.xpath("//div[contains (text(), 'carry.allTheThings()')]"));
        driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']/" +
                "ancestor::div[@class='inventory_item']//div[@data-test='inventory-item-price']"));
        driver.findElement(By.xpath("//div[@data-test='secondary-header']//descendant::span[@class='select_container']"));
        driver.findElement(By.xpath("//li[@class='social_facebook']/following::li/a"));
        driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']//parent::div"));
        driver.findElement(By.xpath("//span[text()='Products']/preceding::nav"));
        driver.findElement(By.xpath("//span[@class='active_option' and @data-test='active-option']"));
        driver.findElement(By.cssSelector(".product_sort_container"));
        driver.findElement(By.cssSelector(".primary_header .header_label"));
        driver.findElement(By.id("inventory_sidebar_link"));
        driver.findElement(By.tagName("noscript"));
        driver.findElement(By.cssSelector("li.social_linkedin"));
        driver.findElement(By.cssSelector("[class=footer_copy]"));
        driver.findElement(By.cssSelector("[alt~=Fleece]"));
        driver.findElement(By.cssSelector("[data-test|=social]")); //полное совпадение либо начинается с этого и далее дефис
        driver.findElement(By.cssSelector("[href^='https://www.facebook']")); //начинается с этого значения
        driver.findElement(By.cssSelector("[href$='sauce-labs/']")); //заканчивается  значением
        driver.findElement(By.cssSelector("[href*='company']")); //содержит значение
    }
}
