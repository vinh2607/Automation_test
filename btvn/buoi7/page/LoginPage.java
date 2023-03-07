package nganttt.btvn.buoi7.page;

import nganttt.btvn.buoi7.common.BaseContst;
import nganttt.btvn.buoi7.common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPage extends BasePage {
    String loginButtonXPath = getStringXPath(BaseContst.DYNAMIC_INPUT_BUTTON_FORM, "login-button");
    /**
     * Go to Login Page
     */

    /**
     * Init a new instance
     *
     * @param webDriver : The WebDriver to interact with elements
     */
    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void goToSauceDemo(){
        gotoLoginPage();
        String url = webDriver.getCurrentUrl();
        Assert.assertEquals(url, BaseContst.URL);;
    }
    public HomePage login(String username, String password) {
        inputTextWithType(BaseContst.DYNAMIC_INPUT_TEXT_FORM, "user-name", username);
        inputTextWithType(BaseContst.DYNAMIC_INPUT_TEXT_FORM, "password", password);
        WebElement loginButton = findElement(loginButtonXPath);
        clickToElement(loginButton);
        return new HomePage(webDriver);
    }



}
