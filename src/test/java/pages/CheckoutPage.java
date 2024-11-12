package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends  BasePage{

    private  final By FIRST_NAME_INPUT = By.id("first-name");
    private  final By LAST_NAME_INPUT = By.id("last-name");
    private  final By POSTAL_CODE_INPUT = By.id("postal-code");
    private  final By CONTINUE_BUTTON = By.id("continue");
    private  final By ERROR_MASSAGE = By.xpath("//h3[@data-test='error']");

    public CheckoutPage(WebDriver driver){
        super(driver);
    }

    public  void enterFirstName (String firstName){
        driver.findElement(FIRST_NAME_INPUT).sendKeys(firstName);
    }

    public  void enterLastName (String lastName){
        driver.findElement(LAST_NAME_INPUT).sendKeys(lastName);
    }

    public  void enterPostalCode (String postalCode){
        driver.findElement(POSTAL_CODE_INPUT).sendKeys(postalCode);
    }

    public void clickContinueButton (){
        driver.findElement(CONTINUE_BUTTON).click();
    }

    public  String   getErrorMassage(){
        return driver.findElement(ERROR_MASSAGE).getText();
    }

}