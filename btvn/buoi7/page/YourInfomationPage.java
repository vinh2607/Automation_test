package nganttt.btvn.buoi7.page;

import nganttt.btvn.buoi7.common.BaseContst;
import nganttt.btvn.buoi7.common.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class YourInfomationPage extends BasePage {
    String headerTitleXPath = getStringXPath(BaseContst.DYNAMIC_TITLE_FORM, "Checkout: Your Information");
    String firstName = "A";
    String lastName = "B";
    String zip = "10000";
    String loginButtonXPath = getStringXPath(BaseContst.DYNAMIC_INPUT_BUTTON_FORM, "continue");

    /**
     * Init a new instance
     *
     * @param webDriver : The WebDriver to interact with elements
     */
    public YourInfomationPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void isGoToInfoPageSuccess() {
        waitUntilVisibleElement(headerTitleXPath);
        Assert.assertTrue(findElement(headerTitleXPath).isDisplayed());
    }

    public OverviewPage enterInfo() {
        inputTextWithType(BaseContst.DYNAMIC_INPUT_TEXT_FORM, "firstName", firstName);
        inputTextWithType(BaseContst.DYNAMIC_INPUT_TEXT_FORM, "lastName", lastName);
        inputTextWithType(BaseContst.DYNAMIC_INPUT_TEXT_FORM, "postalCode", zip);
        WebElement loginButton = findElement(loginButtonXPath);
        clickToElement(loginButton);
        return new OverviewPage(webDriver);
    }


}
