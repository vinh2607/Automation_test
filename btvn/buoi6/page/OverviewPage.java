package nganttt.btvn.buoi6.page;

import nganttt.btvn.buoi6.common.BaseContst;
import nganttt.btvn.buoi6.common.BasePage;
import nganttt.btvn.buoi6.model.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import java.util.List;

public class OverviewPage extends BasePage {
    String finishXPath = getStringXPath(BaseContst.DYNAMIC_BUTTON_FORM, "finish");
    String headerTitleXPath = getStringXPath(BaseContst.DYNAMIC_TITLE_FORM, "Checkout: Overview");
    String itemTotalXPath = getStringXPath(BaseContst.DYNAMIC_OVERVIEWINFO_FORM, "summary_subtotal_label");
    String taxXPath = getStringXPath(BaseContst.DYNAMIC_OVERVIEWINFO_FORM, "summary_tax_label");
    String totalXPath = getStringXPath(BaseContst.DYNAMIC_OVERVIEWINFO_FORM, "summary_total_label");
    float tax = 0.08f;
    float sumPrice = 0;
    List<Product> listOverviewProduct = getListProduct();


    /**
     * Init a new instance
     *
     * @param webDriver : The WebDriver to interact with elements
     */
    public OverviewPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void isGoToOverViewPageSuccess() {
        waitUntilVisibleElement(headerTitleXPath);
        Assert.assertTrue(findElement(headerTitleXPath).isDisplayed());
    }

    public void checkCart() {
        List<Product> listOverviewProduct = getListProduct();
        Assert.assertEquals(listOverviewProduct, HomePage.listAddedProduct);
    }

    public void checkTotal() {
        Assert.assertEquals((float) Math.ceil(getItemTotalPrice() * 100) / 100, getMoney(itemTotalXPath));
        Assert.assertEquals((float) Math.ceil(getTaxt() * 100) / 100, getMoney(taxXPath));
        Assert.assertEquals((float) Math.ceil(getFinalTotalPrice() * 100) / 100, getMoney(totalXPath));
    }

    public float getItemTotalPrice() {
        for (int i = 0; i < listOverviewProduct.size(); i++) {
            sumPrice += listOverviewProduct.get(i).getPrice();
        }
        return sumPrice;
    }

    public float getTaxt() {
        return sumPrice * tax ;
    }

    public float getFinalTotalPrice() {
        return (sumPrice+getTaxt());
    }



    /**
     * Lấy số tiền trong element
     * @param xPath
     * @return
     */
    public float getMoney(String xPath) {
        String moneyInfo = findElement(xPath).getText();
        String[] moneyInfoArray = moneyInfo.split("\\$");
        String money = moneyInfoArray[1];
        return Float.valueOf(money);
    }

    public CompletePage finish(){
        scrollByVisibleElement(finishXPath);
        clickToElement(By.xpath(finishXPath));
        return new CompletePage(webDriver);
    }
}
