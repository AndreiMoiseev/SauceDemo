package tests;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;

public class LoginTest extends BaseTest {

    @Test(description = "тест на логин")
    @Description("РАсширенное описание")
    public void loginTest() {
            ProductsPage actualMessage = loginPage
                    .openPage()
                    .login(USERNAME,PASSWORD)
                    .addProduct("Sauce Labs Fleece Jacket");
       // Assert.assertEquals(actualMessage, "Sauce Labs Fleece Jacket");
        }

    @Test
    public void emptyPasswordTest() {
        String actualMessage = loginPage
                .openPage()
                .loginWithoutRedirect(USERNAME, "")
                .getErrorMessage();
        Assert.assertEquals(actualMessage, "Epic sadface: Password is required");
    }

    @Test
    public void emptyLoginTest() {
        String actualMessage = loginPage
                .loginWithoutRedirect("", PASSWORD)
                .getErrorMessage();
        Assert.assertEquals(actualMessage, "Epic sadface: Username is required");

    }

    @Test
    public void emptyPasswordLoginTest() {
        String actualMessage = loginPage
                .openPage()
                .loginWithoutRedirect("123", "123")
                .getErrorMessage();
        Assert.assertEquals(actualMessage, "Epic sadface: Username and password do not match any user in this service");

    }


}
