package nganttt.btvn.buoi7.common;

import nganttt.btvn.buoi7.model.ProductModel;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BasePage {
    protected WebDriver webDriver;
    protected WebDriverWait webDriverWait;

    public void gotoLoginPage() {
        webDriver.get(BaseContst.URL);
        webDriver.manage().window().maximize();
    }

    /**
     * Init a new instance
     *
     * @param webDriver : The WebDriver to interact with elements
     */
    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(10), Duration.ofMillis(100));
    }

    /**
     * Finding element
     *
     * @param selector : WebElement / By / xPath
     */
    public WebElement findElement(Object selector) {
        WebElement element;
        if (selector instanceof WebElement) element = (WebElement) selector;
        else if (selector instanceof String) {
            element = webDriver.findElement(By.xpath(String.valueOf(selector)));
        } else if (selector instanceof By) {
            element = webDriver.findElement((By) selector);
        } else {
            throw new RuntimeException("Your selector is invalid, you only user String, By or WebElement object");
        }
        return element;
    }

    /**
     * Finding elements
     *
     * @param selector :  By / xPath
     */
    public List<WebElement> findElements(Object selector) {
        List<WebElement> webElements;
        if (selector instanceof String) {
            webElements = webDriver.findElements(By.xpath(String.valueOf(selector)));
        } else if (selector instanceof By) {
            webElements = webDriver.findElements((By) selector);
        } else {
            throw new RuntimeException("Your selector is invalid, you only user String, By or WebElement object");
        }
        return webElements;
    }

    /**
     * Get Element
     *
     * @param selector : WebElement hoặc By
     */
    public WebElement getElement(Object selector) {
        WebElement element;
        if (selector instanceof WebElement) element = (WebElement) selector;
        else if (selector instanceof By) element = webDriver.findElement((By) selector);
        else throw new RuntimeException("Your object should be a WebElement or a by object");
        return element;
    }

    public String getStringXPath(String format, String... values) {
        return String.format(format, values);
    }

    protected void waitUntilVisibleElement(Object selector) {
        WebElement element;
        element = findElement(selector);
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Click element with By/WebElement object
     *
     * @param selector
     */
    public void clickToElement(Object selector) {
        if (selector == null){
            throw new RuntimeException("Locator invalid");
        }
        // TODO: 12/01/2023 : Cast and verify element
        WebElement element = getElement(selector);
        element.click();
    }

    /**
     * @param selector
     * @param value
     */
    public void inputText(Object selector, String value) {
        if (selector == null){
            throw new RuntimeException("Selector invalid ");
        }
        if (value == null){
            throw new RuntimeException("Value input null");
        }
        // TODO: 12/01/2023 : Verify element
        WebElement element = getElement(selector);
        element.clear();
        element.sendKeys(value);
    }

    /**
     * Input text voi cac truong text co kieu type dynamically
     *
     * @param title
     * @param text
     */
    public void inputTextWithType(String type, String title, String text) {
        String xpath = String.format(type, title);
        WebElement element = findElement(xpath);
        inputText(element, text);
    }

    public void selectItemInDropdown(Object selector, String itemText) {
        Select select = new Select(findElement(selector));
        select.selectByVisibleText(itemText);
    }

    protected void scrollByVisibleElement(String xPath) {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        WebElement element = webDriver.findElement(By.xpath(xPath));
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public List<ProductModel> getListProduct() {
        List<ProductModel> listProduct = new ArrayList<>();

        //list tat ca name
        List<WebElement> elementName = findElements(BaseContst.itemNameXPath);
        List<String> listName = new ArrayList<>();
        elementName.forEach(element -> listName.add(element.getText()));

        //list tat ca gia
        List<WebElement> elementPrice = findElements(BaseContst.itemPriceXPath);
        List<String> listPrice = new ArrayList<>();
        elementPrice.forEach(element -> listPrice.add(element.getText()));

        for (int i = 0; i < elementName.size(); i++) {
            listProduct.add(new ProductModel(listName.get(i), listPrice.get(i)));
        }

        return listProduct;
    }

}
