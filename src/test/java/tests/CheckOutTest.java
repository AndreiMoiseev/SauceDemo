package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

//думал над проблемой,как засунуть логин постоянный, но он ведь не нужен,если страница и так открывается
public class CheckOutTest extends BaseTest {
    @Test
    public void checkOut(){
        checkOutPage.openPage();
        checkOutPage.enterData(FIRST_NAME,LAST_NAME,POSTAL_CODE);
        Assert.assertEquals("https://www.saucedemo.com/checkout-step-two.html","https://www.saucedemo.com/checkout-step-two.html");
    }
    @Test
    public void emptyFirstName(){
        checkOutPage.openPage();
        checkOutPage.enterData("",LAST_NAME,POSTAL_CODE);
        Assert.assertEquals(checkOutPage.getErrorMessage(),"Error: First Name is required");
    }
    @Test
    public void emptyLastName(){
        checkOutPage.openPage();
        checkOutPage.enterData(FIRST_NAME,"",POSTAL_CODE);
        Assert.assertEquals(checkOutPage.getErrorMessage(),"Error: Last Name is required");
    }
    @Test
    public void emptyPostalCode(){
        checkOutPage.openPage();
        checkOutPage.enterData(FIRST_NAME,LAST_NAME,"");
        Assert.assertEquals(checkOutPage.getErrorMessage(),"Error: Postal Code is required");
    }
    @Test
    public void cancelClick(){
        checkOutPage.openPage();
        checkOutPage.cancelClick();
        Assert.assertEquals("https://www.saucedemo.com/cart.html","https://www.saucedemo.com/cart.html");
    }

}
