package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPage extends BasePage {

    public static final By FIRST_NAME_INPUT = By.id("first-name");
    public static final By LAST_NAME_INPUT = By.id("last-name");
    public static final By POSTAL_CODE = By.id("postal-code");
    public static final By CANCEL_BUTTON = By.cssSelector(".cart_cancel_link.btn_secondary");
    public static final By CONTINUE_BUTTON = By.cssSelector(".btn_primary.cart_button");
    public static final By ERROR_MESSAGE = By.cssSelector("[data-test=error]");


    public CheckOutPage(WebDriver driver){
        super(driver);
    }

    @Override
    public CheckOutPage isPageOpened() {
        return this;
    }

    public CheckOutPage openPage(){
        driver.get("https://www.saucedemo.com/checkout-step-one.html");
        return this;
    }

    // логинимся в тесте,заходим на страницу там же,методы уже есть. Тут описываем только саму страницу
    public void cancelClick(){
        driver.findElement(CANCEL_BUTTON).click();
    }
    public String getErrorMessage(){
        return driver.findElement(ERROR_MESSAGE).getText();
    }
    public void enterData(String fisrtname, String lastname,String postalcode){
        driver.findElement(FIRST_NAME_INPUT).sendKeys(fisrtname);
        driver.findElement(LAST_NAME_INPUT).sendKeys(lastname);
        driver.findElement(POSTAL_CODE).sendKeys(postalcode);
        driver.findElement(CONTINUE_BUTTON).click();
    }
}
