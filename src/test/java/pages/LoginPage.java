package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class LoginPage extends BasePage {

    public static final By USERNAME_INPUT = By.id("user-name");
    public static final By PASSWORD_INPUT = By.id("password");
    public static final By LOGIN_BUTTON = By.id("login-button");
    public static final By ERROR_LABEL = By.cssSelector("[data-test=error]");

    public LoginPage(WebDriver driver){
        super(driver);
    }
    @Override
    public LoginPage isPageOpened(){
        //wait.until(ExpectedCondition.visibilityOfElementLocated(LOGIN_BUTTON));
        return this;
    }

    public LoginPage openPage(){
        driver.get("https://www.saucedemo.com/index.html");
        isPageOpened();
        return this;
    }

    public ProductsPage login(String username, String password){
        loginWithoutRedirect(username,password);
        return new ProductsPage(driver);
    }

    public LoginPage loginWithoutRedirect(String username, String password){
        driver.findElement(USERNAME_INPUT).sendKeys(username);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        return this;
    }
    public String getErrorMessage(){
        return driver.findElement(ERROR_LABEL).getText();
    }
}
