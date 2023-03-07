package nganttt.btvn.buoi8.common;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {
    protected WebDriver webDriver;
    protected WebDriverWait webDriverWait;

    /**
     * Init a new instance
     *
     * @param webDriver : The WebDriver to interact with elements
     */
    protected BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(10), Duration.ofMillis(100));
    }

    /**
     * Finding element
     *
     * @param selector : WebElement / By / xPath
     */
    protected WebElement findElement(Object selector) {
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
    protected List<WebElement> findElements(Object selector) {
        List<WebElement> webElements;
        if (selector instanceof String) {
            webElements = webDriver.findElements(By.xpath(String.valueOf(selector)));
        } else if (selector instanceof By) {
            webElements = webDriver.findElements((By) selector);
        } else {
            throw new RuntimeException("Your selector is invalid, you only use String, or By object");
        }
        return webElements;
    }

    /**
     * Get Element
     *
     * @param selector : WebElement hoặc By
     */
    protected WebElement getElement(Object selector) {
        WebElement element;
        if (selector instanceof WebElement) element = (WebElement) selector;
        else if (selector instanceof By) element = webDriver.findElement((By) selector);
        else throw new RuntimeException("Your selector is invalid, you only use WebElement,  By object");
        return element;
    }

    protected String getStringXPath(String format, String... values) {
        return String.format(format, values);
    }

    /**
     *  wait until visible element
     * @param selector : WebElement hoặc By
     */
    protected void waitUntilVisibleElement(Object selector) {
        WebElement element;
        element = findElement(selector);
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitUntilClickableElement(Object selector) {
        WebElement element;
        element = findElement(selector);
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Click element with By/WebElement object
     *
     * @param selector
     */
    protected void clickToElement(Object selector) {
        WebElement element = findElement(selector);
        waitUntilClickableElement(selector);
        element.click();
    }

    /**
     * @param selector
     * @param value
     */
    protected void inputText(Object selector, String value) {
        if (selector == null){
            throw new RuntimeException("Selector invalid ");
        }
        if (value == null){
            throw new RuntimeException("Value input null");
        }
        WebElement element = findElement(selector);
        waitUntilVisibleElement(element);
        element.clear();
        element.sendKeys(value);
    }
    /**
     * @param selector
     * @param path, filename
     */
    protected void inputFile(Object selector, String path, String fileName) {
        if (selector == null){
            throw new RuntimeException("Selector invalid ");
        }
        WebElement element = findElement(selector);
        waitUntilVisibleElement(element);
        if (fileName!=""){
            try {
                element.sendKeys(path+fileName);
            } catch (Exception e) {
                System.err.printf("File not found");
            }
        }

    }

    /**
     * Input text voi cac truong text co kieu type dynamically
     *
     * @param title
     * @param text
     */
    protected void inputTextWithType(String type, String title, String text) {
        if(text!="") {
            String xpath = String.format(type, title);
            WebElement element = findElement(xpath);
            waitUntilVisibleElement(element);
            inputText(element, text);
        }
    }

    /**
     * Click voi cac truong co kieu type dynamically
     *
     * @param title
     */
    protected void clickWithType(String type, String title) {
        if (title!="") {
            String xpath = String.format(type, title);
            WebElement element = findElement(xpath);
            waitUntilVisibleElement(element);
            waitUntilClickableElement(element);
            clickToElement(element);
        }
    }

    protected void enterTextToInputDropdown(String idInput, String value) {
        if (value!="") {
            String xPathInput = getStringXPath(BaseConst.DYNAMIC_INPUT_TEXT_ID_FORM, idInput);
            WebElement element = findElement(xPathInput);
            waitUntilVisibleElement(element);
            element.sendKeys(value);
            element.sendKeys(Keys.ENTER);
        }
    }

    protected void selectItemInDropdown(Object selector, String itemText) {
        Select select = new Select(findElement(selector));
        select.selectByVisibleText(itemText);
    }

    protected void scrollByVisibleElement(String xPath) {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        WebElement element = webDriver.findElement(By.xpath(xPath));
        js.executeScript("arguments[0].scrollIntoView();", element);
    }
    protected void clickElementByJS(String xPath) {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        WebElement element = webDriver.findElement(By.xpath(xPath));
        js.executeScript("arguments[0].click();", element);
    }
}
