package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ProductsPage extends BasePage{
    String productLocator = "//*[contains(text(),'%s')]/ancestor::div[@class='inventory_item']//*[text()='ADD TO CART']";
    //*[contains(text(),'Sauce Labs Fleece Jacket')]/ancestor:://*[contains(text(),'ADD TO CART')]
    //public static final By SORTING_BUTTON =
    public ProductsPage (WebDriver driver){
        super(driver);
    }

    public ProductsPage addProduct(String productName){
        driver.findElement(By.xpath(String.format(productLocator,productName))).click();
        return this;
    }
    public ProductsPage isPageOpened() {
        Assert.assertTrue(driver.findElement(SORTING_BUTTON).isDisplayed());
    }
    @Override
    public ProductsPage openPage(){
        driver.get("");
        return this;
    }
    public CartPage goToCart(){
        driver.findElement(By.xpath("")).click();
        return new CartPage();
    }

}
