package nganttt.btvn.buoi4;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

import static java.lang.Thread.sleep;

public class BTVN04 extends BaseTest {
    WebDriver webDriver;

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
        webDriver = new ChromeDriver();
    }

    /**
     * Tìm locator của tooltip trong page https://demoqa.com/tool-tips
     */
    @Test
    public void TC_01_Locator_Tooltip() {
        gotoWebsite(webDriver, "https://demoqa.com/tool-tips");
        webDriver.manage().window().maximize();

        WebElement button = webDriver.findElement(By.xpath("//button[text()='Hover me to see']"));
        Assert.assertEquals(getToolTipText(button), "You hovered over the Button");

        WebElement textField = webDriver.findElement(By.xpath("//input[@placeholder='Hover me to see']"));
        Assert.assertEquals(getToolTipText(textField), "You hovered over the text field");

        WebElement contrary = webDriver.findElement(By.xpath("//a[text()='Contrary']"));
        Assert.assertEquals(getToolTipText(contrary), "You hovered over the Contrary");

        WebElement sections = webDriver.findElement(By.xpath("//a[text()='1.10.32']"));
        Assert.assertEquals(getToolTipText(sections), "You hovered over the 1.10.32");

    }

    /**
     * Tìm locator của 1 item khi xổ combobox Select one trong page https://demoqa.com/select-menu
     */
    @Test
    public void TC_02_Locator_Item_ComboBox() {
        gotoWebsite(webDriver, "https://demoqa.com/select-menu");
        webDriver.manage().window().maximize();

        WebElement button = webDriver.findElement(By.xpath("//div[text()='Select Title']/../following::div"));
        button.click();

        //lay item khi xo combo box
        WebElement item1 = webDriver.findElement(By.xpath("//div[text()='Select One']//following::div[@tabindex='-1'][1]"));
    }


    /**
     * Lấy text của tooltip tuong ứng với element, khi truyền vào element
     * @param element
     * @return
     */
    public String getToolTipText(WebElement element) {
        Actions action = new Actions(webDriver);
        action.moveToElement(element).perform();//hover vào element
        waitForDebug(2000);
        waitUntilVisibleElement(webDriver, "//div[@class='tooltip-inner']");
        WebElement toolTipButton = webDriver.findElement(By.xpath("//div[@class='tooltip-inner']"));//tìm tooltip
        return toolTipButton.getText();//lay text

    }


    @AfterClass
    public void afterClass() {
        webDriver.quit();
    }
}
