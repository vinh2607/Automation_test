package nganttt.btvn.buoi3;

import common.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Bai1 extends TestBase {
    WebDriver webDriver;
    String DYNAMIC_LOCATOR_INPUT_FORM = "//label[text()='%s']/following::input[1]";
    String DYNAMIC_LOCATOR_TEXTAREA_FORM = "//label[text()='%s']/following::textarea[1]";
    String DYNAMIC_LOCATOR_BUTTON_FORM = "//button[text()='%s']";
    String DYNAMIC_LOCATOR_ACTION_FORM = "//div[text()='%s']/following-sibling::div//span[@title='%s']";
    WebElement inputFirstName;
    WebElement inputLastName;
    WebElement inputEmail;
    WebElement inputAge;
    WebElement inputSalary;
    WebElement inputDepartment;
    WebElement buttonSubmit;

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
        webDriver = new ChromeDriver();
        gotoDemoQAWebsite(webDriver);
        webDriver.manage().window().maximize();
    }

    @Test(description = "Enter to textbox form")
    public void TC_01_EnterInfoToTextBoxForm() {
        goToNavTab("Text Box", webDriver);
        sendKeysToElement(findElementByXPath(DYNAMIC_LOCATOR_INPUT_FORM, "Full Name"), "Ngan");
        sendKeysToElement(findElementByXPath(DYNAMIC_LOCATOR_INPUT_FORM, "Email"), "Abc@gmail.com");
        sendKeysToElement(findElementByXPath(DYNAMIC_LOCATOR_TEXTAREA_FORM, "Current Address"), "Ha Noi");
        sendKeysToElement(findElementByXPath(DYNAMIC_LOCATOR_TEXTAREA_FORM, "Permanent Address"), "Ha Noi");
        scrollByVisibleElement(getStringXPath(DYNAMIC_LOCATOR_BUTTON_FORM, "Submit"));
        clickToElement(findElementByXPath(DYNAMIC_LOCATOR_BUTTON_FORM, "Submit"));
    }

    @Test(description = "Web table")
    public void TC_02_EnterInfoToWebTable() {
        goToNavTab("Web Tables", webDriver);
        clickToElement(findElementByXPath(DYNAMIC_LOCATOR_BUTTON_FORM, "Add"));
        getElementForm();

        String firstName = "Ngan";
        String lastName = "Truong";
        String email = "Abc@gmail.com";
        String age = "20";
        String salary = "20000000";
        String department = "Abc";
        String edtFirstName = "A";
        String edtLastName = "B";
        String edtEmail = "Abcd@gmail.com";
        String edtAge = "1";
        String edtSalary = "30000000";
        String edtDepartment = "A";
        sendKeysToElement(inputFirstName, firstName);
        sendKeysToElement(inputLastName, lastName);
        sendKeysToElement(inputEmail, email);
        sendKeysToElement(inputAge, age);
        sendKeysToElement(inputSalary, salary);
        sendKeysToElement(inputDepartment, department);
        clickToElement(buttonSubmit);
        waitForDebug(2000);

        //verify data user vua nhap
        verifyData("Abc@gmail.com", "First Name", firstName);
        verifyData("Abc@gmail.com", "Last Name", lastName);
        verifyData("Abc@gmail.com", "Age", age);
        verifyData("Abc@gmail.com", "Salary", salary);
        verifyData("Abc@gmail.com", "Department", department);

        //sửa thông tin vừa nhập
        clickToAction(firstName, "Edit");
        getElementForm();
//        WebElement inputFirstName = findElementByXPath(DYNAMIC_LOCATOR_INPUT_FORM, "First Name");
//        WebElement inputLastName = findElementByXPath(DYNAMIC_LOCATOR_INPUT_FORM, "Last Name");
//        WebElement inputEmail = findElementByXPath(DYNAMIC_LOCATOR_INPUT_FORM, "Email");
//        WebElement inputAge = findElementByXPath(DYNAMIC_LOCATOR_INPUT_FORM, "Age");
//        WebElement inputSalary = findElementByXPath(DYNAMIC_LOCATOR_INPUT_FORM, "Salary");
//        WebElement inputDepartment = findElementByXPath(DYNAMIC_LOCATOR_INPUT_FORM, "Department");
//        WebElement buttonSubmit = findElementByXPath(DYNAMIC_LOCATOR_BUTTON_FORM, "Submit");

        editKeysToElement(inputFirstName, edtFirstName);
        editKeysToElement(inputLastName, edtLastName);
        editKeysToElement(inputEmail, edtEmail);
        editKeysToElement(inputAge, edtAge);
        editKeysToElement(inputSalary, edtSalary);
        editKeysToElement(inputDepartment, edtDepartment);
        clickToElement(buttonSubmit);

        //verify data user vua edit
        verifyData("Abcd@gmail.com", "First Name", edtFirstName);
        verifyData("Abcd@gmail.com", "Last Name", edtLastName);
        verifyData("Abcd@gmail.com", "Age", edtAge);
        verifyData("Abcd@gmail.com", "Salary", edtSalary);
        verifyData("Abcd@gmail.com", "Department", edtDepartment);

        //xoa thong tin vua nhap
        clickToAction(edtFirstName, "Delete");
    }

    /**
     * Verify dữ liệu,
     * @param email : truyền email user cần verify
     * @param header: tên thuộc tính cần verify
     * @param value: Giá trị mong đợi
     */
    public void verifyData(String email, String header, String value) {
        String DYNAMIC_LOCATOR_HEADER_PRECEDING = "//div[contains(@class,'rt-thead -header')]//div[text()= '%s']/../preceding-sibling::div";
        int index = findElementsByXPath(DYNAMIC_LOCATOR_HEADER_PRECEDING, header).size();
  ////div[text()='Cierra']/following-sibling::div[text()='Vega']/following-sibling::div[text()='39']/following-sibling::div[text()='cierra@example.com']/following-sibling::div[text()='10000']/following-sibling::div[text()='Insurance']
        String DYNAMIC_LOCATOR_VALUE_OF_HEADER = "//div[text()='%s']/../div[%s]";
        WebElement element = findElementByXPath(DYNAMIC_LOCATOR_VALUE_OF_HEADER, email, String.valueOf(index+1));
        Assert.assertEquals(element.getText(), value);
    }

    @Test(description = "Links")
    public void TC_03_Open_Links() {
        gotoDemoQAWebsite(webDriver);
        scrollByVisibleElement("//li[contains(@class,'btn btn-light')]//span[normalize-space()='Links']");
        goToNavTab("Links", webDriver);

        //lay cua so hien tai
        String originalWindow = webDriver.getWindowHandle();
        String simpleLink = getSimpleLink();
        String dynamicLink = getDynamicLink();

        //TAB
        webDriver.switchTo().newWindow(WindowType.TAB);
        webDriver.get(simpleLink);
        webDriver.close();
        webDriver.switchTo().window(originalWindow);
        webDriver.switchTo().newWindow(WindowType.TAB);
        webDriver.get(dynamicLink);
        webDriver.close();
        webDriver.switchTo().window(originalWindow);
        //Windows
        webDriver.switchTo().newWindow(WindowType.WINDOW);
        webDriver.get(simpleLink);
        webDriver.close();
        webDriver.switchTo().window(originalWindow);
        webDriver.switchTo().newWindow(WindowType.WINDOW);
        webDriver.get(dynamicLink);
        webDriver.close();
        webDriver.switchTo().window(originalWindow);

    }

    public String getSimpleLink() {
        return webDriver.findElement(By.xpath("//a[text()='Home']")).getAttribute("href");
    }

    public String getDynamicLink() {
        return webDriver.findElement(By.xpath("//a[@id='dynamicLink']")).getAttribute("href");
    }

    public void getElementForm() {
        inputFirstName = findElementByXPath(DYNAMIC_LOCATOR_INPUT_FORM, "First Name");
        inputLastName = findElementByXPath(DYNAMIC_LOCATOR_INPUT_FORM, "Last Name");
        inputEmail = findElementByXPath(DYNAMIC_LOCATOR_INPUT_FORM, "Email");
        inputAge = findElementByXPath(DYNAMIC_LOCATOR_INPUT_FORM, "Age");
        inputSalary = findElementByXPath(DYNAMIC_LOCATOR_INPUT_FORM, "Salary");
        inputDepartment = findElementByXPath(DYNAMIC_LOCATOR_INPUT_FORM, "Department");
        buttonSubmit = findElementByXPath(DYNAMIC_LOCATOR_BUTTON_FORM, "Submit");
    }

    public String getStringXPath(String format, String... values) {
        return String.format(format, values);
    }

   public List<WebElement> findElementsByXPath(String format, String... values) {
       By xPath = By.xpath(getStringXPath(format, values));
       return webDriver.findElements(xPath);
   }

    public WebElement findElementByXPath(String format, String... values) {
        By xPath = By.xpath(getStringXPath(format, values));
        try {
            return webDriver.findElement(xPath);
        } catch (Exception e) {
            System.out.println("Element not found");
            return null;
        }
    }

    public void clickToAction(String firstName, String action) {
        findElementByXPath(DYNAMIC_LOCATOR_ACTION_FORM, firstName, action).click();
    }

    public void sendKeysToElement(WebElement element, String value) {
        element.sendKeys(value);
        Assert.assertEquals(element.getAttribute("value"), value);
    }

    public void editKeysToElement(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
        Assert.assertEquals(element.getAttribute("value"), value);
    }

    public void clickToElement(WebElement element) {
        element.click();
    }

    public void scrollByVisibleElement(String xPath) {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        WebElement element = webDriver.findElement(By.xpath(xPath));
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    @AfterClass
    public void afterClass() {
        webDriver.quit();
    }
}
