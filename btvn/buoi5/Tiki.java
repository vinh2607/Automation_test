package nganttt.btvn.buoi5;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Tiki extends BaseTest {
    WebDriver webDriver;
    String DYNAMIC_LOCATOR_DROPDOWN_INPUT, DYNAMIC_LOCATOR_DROPDOWN_VALUE, DYNAMIC_LOCATOR_DROPDOWN, DYNAMIC_LOCATOR_BUTTON, DYNAMIC_LOCATOR_TEXT, DYNAMIC_LOCATOR_INPUT, DYNAMIC_LOCATOR_LABEL, DYNAMIC_LOCATOR_SPAN;
    Actions actions;

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
        webDriver = new ChromeDriver();
        actions = new Actions(webDriver);
        DYNAMIC_LOCATOR_DROPDOWN = "//p[text()='%s']/following-sibling::div";
        DYNAMIC_LOCATOR_DROPDOWN_INPUT = "//p[text()='%s']/following-sibling::div//input";
        DYNAMIC_LOCATOR_DROPDOWN_VALUE = "//p[text()='%s']/following::div[contains(@class,'menu')]//div[contains(text(),'%s')]";
        DYNAMIC_LOCATOR_BUTTON = "//button[text()='%s']";
        DYNAMIC_LOCATOR_TEXT = "//p[text()='%s']";
        DYNAMIC_LOCATOR_INPUT = "//input[@placeholder='%s']";
        DYNAMIC_LOCATOR_LABEL = "//label[text()='%s']";
        DYNAMIC_LOCATOR_SPAN = "//span[text()='%s']";
    }


    @Test(description = "Verify Login & Register screen")
    public void Tiki_TC_01() {
        String xPathAccountHeader = "//span[text()='Tui']/..";
        String xPathLoginText = String.format(DYNAMIC_LOCATOR_TEXT, "Đăng nhập hoặc Tạo tài khoản");
        String xPathTelInput = String.format(DYNAMIC_LOCATOR_INPUT, "Số điện thoại");
        String xPathLoginWithEmail = "//p[text()='Đăng nhập bằng email']";
        String xPathLoginWithFacebook = "//img[@alt='facebook']";
        String xPathLoginWithGoogle = "//img[@alt='google']";

        /**
         * 1. Open the browser for Tiki website: https://tiki.vn/
         */
        gotoWebsite(webDriver, "https://tiki.vn/");
        /**
         * 1. Navigate to Tiki homepage successfully
         */
        String url = webDriver.getCurrentUrl();
        Assert.assertEquals(url, "https://tiki.vn/");

        /**
         * 2. Click on "Đăng nhập"
         */
        clickToElement(webDriver, xPathAccountHeader);
        waitUntilVisibleElement(webDriver, xPathLoginText);
        /**
         * 2. "Đăng nhập" popup is displayed
         */
        Assert.assertTrue(findElementByXPath(webDriver, xPathLoginText).isDisplayed());
        Assert.assertTrue(findElementByXPath(webDriver, xPathTelInput).isDisplayed());
        Assert.assertTrue(findElementByDynamicLocator(webDriver, DYNAMIC_LOCATOR_BUTTON, "Tiếp Tục").isDisplayed());
        Assert.assertTrue(findElementByXPath(webDriver, xPathLoginWithEmail).isDisplayed());
        Assert.assertTrue(findElementByXPath(webDriver, xPathLoginWithFacebook).isDisplayed());
        Assert.assertTrue(findElementByXPath(webDriver, xPathLoginWithGoogle).isDisplayed());
    }

    @Test(description = "Test selecting delivery address")
    public void Tiki_TC_02() {
        String xPathAddressHeader = "//div[@class='address']/..";
        String xPathSelectAddress = "//span[text()='Chọn khu vực giao hàng khác']/..";
        String xPathAddressTitle = "//p[text()='Địa chỉ giao hàng']";
        String xPathLocationForm = "//div[contains(@class,'LocationForm')]";
        String xPathLocationPicker = "//div[@class='address']";
        String province = "Nghệ An";
        String district = "Diễn Châu";
        String ward = "Diễn Kỷ";

        /**
         * *1. Open the browser for Tiki website: https://tiki.vn/
         */
        gotoWebsite(webDriver, "https://tiki.vn/");
        /**
         * 1. Navigate to Tiki homepage successfully
         */
        String url = webDriver.getCurrentUrl();
        Assert.assertEquals(url, "https://tiki.vn/");

        /**
         *  2. Click on "Bạn muốn giao hàng tới đâu?" (under the Search textbox)
         */
        clickToElement(webDriver, xPathAddressHeader);
        waitUntilVisibleElement(webDriver, xPathAddressTitle);
        clickToElement(webDriver, xPathSelectAddress);
        WebElement provinceCityDropdowns = findElementByDynamicLocator(webDriver, DYNAMIC_LOCATOR_DROPDOWN_INPUT, "Tỉnh/Thành phố");
        WebElement districtDropdowns = findElementByDynamicLocator(webDriver, DYNAMIC_LOCATOR_DROPDOWN_INPUT, "Quận/Huyện");
        WebElement wardDropdowns = findElementByDynamicLocator(webDriver, DYNAMIC_LOCATOR_DROPDOWN_INPUT, "Phường/Xã");
        /**
         2. "Địa chỉ giao hàng" popup is displayed with three dropdowns:
         */
        Assert.assertTrue(findElementByXPath(webDriver, xPathAddressTitle).isDisplayed());
        clickToElement(webDriver, xPathSelectAddress);
        Assert.assertTrue(findElementByXPath(webDriver, xPathLocationForm).isDisplayed());
        Assert.assertTrue(provinceCityDropdowns.isDisplayed());
        Assert.assertTrue(districtDropdowns.isDisplayed());
        Assert.assertTrue(wardDropdowns.isDisplayed());
        /**
         3. Select any province/city from "Tỉnh/Thành phố" dropdown
         3."Tỉnh/Thành phố" dropdown is able to select and the remaining dropdowns are unable
         */
        Assert.assertTrue(provinceCityDropdowns.isEnabled());
        Assert.assertFalse(districtDropdowns.isEnabled());
        Assert.assertFalse(wardDropdowns.isEnabled());

        selectValueInDropdown("Tỉnh/Thành phố", province);
        /**
         4. Select any district from "Quận/Huyện" dropdown
         4. "Quận/Huyện" dropdown is able to select and the last dropdown is unable
         */
        Assert.assertTrue(districtDropdowns.isEnabled());
        Assert.assertFalse(wardDropdowns.isEnabled());

        selectValueInDropdown("Quận/Huyện", district);

        /**
         5. Select any precinct/commune from "Phường/Xã" dropdown
         5. "Phường/Xã" dropdown is able to select
         */
        Assert.assertTrue(wardDropdowns.isEnabled());
        selectValueInDropdown("Phường/Xã", ward);

        /**
         6. Click on "Giao đến địa chỉ này" button
         */
        findElementByDynamicLocator(webDriver, DYNAMIC_LOCATOR_BUTTON, "GIAO ĐẾN ĐỊA CHỈ NÀY").click();
        /**
         6. Navigate to Tiki homepage and "Bạn muốn giao hàng tới đâu?" span is converted into the name of location picker which you chose
         */
        String url1 = webDriver.getCurrentUrl();
        Assert.assertEquals(url1, "https://tiki.vn/");
        waitForDebug(5000);
        String locationPickerText = webDriver.findElement(By.xpath(xPathLocationPicker)).getText();
        Assert.assertTrue(locationPickerText.contains(province) && locationPickerText.contains(district) && locationPickerText.contains(ward));

    }

    @Test(description = "Test account information")
    public void Tiki_TC_03() {
        String xPathAccountHeader = "//span[text()='Tui']/..";
        String xPathLoginText = String.format(DYNAMIC_LOCATOR_TEXT, "Đăng nhập hoặc Tạo tài khoản");
        String xPathTelInput = String.format(DYNAMIC_LOCATOR_INPUT, "Số điện thoại");
        String xPathPasswordInput = String.format(DYNAMIC_LOCATOR_INPUT, "Mật khẩu");
        String xPathAccountInfo = String.format(DYNAMIC_LOCATOR_TEXT, "Thông tin tài khoản");
        String xPathAccount = "//div[text()='Thông tin tài khoản']";
        String passwordHeader = "//h4[text()='Nhập mật khẩu']";
        String tel = "0971584293";
        String pass = "Ngan@1237";

        /**
         * 1. Open the browser for Tiki website: https://tiki.vn/
         */
        gotoWebsite(webDriver, "https://tiki.vn/");
        /**
         * 1. Navigate to Tiki homepage successfully
         */
        String url = webDriver.getCurrentUrl();
        Assert.assertEquals(url, "https://tiki.vn/");

        /**
         * Click on "Đăng nhập"
         */
        clickToElement(webDriver, xPathAccountHeader);
        waitUntilVisibleElement(webDriver, xPathLoginText);
        webDriver.findElement(By.xpath(xPathTelInput)).sendKeys(tel);
        findElementByDynamicLocator(webDriver, DYNAMIC_LOCATOR_BUTTON, "Tiếp Tục").click();
        waitUntilVisibleElement(webDriver, passwordHeader);
        webDriver.findElement(By.xpath(xPathPasswordInput)).sendKeys(pass);
        findElementByDynamicLocator(webDriver, DYNAMIC_LOCATOR_BUTTON, "Đăng Nhập").click();
        waitForDebug(20000);

        /**
         * 2. Click on "Tui"
         */
        WebElement accountHeader = webDriver.findElement(By.xpath("//span[text()='Tui']/.."));
        actions.moveToElement(accountHeader).perform();
        waitUntilVisibleElement(webDriver, xPathAccountInfo);
        clickToElement(webDriver, xPathAccountInfo);
        /**
         * 2. System displays dropdown list:
         * - Đơn hàng của tôi
         * - Thông báo của tôi
         * - Tài khoản của tôi
         */
        Assert.assertTrue(findElementByDynamicLocator(webDriver, DYNAMIC_LOCATOR_TEXT, "Thông tin tài khoản").isDisplayed());
        Assert.assertTrue(findElementByDynamicLocator(webDriver, DYNAMIC_LOCATOR_TEXT, "Đơn hàng của tôi").isDisplayed());
        Assert.assertTrue(findElementByDynamicLocator(webDriver, DYNAMIC_LOCATOR_TEXT, "Đăng xuất").isDisplayed());


        /**
         * 3. System displays "Thông tin tài khoản" with the following fields:
         * - Họ tên
         * - Số điện thoại
         * - Email
         * - Giới tính
         * - Ngày sinh
         * and "Liên kết tài khoản MXH" with Zalo, Facebook and Google
         */
        waitUntilVisibleElement(webDriver,xPathAccount);
        Assert.assertTrue(findElementByXPath(webDriver, xPathAccount).isDisplayed());
        Assert.assertTrue(findElementByDynamicLocator(webDriver, DYNAMIC_LOCATOR_LABEL, "Họ & Tên").isDisplayed());
        Assert.assertTrue(findElementByDynamicLocator(webDriver, DYNAMIC_LOCATOR_SPAN, "Số điện thoại").isDisplayed());
        Assert.assertTrue(findElementByDynamicLocator(webDriver, DYNAMIC_LOCATOR_SPAN, "Địa chỉ email").isDisplayed());
        Assert.assertTrue(findElementByDynamicLocator(webDriver, DYNAMIC_LOCATOR_LABEL, "Ngày sinh").isDisplayed());
        Assert.assertTrue(findElementByDynamicLocator(webDriver, DYNAMIC_LOCATOR_LABEL, "Giới tính").isDisplayed());
        Assert.assertTrue(findElementByDynamicLocator(webDriver, DYNAMIC_LOCATOR_SPAN, "Facebook").isDisplayed());
        Assert.assertTrue(findElementByDynamicLocator(webDriver, DYNAMIC_LOCATOR_SPAN, "Google").isDisplayed());


    }

    public void selectValueInDropdown(String locationType, String value) {
        WebElement selectLocator = findElementByDynamicLocator(webDriver, DYNAMIC_LOCATOR_DROPDOWN_INPUT, locationType);
        selectLocator.sendKeys(value);
        waitUntilVisibleElement(webDriver, String.format(DYNAMIC_LOCATOR_DROPDOWN_VALUE, locationType, value));
        clickToElement(webDriver, String.format(DYNAMIC_LOCATOR_DROPDOWN_VALUE, locationType, value));
    }

    //cách 2
//    public void selectValueInDropdown(String locationType, String value){
//        WebElement selectLocator = findElementByDynamicLocator(webDriver, DYNAMIC_LOCATOR_DROPDOWN, locationType);
//        selectLocator.click();
//        waitForDebug(3000);
//        Actions actions = new Actions(webDriver);
//        WebElement selectValue = findElementByDynamicLocator(webDriver,DYNAMIC_LOCATOR_DROPDOWN_VALUE, locationType, value);
//        actions.scrollToElement(selectValue).perform();
//        actions.scrollToElement(selectValue).perform();
//        clickToElement(selectValue);
//    }

    @AfterClass
    public void afterClass() {
        webDriver.quit();
    }

}
