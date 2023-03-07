package nganttt.btvn.buoi6.page;

import nganttt.btvn.buoi6.common.BaseContst;
import nganttt.btvn.buoi6.common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPage extends BasePage {
    String loginButtonXPath = getStringXPath(BaseContst.DYNAMIC_INPUT_BUTTON_FORM, "login-button");

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
    public HomePage login() {
        inputTextWithType(BaseContst.DYNAMIC_INPUT_TEXT_FORM, "user-name", getUsername());
        inputTextWithType(BaseContst.DYNAMIC_INPUT_TEXT_FORM, "password", getPassword());
        WebElement loginButton = findElement(loginButtonXPath);
        clickToElement(loginButton);
        return new HomePage(webDriver);
    }

    public String getUsername(){
        String listUsernameInfo = webDriver.findElement(By.xpath("//div[@class='login_credentials']")).getText();
        String[] listUsernameInfoSplit = listUsernameInfo.split("\n");
        return listUsernameInfoSplit[1];
    }
    public String getPassword(){
        String passwordInfo = webDriver.findElement(By.xpath("//div[@class='login_password']")).getText();
        String[] passwordInfoSplit = passwordInfo.split("\n");
        return passwordInfoSplit[1];
    }


}
