package nganttt.btvn.buoi3;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Bai2 extends BaseTest {
    WebDriver webDriver;
    String DYNAMIC_LOCATOR_MENU_FORM = "//li/a[normalize-space(text())='%s']";
    String DYNAMIC_LOCATOR_SUBMENU_FORM = "//li/a[normalize-space(text())='%s']/following-sibling::ul//a[text()='%s']";
    String DYNAMIC_LIST_XPATH_SUBMENU_FORM = "//li/a[normalize-space(text())='%s']/following-sibling::ul//a";

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
        webDriver = new ChromeDriver();
        gotoGuruWebsite(webDriver);
        webDriver.manage().window().maximize();
    }

    @Test
    public void TC_01_GoToTab() {
        goToTab("Insurance Project");
        goToTab("Agile Project");
        goToTab("Bank Project");
        goToTab("Security Project");
        goToTab("Telecom Project");
        goToTab("Payment Gateway Project");
        goToTab("New Tours");

        goToListSubMenu("Selenium");
        goToListSubMenu("SEO");
    }

    @Test()
    public void TC_02_Login() {
        String inputEmailID = "//input[@name='emailid']";
        String submitButton = "//input[@value='Submit']";
        String logInButton = "//input[@value='LOGIN']";
        String xPathInFoUserID = "//td[text()='User ID :']/following-sibling::td";
        String xPathInFoPassword = "//td[text()='Password :']/following-sibling::td";
        String xPathLoginUserID = "//td[text()='UserID']/following-sibling::td/input";
        String xPathLoginPassword = "//td[text()='Password']/following-sibling::td/input";
        String welcomText = "Welcome To Manager's Page of GTPL Bank";
        String xPathWelcomeText = "//marquee";

        String titleHome = "GTPL Bank Home Page";
        String titleManagerPage = "GTPL Bank Manager HomePage";


        gotoGuruWebsite(webDriver);
        sendKeysToElement(webDriver.findElement(By.xpath(inputEmailID)), "Abc@gmail.com");
        clickToElement(webDriver.findElement(By.xpath(submitButton)));
        String userID = webDriver.findElement(By.xpath(xPathInFoUserID)).getText();
        String password = webDriver.findElement(By.xpath(xPathInFoPassword)).getText();

        //đăng nhập
        goToBankProjectTab();
        //tat qc
//        webDriver.switchTo().frame(webDriver.findElement(By.xpath("//iframe[@frameborder='0']")));
//        webDriver.switchTo().frame(webDriver.findElement(By.xpath("//iframe[@title='Advertisement']")));
//        clickToElement(webDriver.findElement(By.xpath("//div[@aria-label='Close ad']")));
        webDriver.navigate().refresh();
        goToBankProjectTab();
        login(xPathLoginUserID, xPathLoginPassword, userID, password);
        clickToElement(webDriver.findElement(By.xpath(logInButton)));
        String newTitle = webDriver.getTitle();
        Assert.assertEquals(newTitle, titleManagerPage);//Verify đã đăng nhập thành công
        Assert.assertEquals(webDriver.findElement(By.xpath(xPathWelcomeText)).getText(), welcomText); //verify chữ

        //Đăng xuất
        String xPathLogOutButton = "//a[text()='Log out']";
        scrollByVisibleElement(webDriver, xPathLogOutButton);
        webDriver.findElement(By.xpath(xPathLogOutButton)).click();
        webDriver.switchTo().alert().accept();
        newTitle = webDriver.getTitle();
        Assert.assertEquals(newTitle, titleHome);
    }

    private void login(String xPathUserID, String xPathPassword, String id, String pass) {
        WebElement elementEmail = findElementByXPath(webDriver, xPathUserID);
        waitUntilVisibleElement(webDriver, "//td[text()='UserID']/following-sibling::td//input");
        sendKeysToElement(elementEmail, id);
        WebElement elementPass = findElementByXPath(webDriver, xPathPassword);
        sendKeysToElement(elementPass, pass);
    }

    private void goToBankProjectTab() {
        String xPath = getStringXPath(DYNAMIC_LOCATOR_MENU_FORM, "Bank Project");
        WebElement element = findElementByXPath(webDriver, xPath);
        clickToElement(element);
        waitUntilVisibleElement(webDriver, "//div[@class='logo']/a/img");
    }

    private void goToTab(String tabName) {
        WebElement element = findElementByXPath(webDriver, DYNAMIC_LOCATOR_MENU_FORM, tabName);
        clickToElement(element);
        waitUntilVisibleElement(webDriver, "//div[@class='logo']/a/img");
        waitForDebug(1000);
        webDriver.navigate().back();
        waitUntilVisibleElement(webDriver, "//div[@class='logo']/a/img");
    }

    //mo tat ca submenu cua tab ten tabName
    private void goToListSubMenu(String tabName) {
        List<String> listSubMenuName = getSubMenu(tabName);
        listSubMenuName.forEach(subMenuName -> goToSubMenuByName(tabName, subMenuName));
    }

    //lay list submenu name
    private List<String> getSubMenu(String tabName) {
        WebElement elementTab = findElementByXPath(webDriver, DYNAMIC_LOCATOR_MENU_FORM, tabName);
        elementTab.click();
        List<String> list = new ArrayList<>();
        String xPathListSubMenu = getStringXPath(DYNAMIC_LIST_XPATH_SUBMENU_FORM, tabName);
        List<WebElement> elementList = webDriver.findElements(By.xpath(xPathListSubMenu));
        elementList.forEach(element -> list.add(element.getText()));
        return list;
    }

    //check combobox, mo combobox va click vao submenu
    private void goToSubMenuByName(String tabName, String subMenuName) {

        String xPathTabName = getStringXPath(DYNAMIC_LOCATOR_MENU_FORM, tabName);
        WebElement elementTab = findElementByXPath(webDriver, xPathTabName);

        if (!verifyComboBoxIsOpen(tabName)) {//check chua mo
            elementTab.click();
            if (verifyComboBoxIsOpen(tabName)) {//check da mo
                clickSubMenu(tabName, subMenuName);
            }
        } else {//check da mo
            clickSubMenu(tabName, subMenuName);
        }
    }

    //click vao submenu
    private void clickSubMenu(String tabName, String subMenuName) {
        String xPath = getStringXPath(DYNAMIC_LOCATOR_SUBMENU_FORM, tabName, subMenuName);
        WebElement element = findElementByXPath(webDriver, xPath);
        clickToElement(element);
        webDriver.navigate().back();
        waitUntilVisibleElement(webDriver, "//img[@src='/logo.png']");

    }

    private Boolean verifyComboBoxIsOpen(String tabName) {
        //check thẻ li, nếu class có open thì đang mở, k có thì đang đóng
        String xPathCheck = getStringXPath(DYNAMIC_LOCATOR_MENU_FORM, tabName) + "/..";
        WebElement elementTab = findElementByXPath(webDriver, xPathCheck);
        String classValue = elementTab.getAttribute("class");
        return classValue.contains("open");
    }


    @AfterClass
    public void afterClass() {
        webDriver.quit();
    }

}
