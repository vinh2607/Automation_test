package nganttt.btvn.buoi6.page;

import nganttt.btvn.buoi6.common.BaseContst;
import nganttt.btvn.buoi6.common.BasePage;
import nganttt.btvn.buoi6.model.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import java.util.List;

public class YourCartPage extends BasePage {
    String headerTitleXPath = getStringXPath(BaseContst.DYNAMIC_TITLE_FORM, "Your Cart");
    String checkOutXPath = getStringXPath(BaseContst.DYNAMIC_BUTTON_FORM, "checkout");
    List<Product> listCartProduct = getListProduct();
    /**
     * Init a new instance
     *
     * @param webDriver : The WebDriver to interact with elements
     */
    public YourCartPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void isGoToCartPageSuccess() {
        waitUntilVisibleElement(headerTitleXPath);
        Assert.assertTrue(findElement(headerTitleXPath).isDisplayed());
    }

    public void checkCart(){
        Assert.assertEquals(listCartProduct, HomePage.listAddedProduct);
    }

    public YourInfomationPage checkOut(){
        scrollByVisibleElement(checkOutXPath);
        clickToElement(By.xpath(checkOutXPath));
        return new YourInfomationPage(webDriver);
    }

}
