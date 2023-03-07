package nganttt.btvn.buoi6.page;

import nganttt.btvn.buoi6.common.BaseContst;
import nganttt.btvn.buoi6.common.BasePage;
import nganttt.btvn.buoi6.model.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.*;


public class HomePage extends BasePage {
    String headerTitleXPath = getStringXPath(BaseContst.DYNAMIC_TITLE_FORM, "Products");
    String selectContainerXPath = "//select[@class='product_sort_container']";
    String DYNAMIC_ITEM_REMOVE = "//div[@class='inventory_item'][%s]//button[text()='Remove']";
    String cartBadgeXPath = "//div[@class='shopping_cart_container']//span";
    public static List<Product> listAddedProduct = new ArrayList<>();

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
        List<Product> listProduct = getListProduct();
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
        List<Product> listProduct = getListProduct();
        //list price chua sap xep
        List<Float> priceProduct = new ArrayList<>();
        listProduct.forEach(product -> priceProduct.add(product.getPrice()));

        //list price da sap xep
        List<Float> sortedProductPrice = new ArrayList<>(priceProduct);
        Collections.sort(sortedProductPrice);
        if (!isAscending) Collections.reverse(sortedProductPrice);
        return sortedProductPrice.equals(priceProduct);
    }

    public void addRandomItemToCart() {
        List<Integer> listRandomNumber = new ArrayList<>();
        List<WebElement> addToCart = findElements(BaseContst.itemAddToCartXPath);
        List<Product> listProduct = getListProduct();

        //tạo list random number
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            int j = random.nextInt(addToCart.size());
            if (!listRandomNumber.contains(j)) {
                listRandomNumber.add(j);
            } else i--;
        }

        listRandomNumber.forEach(i -> {
            clickToElement(addToCart.get(i));
            String xPathRemove = getStringXPath(DYNAMIC_ITEM_REMOVE, String.valueOf(i + 1));
            Assert.assertTrue(findElement(xPathRemove).isDisplayed());
            listAddedProduct.add(listProduct.get(i));
        });

        waitUntilVisibleElement(cartBadgeXPath);
        Assert.assertEquals(findElement(cartBadgeXPath).getText(), String.valueOf(listRandomNumber.size()));

    }

    public YourCartPage goToYourCartPage() {
        clickToElement(By.xpath(BaseContst.cartContainer));
        return new YourCartPage(webDriver);
    }

}
