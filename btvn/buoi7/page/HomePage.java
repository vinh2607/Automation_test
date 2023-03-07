package nganttt.btvn.buoi7.page;

import nganttt.btvn.buoi7.common.BaseContst;
import nganttt.btvn.buoi7.common.BasePage;
import nganttt.btvn.buoi7.model.ProductModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class HomePage extends BasePage {
    String headerTitleXPath = getStringXPath(BaseContst.DYNAMIC_TITLE_FORM, "Products");
    String selectContainerXPath = "//select[@class='product_sort_container']";
    String cartBadgeXPath = "//div[@class='shopping_cart_container']//span";
    public static List<ProductModel> listAddedProduct = new ArrayList<>();

    /**
     * Init a new instance
     *
     * @param webDriver : The WebDriver to interact with elements
     */
    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void isLoginSuccess() {
        waitUntilVisibleElement(headerTitleXPath);
        Assert.assertTrue(findElement(headerTitleXPath).isDisplayed());
    }

    public void selectByValue(String itemValue) {
        selectItemInDropdown(selectContainerXPath, itemValue);
    }

    /**
     * Check sắp xếp theo tên của sản phẩm
     *
     * @param isAscending xếp từ thấp lên cao
     * @return
     * @return
     */
    public boolean isSortedByName(boolean isAscending) {
        List<ProductModel> listProduct = getListProduct();
        //list name chua sap xep
        List<String> nameProducts = new ArrayList<>();
        listProduct.forEach(product -> nameProducts.add(product.getName()));

        //list name da sap xep
        List<String> sortedNameProducts = new ArrayList<>(nameProducts);
        Collections.sort(sortedNameProducts);
        if (!isAscending) Collections.reverse(sortedNameProducts);
        return sortedNameProducts.equals(nameProducts);
    }

    /**
     * Check sắp xếp theo giá của sản phẩm

     * @param isAscending xếp từ thấp lên cao
     * @return
     */
    public boolean isSortedByPrice(boolean isAscending) {
        List<ProductModel> listProduct = getListProduct();
        //list price chua sap xep
        List<Float> priceProduct = new ArrayList<>();
        listProduct.forEach(product -> priceProduct.add(Float.valueOf(product.getPrice().replace("$",""))));

        //list price da sap xep
        List<Float> sortedProductPrice = new ArrayList<>(priceProduct);
        Collections.sort(sortedProductPrice);
        if (!isAscending) Collections.reverse(sortedProductPrice);
        return sortedProductPrice.equals(priceProduct);
    }

    public void addItemToCart(String name, String price) {
        String xPathButtonActionToCart = getStringXPath(BaseContst.DYNAMIC_BUTTON_ACTION_FORM, name);
        scrollByVisibleElement(xPathButtonActionToCart);
        WebElement buttonActionToCart = findElement(xPathButtonActionToCart);

        clickToElement(buttonActionToCart);
        listAddedProduct.add(new ProductModel(name, price));
        xPathButtonActionToCart = getStringXPath(BaseContst.DYNAMIC_BUTTON_ACTION_FORM, name);
       buttonActionToCart = findElement(xPathButtonActionToCart);
        Assert.assertEquals(buttonActionToCart.getText(),"REMOVE");

        waitUntilVisibleElement(cartBadgeXPath);
        Assert.assertEquals(findElement(cartBadgeXPath).getText(), String.valueOf(listAddedProduct.size()));

    }

    public YourCartPage goToYourCartPage() {
        clickToElement(By.xpath(BaseContst.cartContainer));
        return new YourCartPage(webDriver);
    }

}
