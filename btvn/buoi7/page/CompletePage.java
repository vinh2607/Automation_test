package nganttt.btvn.buoi7.page;

import nganttt.btvn.buoi7.common.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CompletePage extends BasePage {
    String imgFinishXPath = "//img[@alt='Pony Express']";
    /**
     * Init a new instance
     *
     * @param webDriver : The WebDriver to interact with elements
     */
    public CompletePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void isGoToCompletePageSuccess() {
        waitUntilVisibleElement(imgFinishXPath);
        Assert.assertTrue(findElement(imgFinishXPath).isDisplayed());
    }


}
