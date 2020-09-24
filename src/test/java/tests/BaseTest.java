package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.CheckOutPage;
import pages.LoginPage;
import pages.LoginPageFactory;
import pages.ProductsPage;
import utils.CapabilitiesGenerator;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    public static final String USERNAME = "standard_user";
    public static final String PASSWORD = "secret_sauce";
    public static final String FIRST_NAME = "Andrei";
    public static final String LAST_NAME = "Moiseew";
    public static final String POSTAL_CODE = "3228";

    WebDriver driver;
    LoginPage loginPage;
    ProductsPage productsPage;
    CheckOutPage checkOutPage;

    @BeforeMethod
    public void StartTest() {
        driver = new ChromeDriver(CapabilitiesGenerator.getChromeOptions());
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        checkOutPage = new CheckOutPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser(){
        driver.close();
    }
}
