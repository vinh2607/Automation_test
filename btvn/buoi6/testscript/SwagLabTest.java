package nganttt.btvn.buoi6.testscript;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import nganttt.btvn.buoi6.page.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SwagLabTest {
    private WebDriver webDriver;
    private HomePage homePage;
    private LoginPage loginPage;
    private YourCartPage yourCartPage;
    private YourInfomationPage yourInfomationPage;
    private OverviewPage overviewPage;
    private CompletePage completePage;

    @BeforeClass
    public void beforeClass(){
        WebDriverManager.getInstance(DriverManagerType.CHROME);
        webDriver = new ChromeDriver();
        loginPage = new LoginPage(webDriver);
    }

    /**
     * BTVN:
     * 1. Access: https://www.saucedemo.com
     * 2. Login
     * 3. Sort all and check/verify
     * 4. Add items to cart
     * 5. Checkout
     * 6. Fill info & verify don hang
     */
    @Test
    public void goToLoginPage(){
         // 1. Access: https://www.saucedemo.com
        loginPage.goToSauceDemo();

        //2. Login
        homePage = loginPage.login();

        //3. Sort all and check/verify
        homePage.isLoginSuccess();
        homePage.selectByValue("Name (A to Z)");
        Assert.assertTrue(homePage.isSortedByName(true));
        homePage.selectByValue("Name (Z to A)");
        Assert.assertTrue(homePage.isSortedByName(false));
        homePage.selectByValue("Price (low to high)");
        Assert.assertTrue(homePage.isSortedByPrice(true));
        homePage.selectByValue("Price (high to low)");
        Assert.assertTrue(homePage.isSortedByPrice(false));
        homePage.addRandomItemToCart();
        yourCartPage = homePage.goToYourCartPage();

//      4. Add items to cart
        yourCartPage.isGoToCartPageSuccess();
        yourCartPage.checkCart();

//      5. Checkout
        yourInfomationPage = yourCartPage.checkOut();
        yourInfomationPage.isGoToInfoPageSuccess();
        
//     6. Fill info & verify don hang
        overviewPage = yourInfomationPage.enterInfo();
        overviewPage.isGoToOverViewPageSuccess();
        overviewPage.checkCart();
        overviewPage.checkTotal();
        completePage = overviewPage.finish();

        completePage.isGoToCompletePageSuccess();
    }


    @AfterClass
    public void afterClass() {
        webDriver.quit();
    }
}
