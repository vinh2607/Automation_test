package nganttt.btvn;

import common.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;


public class BTVN01 extends TestBase {
    WebDriver webDriver;
    private String baseURL = "https://demoqa.com";

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
        webDriver = new ChromeDriver();
        gotoDemoQAWebsite(webDriver);
        webDriver.manage().window().maximize();
    }


    @Test(description = "Locator for Text Box Tab")
    public void textboxTab() {
        goToNavTab("Text Box", webDriver);

        String xPathFullName = "//input[@placeholder='Full Name']";
        String cssFullName = "input[placeholder='Full Name']";
        webDriver.findElement(By.xpath(xPathFullName));
        webDriver.findElement(By.cssSelector(cssFullName));

        String xPathEmail = "//input[@placeholder='name@example.com']";
        String cssEmail = "input[placeholder='name@example.com']";
        webDriver.findElement(By.xpath(xPathEmail));
        webDriver.findElement(By.cssSelector(cssEmail));

        String xPathCurrentAddress = "//textarea[@placeholder='Current Address']";
        String cssCurrentAdress = "textarea[placeholder='Current Address']";
        webDriver.findElement(By.xpath(xPathCurrentAddress));
        webDriver.findElement(By.cssSelector(cssCurrentAdress));

        String xPathPermanentAddress = "//textarea[@id='permanentAddress']";
        String cssPermanentAddress = "textarea[id='permanentAddress']";
        webDriver.findElement(By.xpath(xPathPermanentAddress));
        webDriver.findElement(By.cssSelector(cssPermanentAddress));

        String xPathSubmit = "//button[@id='submit']";
        String cssSubmit = "button[id='submit']";
        webDriver.findElement(By.xpath(xPathSubmit));
        webDriver.findElement(By.cssSelector(cssSubmit));

    }

    @Test(description = "Locator for Check Box tab")
    public void checkboxTab() {
        goToNavTab("Check Box", webDriver);

        List<WebElement> toggleElementXPath = webDriver.findElements(By.xpath("//button[@title='Toggle']"));
        for (int i = 1; i <= toggleElementXPath.size(); i++) {
            webDriver.findElement(By.xpath("//button[@title='Toggle'][" + i + "]"));
        }

        List<WebElement> checkboxElementXPath = webDriver.findElements(By.xpath("//span[@class='rct-checkbox']"));
        for (int i = 1; i <= checkboxElementXPath.size(); i++) {
            webDriver.findElement(By.xpath("(//span[@class='rct-checkbox'])[" + i + "]"));
        }

        String cssExpandAll = "button[title='Expand all']";
        webDriver.findElement(By.cssSelector(cssExpandAll)).click();

        String cssCollapseAll = "button[title='Collapse all']";
        webDriver.findElement(By.cssSelector(cssCollapseAll));

        findCheckboxByCss("home");
        findCheckboxByCss("desktop");
        findCheckboxByCss("notes");
        findCheckboxByCss("commands");
        findCheckboxByCss("documents");
        findCheckboxByCss("workspace");
        findCheckboxByCss("react");
        findCheckboxByCss("angular");
        findCheckboxByCss("veu");
        findCheckboxByCss("office");
        findCheckboxByCss("public");
        findCheckboxByCss("private");
        findCheckboxByCss("general");
        findCheckboxByCss("classified");
        findCheckboxByCss("downloads");
        findCheckboxByCss("wordFile");
        findCheckboxByCss("excelFile");

//        String checkBoxCssForm = "label[for='tree-node-%s']>span[class='rct-checkbox']";
//
//        String cssHomeCheckbox = String.format(checkBoxCssForm,"home");
//        webDriver.findElement(By.cssSelector(cssHomeCheckbox));
//
//        String cssDesktopCheckBox = String.format(checkBoxCssForm,"desktop");
//        webDriver.findElement(By.cssSelector(cssDesktopCheckBox));
//
//        String cssNotesCheckbox = String.format(checkBoxCssForm, "notes");
//        webDriver.findElement(By.cssSelector(cssNotesCheckbox));
//
//        String cssCommandsCheckbox = String.format(checkBoxCssForm, "commands");
//        webDriver.findElement(By.cssSelector(cssCommandsCheckbox));
//
//        //Documents
//        String cssDocumentsCheckbox = String.format(checkBoxCssForm, "documents");
//        webDriver.findElement(By.cssSelector(cssDocumentsCheckbox));
//
//        //WorkSpace
//        String cssWorkspaceCheckbox = String.format(checkBoxCssForm, "workspace");
//        webDriver.findElement(By.cssSelector(cssWorkspaceCheckbox));
//
//        String cssReactCheckBox = String.format(checkBoxCssForm, "react");
//        webDriver.findElement(By.cssSelector(cssReactCheckBox));
//
//        String cssAngularCheckBox = String.format(checkBoxCssForm, "angular");
//        webDriver.findElement(By.cssSelector(cssAngularCheckBox));
//
//        String cssVeuCheckBox = String.format(checkBoxCssForm, "veu");
//        webDriver.findElement(By.cssSelector(cssVeuCheckBox));
//
//        //Office
//        String cssOfficeCheckBox = String.format(checkBoxCssForm, "office");
//        webDriver.findElement(By.cssSelector(cssOfficeCheckBox));
//
//        String cssPublicCheckBox = String.format(checkBoxCssForm, "public");
//        webDriver.findElement(By.cssSelector(cssPublicCheckBox));
//
//        String cssPrivateCheckBox = String.format(checkBoxCssForm, "private");
//        webDriver.findElement(By.cssSelector(cssPrivateCheckBox));
//
//        String cssClassifiedCheckBox = String.format(checkBoxCssForm, "classified");
//        webDriver.findElement(By.cssSelector(cssClassifiedCheckBox));
//
//        String cssGeneralCheckBox = String.format(checkBoxCssForm, "general");
//        webDriver.findElement(By.cssSelector(cssGeneralCheckBox));
//
//        //Download
//        String cssDownloadsCheckBox = String.format(checkBoxCssForm, "downloads");
//        webDriver.findElement(By.cssSelector(cssDownloadsCheckBox));
//
//        String cssWordFileCheckBox = String.format(checkBoxCssForm, "wordFile");
//        webDriver.findElement(By.cssSelector(cssWordFileCheckBox));
//
//        String cssExcelFileCheckBox = String.format(checkBoxCssForm, "excelFile");
//        webDriver.findElement(By.cssSelector(cssExcelFileCheckBox));

    }

    public void findCheckboxByCss(String node) {
        String checkBoxCssForm = "label[for='tree-node-%s']>span[class='rct-checkbox']";
        String cssCheckBox = String.format(checkBoxCssForm, node);
        webDriver.findElement(By.cssSelector(cssCheckBox));
    }

    @Test(description = "Locator for Radio Button Tab")
    public void radioButtonTab() {
        goToNavTab("Radio Button", webDriver);

        String radioXPathForm = "//label[text()='%s']/preceding-sibling::input";

        String xPathYes = String.format(radioXPathForm, "Yes");
        String cssYes = "#yesRadio";
        webDriver.findElement(By.xpath(xPathYes));
        webDriver.findElement(By.cssSelector(cssYes));

        String xPathImpressive = String.format(radioXPathForm, "Impressive");
        String cssImpressive = "#impressiveRadio";
        webDriver.findElement(By.xpath(xPathImpressive));
        webDriver.findElement(By.cssSelector(cssImpressive));

        String xPathNo = String.format(radioXPathForm, "No");
        String cssNo = "#noRadio";
        webDriver.findElement(By.xpath(xPathNo));
        webDriver.findElement(By.cssSelector(cssNo));
    }

    @Test(description = "Locator for Web Tables Tab")
    public void webTableTab() {
        goToNavTab("Web Tables", webDriver);

        String xPathAdd = "//button[@id='addNewRecordButton']";
        String cssAdd = "button[id='addNewRecordButton']";
        webDriver.findElement(By.xpath(xPathAdd)).click();
        webDriver.findElement(By.cssSelector(cssAdd));

        //search box
        String xPathSearchBox = "//input[@id='searchBox']";
        String cssSearchBox = "input[id='searchBox']";
        webDriver.findElement(By.xpath(xPathSearchBox));
        webDriver.findElement(By.cssSelector(cssAdd));

        //icon search
        String xPathSearch = "//span[@id='basic-addon2']";
        String cssSearch = "input[id='searchBox']";
        webDriver.findElement(By.xpath(xPathSearch));
        webDriver.findElement(By.cssSelector(cssSearch));

        //registration form
        List<WebElement> listInputRegistForm = webDriver.findElements(By.xpath("//form[@id='userForm']//descendant::input"));
        for (int i = 1; i < listInputRegistForm.size(); i++) {
            webDriver.findElement(By.xpath("//form[@id='userForm']//descendant::input[" + i + "]"));
        }

        String cssFirstName = "input[placeholder='First Name']";
        webDriver.findElement(By.cssSelector(cssFirstName));

        String cssLastName = "input[placeholder='Last Name']";
        webDriver.findElement(By.cssSelector(cssLastName));

        String cssEmail = "#userEmail";
        webDriver.findElement(By.cssSelector(cssEmail));

        String cssAge = "#age";
        webDriver.findElement(By.cssSelector(cssAge));

        String cssSalary = "#salary";
        webDriver.findElement(By.cssSelector(cssSalary));

        String cssDepartment = "#department";
        webDriver.findElement(By.cssSelector(cssDepartment));

        String xPathSubmit = "//button[@id='submit']";
        webDriver.findElement(By.xpath(xPathSubmit));
        String cssSubmit = "#submit";
        webDriver.findElement(By.cssSelector(cssSubmit));

        String xPathClose = "//button[@class='close']/span[text()='×']";
        String cssClose = "button[class='close']>span";
        webDriver.findElement(By.cssSelector(cssClose));
        webDriver.findElement(By.xpath(xPathClose)).click();

        //edit
        List<WebElement> listEditIcon = webDriver.findElements(By.xpath("//span[@title='Edit']"));
        for (int i = 1; i <= listEditIcon.size(); i++) {
            webDriver.findElement(By.xpath("(//span[@title='Edit'])[" + i + "]"));
        }

        //delete
        List<WebElement> listDeleteIcon = webDriver.findElements(By.xpath("//div/span[@title='Delete']"));
        for (int i = 1; i <= listDeleteIcon.size(); i++) {
            webDriver.findElement(By.xpath("(//span[@title='Delete'])[" + i + "]"));
        }

        //previous
        String xPathPrevious = "//button[text()='Previous']";
        webDriver.findElement(By.xpath(xPathPrevious));
        String cssPrevious = "div[class='-previous']>button";
        webDriver.findElement(By.cssSelector(cssPrevious));

        //next
        String xPathNext = "//button[text()='Next']";
        webDriver.findElement(By.xpath(xPathNext));
        String cssNext = "div[class='-next']>button";
        webDriver.findElement(By.cssSelector(cssNext));

        //page jump
        String xPathPageJump = "//input[@aria-label='jump to page']";
        webDriver.findElement(By.xpath(xPathPageJump));
        String cssPageJump = "input[aria-label='jump to page']";
        webDriver.findElement(By.cssSelector(cssPageJump));

        scrollByVisibleElement(xPathPageJump);
        //row per page
        String xPathRows = "//select[@aria-label='rows per page']";
        webDriver.findElement(By.xpath(xPathRows)).click();
        String cssRow = "select[aria-label='rows per page']";
        webDriver.findElement(By.cssSelector(cssRow));

        List<WebElement> listRow = webDriver.findElements(By.xpath("//select[@aria-label='rows per page']/option"));
        for (int i = 1; i <= listRow.size(); i++) {
            webDriver.findElement(By.xpath("(//select[@aria-label='rows per page']/option)[" + i + "]"));
        }

        String cssOption5 = "option[value='5']";
        webDriver.findElement(By.cssSelector(cssOption5));

        String cssOption10 = "option[value='10']";
        webDriver.findElement(By.cssSelector(cssOption10));

        String cssOption20 = "option[value='20']";
        webDriver.findElement(By.cssSelector(cssOption20));

        String cssOption25 = "option[value='25']";
        webDriver.findElement(By.cssSelector(cssOption25));

        String cssOption50 = "option[value='50']";
        webDriver.findElement(By.cssSelector(cssOption50));

        String cssOption100 = "option[value='100']";
        webDriver.findElement(By.cssSelector(cssOption100));

        webDriver.findElement(By.xpath(xPathRows)).click();

    }

    @Test(description = "Locator for  Buttons Tab")
    public void buttonsTab() {
        String xPathButtonsTab = "//li[contains(@class,'btn btn-light')]//span[normalize-space()='Buttons']";
        scrollByVisibleElement(xPathButtonsTab);
        goToNavTab("Buttons", webDriver);

        String xPathDoubleClick = "//button[text()='Double Click Me']";
        String cssDoubleClick = "#doubleClickBtn";
        webDriver.findElement(By.xpath(xPathDoubleClick));
        webDriver.findElement(By.cssSelector(cssDoubleClick));

        String xPathRightClick = "//button[text()='Right Click Me']";
        String cssRightClick = "#rightClickBtn";
        webDriver.findElement(By.xpath(xPathRightClick));
        webDriver.findElement(By.cssSelector(cssRightClick));

        String xPathClick = "//button[text()='Click Me']";
        scrollByVisibleElement(xPathClick);
        webDriver.findElement(By.xpath(xPathClick));

    }

    @Test(description = "Locator for Links Tab")
    public void linksTab() {
        String xPathLinkTab = "//li[contains(@class,'btn btn-light')]//span[normalize-space()='Links']";
        scrollByVisibleElement(xPathLinkTab);
        goToNavTab("Links", webDriver);

        List<WebElement> linksElementXPath = webDriver.findElements(By.xpath("//div[@id='linkWrapper']/p"));
        for (int i = 1; i <= linksElementXPath.size(); i++) {
            webDriver.findElement(By.xpath("(//div[@id='linkWrapper']/p)[" + i + "]"));
        }

        String cssHome = "#simpleLink";
        webDriver.findElement(By.cssSelector(cssHome));

        String cssHome2 = "#dynamicLink";
        webDriver.findElement(By.cssSelector(cssHome2));

        String cssCreated = "#created";
        webDriver.findElement(By.cssSelector(cssCreated));

        String cssNoContent = "#no-content";
        webDriver.findElement(By.cssSelector(cssNoContent));

        String cssMoved = "#moved";
        webDriver.findElement(By.cssSelector(cssMoved));

        String cssBadRequest = "#bad-request";
        webDriver.findElement(By.cssSelector(cssBadRequest));

        String cssUnauthorized = "#unauthorized";
        webDriver.findElement(By.cssSelector(cssUnauthorized));

        String cssForbidden = "#forbidden";
        webDriver.findElement(By.cssSelector(cssForbidden));

        String cssNotFound = "#invalid-url";
        webDriver.findElement(By.cssSelector(cssNotFound));
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
