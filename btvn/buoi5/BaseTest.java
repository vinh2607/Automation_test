package nganttt.btvn.buoi5;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)));
    }

    protected void gotoWebsite(WebDriver webDriver, String url) {
        webDriver.get(url);
        webDriver.manage().window().maximize();
        waitUntilVisibleElement(webDriver, "//a[@class='tiki-logo']");
    }

    protected WebElement findElementByDynamicLocator(WebDriver webDriver, String format, String... values) {
        By xPath = By.xpath(String.format(format, values));
        try {
            return webDriver.findElement(xPath);
        } catch (Exception e) {
            System.out.println("Element not found");
            return null;
        }
    }

    protected WebElement findElementByXPath(WebDriver webDriver, String xPath){
        return webDriver.findElement(By.xpath(xPath));
    }

    protected void clickToElement(WebDriver webDriver,String xPath ) {
        WebElement element = webDriver.findElement(By.xpath(xPath));
        element.click();
    }

    protected void scrollByVisibleElement(WebDriver webDriver, String xPath) {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        WebElement element = webDriver.findElement(By.xpath(xPath));
        js.executeScript("arguments[0].scrollIntoView();", element);
    }


}
