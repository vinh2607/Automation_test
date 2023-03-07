package nganttt.training;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static java.lang.Thread.sleep;

public class Day5 {
    WebDriver webDriver;
    String DYNAMIC_LOCATOR_GENDER = "//label[text()='%s']";
    String DYNAMIC_LOCATOR_INPUT = "//input[@placeholder='%s']";

    WebElement firstNameInput, lastNameInput, emailInput, mobileInput, maleCheckbox, femaleCheckbox, otherCheckbox;

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
        webDriver = new ChromeDriver();
        gotoWebsite("https://demoqa.com/automation-practice-form");
        webDriver.manage().window().maximize();
        firstNameInput = findElementByXPath(DYNAMIC_LOCATOR_INPUT, "First Name");
        lastNameInput = findElementByXPath(DYNAMIC_LOCATOR_INPUT, "Last Name");
        emailInput = findElementByXPath(DYNAMIC_LOCATOR_INPUT, "name@example.com");
        mobileInput = findElementByXPath(DYNAMIC_LOCATOR_INPUT, "Mobile Number");
        maleCheckbox = findElementByXPath(DYNAMIC_LOCATOR_GENDER, "Male");
        femaleCheckbox = findElementByXPath(DYNAMIC_LOCATOR_GENDER, "Female");
        otherCheckbox = findElementByXPath(DYNAMIC_LOCATOR_GENDER, "Other");
    }

    @Test(priority = 1)
    public void infoNgan() {

        sendKeysToElement(firstNameInput, "Ngan");
        sendKeysToElement(lastNameInput, "Truong");
        sendKeysToElement(emailInput, "A@gmail.com");
        maleCheckbox.click();
        sendKeysToElement(mobileInput, "0333333333");
    }

    @Test(priority = 2)
    public void infoNgoc() {

        sendKeysToElement(firstNameInput, "Ngoc");
        sendKeysToElement(lastNameInput, "Nguyen");
        sendKeysToElement(emailInput, "Abc@gmail.com");
        femaleCheckbox.click();
        sendKeysToElement(mobileInput, "0400000000");
    }


    @Test
    public void TC_03_Table() {
        gotoWebsite("https://demoqa.com/webtables");
        /**
         * TABLE
         *
         * Lấy toàn bộ table và lưu trữ bảng này bằng biến có tên ‘htmltable’
         *
         * Lấy tất cả các hàng có thẻ là ‘tr’ và lưu trữ tất cả các phần tử này vào trong 1 list có tên là ‘rows’
         *
         * Lặp qua từng hàng và lấy danh sách các phần tử có thẻ ‘th’. Lệnh 'rows.get(0)’ sẽ get hàng đầu tiên và
         * ‘findElements(By.tagName(“th”))’ sẽ get danh sách các cột của hàng này.
         *
         * Lặp lại bằng cách sử dụng lệnh ‘columns.getsize()’ và get chi tiết của từng ô (tất cả các cô của hàng đang duyệt).
         */
        WebElement htmltable = webDriver.findElement(By.xpath("//div[@class='rt-table']"));
        List<WebElement> rows = htmltable.findElements(By.xpath("//div[@role='rowgroup']/child::div"));
        System.out.println("Number of rows:" + rows.size());

        for (WebElement row : rows) {
            System.out.println(row.getText());

            List<WebElement> columns = row.findElements(By.xpath("div[@role='gridcell']"));
            System.out.println("Number of columns:" + columns.size());

            for (int cnum = 1; cnum < columns.size(); cnum++) {
                System.out.print(columns.get(cnum).getText());
            }
    }

}

    public void sendKeysToElement(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
        Assert.assertEquals(element.getAttribute("value"), value);
    }

    public void gotoWebsite(String url) {
        webDriver.get(url);
        webDriver.manage().window().maximize();
        waitUntilVisibleElement(webDriver, "//*[@src='/images/Toolsqa.jpg']");
    }

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

    public WebElement findElementByXPath(String format, String... values) {
        By xPath = By.xpath(String.format(format, values));
        try {
            return webDriver.findElement(xPath);
        } catch (Exception e) {
            System.out.println("Element not found");
            return null;
        }
    }

    @AfterClass
    public void afterClass() {
        webDriver.quit();
    }
}
