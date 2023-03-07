package nganttt.btvn.buoi7.testscript;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import nganttt.btvn.buoi7.dataprovider.TestDataProvider;
import nganttt.btvn.buoi7.model.LoginModel;
import nganttt.btvn.buoi7.model.ProductModel;
import nganttt.btvn.buoi7.page.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;

public class SwagLabTest {
    private WebDriver webDriver;
    private HomePage homePage;
    private LoginPage loginPage;
    private YourCartPage yourCartPage;
    private YourInfomationPage yourInfomationPage;
    private OverviewPage overviewPage;
    private CompletePage completePage;

    @BeforeMethod
    public void beforeMethod() {
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
    @Test(priority = 0, dataProvider = "LoginFunction", dataProviderClass = TestDataProvider.class)
    public void goToLoginPage(LoginModel loginModel) {
        // 1. Access: https://www.saucedemo.com
        loginPage.goToSauceDemo();

        //2. Login
        homePage = loginPage.login(loginModel.getUsername(), loginModel.getPassword());

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
    }

    @Test(priority = 1, dataProvider = "AddItemToCartFunction", dataProviderClass = TestDataProvider.class)
    public void addItemToCart(ProductModel productModel) {
        loginPage.goToSauceDemo();

        //2. Login
        homePage = loginPage.login("standard_user", "secret_sauce");

        //3. Sort all and check/verify
        homePage.isLoginSuccess();

        //      4. Add items to cart
        homePage.addItemToCart(productModel.getName(), productModel.getPrice());
        yourCartPage = homePage.goToYourCartPage();
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


    @AfterMethod
    public void afterMethod() {
        HomePage.listAddedProduct =new ArrayList<>();;
        webDriver.quit();
    }
}
