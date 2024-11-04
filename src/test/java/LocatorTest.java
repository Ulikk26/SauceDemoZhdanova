import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LocatorTest extends BaseTest{


    @Test
    public void locatorTest() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("login-button"));
        driver.findElement(By.name(("password")));
        driver.findElement(By.className("login_logo"));
//        driver.findElement(By.tagName(input['Username']));



    }
}
