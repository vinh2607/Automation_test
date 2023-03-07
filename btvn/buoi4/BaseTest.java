package nganttt.btvn.buoi4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)));
    }

    public void gotoWebsite(WebDriver webDriver, String url) {
        webDriver.get(url);
        webDriver.manage().window().maximize();
        waitUntilVisibleElement(webDriver, "//*[@src='/images/Toolsqa.jpg']");
    }

    public String getStringXPath(String format, String... values) {
        return String.format(format, values);
    }

    public WebElement findElementByXPath(WebDriver webDriver, String format, String... values) {
        By xPath = By.xpath(getStringXPath(format, values));
        try {
            return webDriver.findElement(xPath);
        } catch (Exception e) {
            System.out.println("Element not found");
            return null;
        }
    }

}
