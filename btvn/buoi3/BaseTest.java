package nganttt.btvn.buoi3;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static java.lang.Thread.sleep;

public class BaseTest {
    /**
     * Sleep for debugging
     *
     * @param milliseconds : number of milliseconds
     */
    protected void waitForDebug(long milliseconds) {
        try {
            sleep(milliseconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    protected void waitUntilVisibleElement(WebDriver webDriver, String xPath) {
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)));
    }
    /**
     * Go to Guru99 Website
     */
    public void gotoGuruWebsite(WebDriver webDriver) {
        String url = "https://demo.guru99.com";
        webDriver.get(url);
        webDriver.manage().window().maximize();
        waitUntilVisibleElement(webDriver, "//img[@src='/logo.png']");
    }

    public String getStringXPath(String format, String... values) {
        return String.format(format, values);
    }

    public void sendKeysToElement(WebElement element, String value) {
        element.sendKeys(value);
        Assert.assertEquals(element.getAttribute("value"), value);
    }

    public WebElement findElementByXPath(WebDriver webDriver,String format, String... values) {
        By xPath = By.xpath(getStringXPath(format, values));
        try {
            return webDriver.findElement(xPath);
        } catch (Exception e) {
            System.out.println("Element not found");
            return null;
        }
    }
    public void scrollByVisibleElement(WebDriver webDriver, String xPath) {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        WebElement element = webDriver.findElement(By.xpath(xPath));
        js.executeScript("arguments[0].scrollIntoView();", element);
    }
    public void clickToElement(WebElement element) {
        element.click();
    }

}
