package nganttt.btvn;

import common.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BTVN02 extends TestBase {
    WebDriver webDriver;

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
        webDriver = new ChromeDriver();
        gotoDemoQAWebsite(webDriver);
        webDriver.manage().window().maximize();
    }

    @BeforeMethod
    public void beforeMethod() {
        gotoDemoQAWebsite(webDriver);
        webDriver.manage().window().maximize();

    }

    @Test(description = "Locator by Contains")
    public void locateByContains() {
        //navTab
        String xPathTextBoxNav = "//span[contains(text(),'Text Box')]";
        webDriver.findElement(By.xpath(xPathTextBoxNav));

        String xPathCheckBoxNav = "//span[contains(text(),'Check Box')]";
        webDriver.findElement(By.xpath(xPathCheckBoxNav));

        String xPathRadioButtonNav = "//span[contains(text(),'Radio Button')]";
        webDriver.findElement(By.xpath(xPathRadioButtonNav));

        String xPathWebTablesNav = "//span[contains(text(),'Web Tables')]";
        webDriver.findElement(By.xpath(xPathWebTablesNav));

        String xPathButtonsNav = "//span[contains(text(),'Buttons')]";
        webDriver.findElement(By.xpath(xPathButtonsNav));

        String xPathLinksNav = "//span[contains(text(),'Links')]";
        webDriver.findElement(By.xpath(xPathLinksNav));

        String xPathBrokenLinksNav = "//span[contains(text(),'Broken Links')]";
        webDriver.findElement(By.xpath(xPathBrokenLinksNav));

        String xPathUploadNav = "//span[contains(text(),'Upload')]";
        webDriver.findElement(By.xpath(xPathUploadNav));

        String xPathDynamicPropertiesNav = "//span[contains(text(),'Dynamic Properties')]";
        webDriver.findElement(By.xpath(xPathDynamicPropertiesNav));
        //9

        //textbox
        goToNavTab("Text Box", webDriver);
        String xPathFullNameLabel = "//label[contains(text(),'Full Name')]";
        webDriver.findElement(By.xpath(xPathFullNameLabel));

        String xPathEmailLabel = "//label[contains(text(),'Email')]";
        webDriver.findElement(By.xpath(xPathEmailLabel));

        String xPathCurrentAddressLabel = "//label[contains(text(),'Current Address')]";
        webDriver.findElement(By.xpath(xPathCurrentAddressLabel));

        String xPathPermanentAddressLabel = "//label[contains(text(),'Permanent Address')]";
        webDriver.findElement(By.xpath(xPathPermanentAddressLabel));

        String xPathFullNameInput = "//input[contains(@placeholder,'Full Name')]";
        webDriver.findElement(By.xpath(xPathFullNameInput));

        String xPathEmailInput = "//input[contains(@type,'email')]";
        webDriver.findElement(By.xpath(xPathEmailInput));

        String xPathCurrentAddressInput = "//textarea[contains(@placeholder,'Current Address')]";
        webDriver.findElement(By.xpath(xPathCurrentAddressInput));

        String xPathSubmit = "//button[contains(text(),'Submit')]";
        webDriver.findElement(By.xpath(xPathSubmit));
        //8

        //checkbox
        goToNavTab("Check Box", webDriver);
        String xPathExpandButton = "//button[contains(@title,'Expand')]";
        webDriver.findElement(By.xpath(xPathExpandButton));
        webDriver.findElement(By.xpath(xPathExpandButton)).click();

        String xPathCollapseButton = "//button[contains(@title,'Collapse')]";
        webDriver.findElement(By.xpath(xPathCollapseButton));

        String xPathCheckBoxHome = "//label[contains(@for,'home')]/span[contains(@class,'checkbox')]";
        webDriver.findElement(By.xpath(xPathCheckBoxHome));

        String xPathIconHome = "//label[contains(@for,'home')]/span[contains(@class,'icon')]";
        webDriver.findElement(By.xpath(xPathIconHome));

        String xPathTitleHome = "//span[contains(text(),'Home')]";
        webDriver.findElement(By.xpath(xPathTitleHome));

        String xPathCheckBoxDesktop = "//label[contains(@for,'desktop')]/span[contains(@class,'checkbox')]";
        webDriver.findElement(By.xpath(xPathCheckBoxDesktop));

        String xPathIconDesktop = "//label[contains(@for,'desktop')]/span[contains(@class,'icon')]";
        webDriver.findElement(By.xpath(xPathIconDesktop));

        String xPathTitleDesktop = "//span[contains(text(),'Desktop')]";
        webDriver.findElement(By.xpath(xPathTitleDesktop));

        String xPathCheckBoxNotes = "//label[contains(@for,'notes')]/span[contains(@class,'checkbox')]";
        webDriver.findElement(By.xpath(xPathCheckBoxNotes));

        String xPathIconNotes = "//label[contains(@for,'notes')]/span[contains(@class,'icon')]";
        webDriver.findElement(By.xpath(xPathIconNotes));

        String xPathTitleNotes = "//span[contains(text(),'Notes')]";
        webDriver.findElement(By.xpath(xPathTitleNotes));

        String xPathCheckBoxCommands = "//label[contains(@for,'commands')]/span[contains(@class,'checkbox')]";
        webDriver.findElement(By.xpath(xPathCheckBoxCommands));

        String xPathIconCommands = "//label[contains(@for,'commands')]/span[contains(@class,'icon')]";
        webDriver.findElement(By.xpath(xPathIconCommands));

        String xPathTitleCommands = "//span[contains(text(),'Commands')]";
        webDriver.findElement(By.xpath(xPathTitleCommands));
        //14

    }


    @Test(description = "Locator by Text")
    public void locateByText(){
        //checkbox
        goToNavTab("Check Box", webDriver);
        String xPathExpandButton = "//button[contains(@title,'Expand')]";
        webDriver.findElement(By.xpath(xPathExpandButton));
        webDriver.findElement(By.xpath(xPathExpandButton)).click();

        String xPathTitleDocuments = "//span[text()='Commands']";
        webDriver.findElement(By.xpath(xPathTitleDocuments));

        String xPathTitleWorkSpace = "//span[text()='WorkSpace']";
        webDriver.findElement(By.xpath(xPathTitleWorkSpace));

        String xPathTitleReact = "//span[text()='React']";
        webDriver.findElement(By.xpath(xPathTitleReact));

        String xPathTitleAngular = "//span[text()='Angular']";
        webDriver.findElement(By.xpath(xPathTitleAngular));

        String xPathTitleVeu = "//span[text()='Veu']";
        webDriver.findElement(By.xpath(xPathTitleVeu));

        String xPathTitleOffice = "//span[text()='Office']";
        webDriver.findElement(By.xpath(xPathTitleOffice));

        String xPathTitlePublic = "//span[text()='Public']";
        webDriver.findElement(By.xpath(xPathTitlePublic));

        String xPathTitlePrivate = "//span[text()='Private']";
        webDriver.findElement(By.xpath(xPathTitlePrivate));

        String xPathTitleClassified = "//span[text()='Classified']";
        webDriver.findElement(By.xpath(xPathTitleClassified));

        String xPathTitleGeneral = "//span[text()='General']";
        webDriver.findElement(By.xpath(xPathTitleGeneral));

        String xPathTitleDownloads = "//span[text()='Downloads']";
        webDriver.findElement(By.xpath(xPathTitleDownloads));

        String xPathTitleWordFile = "//span[text()='Word File.doc']";
        webDriver.findElement(By.xpath(xPathTitleWordFile));

        String xPathTitleExcelFile = "//span[text()='Excel File.doc']";
        webDriver.findElement(By.xpath(xPathTitleExcelFile));
        //13

        //Radio Button
        goToNavTab("Radio Button", webDriver);

        String xPathYesRadioButton = "//label[text()='Yes']/preceding-sibling::input";
        webDriver.findElement(By.xpath(xPathYesRadioButton));

        String xPathImpressiveRadioButton = "//label[text()='Impressive']/preceding-sibling::input";
        webDriver.findElement(By.xpath(xPathImpressiveRadioButton));

        String xPathNoRadioButton = "//label[text()='Impressive']/preceding-sibling::input";
        webDriver.findElement(By.xpath(xPathNoRadioButton));
        //3

        //Web Tables
        goToNavTab("Web Tables", webDriver);

        String xPathButtonAdd = "//button[text()='Add']";
        webDriver.findElement(By.xpath(xPathButtonAdd));

        String xPathButtonPrevious = "//button[text()='Previous']";
        webDriver.findElement(By.xpath(xPathButtonPrevious));

        String xPathButtonNext = "//button[text()='Next']";
        webDriver.findElement(By.xpath(xPathButtonNext));


        webDriver.findElement(By.xpath("//select[@aria-label='rows per page']"));

        String xPathButtonOption5 = "//option[text()='5 rows']";
        webDriver.findElement(By.xpath(xPathButtonOption5));

        String xPathButtonOption10 = "//option[text()='10 rows']";
        webDriver.findElement(By.xpath(xPathButtonOption10));

        String xPathButtonOption20 = "//option[text()='20 rows']";
        webDriver.findElement(By.xpath(xPathButtonOption20));

        String xPathButtonOption25 = "//option[text()='25 rows']";
        webDriver.findElement(By.xpath(xPathButtonOption25));

        String xPathButtonOption50 = "//option[text()='50 rows']";
        webDriver.findElement(By.xpath(xPathButtonOption50));

        String xPathButtonOption100 = "//option[text()='100 rows']";
        webDriver.findElement(By.xpath(xPathButtonOption100));
        //9

        //Links
        String xPathLinkTab = "//li[contains(@class,'btn btn-light')]//span[normalize-space()='Links']";
        scrollByVisibleElement(xPathLinkTab);
        goToNavTab("Links", webDriver);

        String xPathLinkHome = "//a[text()='Home']";
        webDriver.findElement(By.xpath(xPathLinkHome));

        String xPathLinkCreated = "//a[text()='Created']";
        webDriver.findElement(By.xpath(xPathLinkCreated));

        String xPathLinkNoContent = "//a[text()='No Content']";
        webDriver.findElement(By.xpath(xPathLinkNoContent));

        String xPathLinkMoved = "//a[text()='Moved']";
        webDriver.findElement(By.xpath(xPathLinkMoved));

        String xPathLinkBadRequest = "//a[text()='Bad Request']";
        webDriver.findElement(By.xpath(xPathLinkBadRequest));

        String xPathLinkUnauthorized = "//a[text()='Unauthorized']";
        webDriver.findElement(By.xpath(xPathLinkUnauthorized));

        String xPathLinkForbidden = "//a[text()='Forbidden']";
        webDriver.findElement(By.xpath(xPathLinkForbidden));

        String xPathLinkNotFound = "//a[text()='Not Found']";
        webDriver.findElement(By.xpath(xPathLinkNotFound));
        //8
    }

    @Test(description = "Locator by Starts with")
    public void locateByStartsWith() {
        //checkbox
        goToNavTab("Check Box", webDriver);

        String xPathTextBoxNav = "//span[starts-with(text(),'Text Box')]";
        webDriver.findElement(By.xpath(xPathTextBoxNav));

        String xPathCheckBoxNav = "//span[starts-with(text(),'Check Box')]";
        webDriver.findElement(By.xpath(xPathCheckBoxNav));

        String xPathRadioButtonNav = "//span[starts-with(text(),'Radio Button')]";
        webDriver.findElement(By.xpath(xPathRadioButtonNav));

        String xPathWebTablesNav = "//span[starts-with(text(),'Web Tables')]";
        webDriver.findElement(By.xpath(xPathWebTablesNav));

        String xPathButtonsNav = "//span[starts-with(text(),'Buttons')]";
        webDriver.findElement(By.xpath(xPathButtonsNav));

        String xPathLinksNav = "//span[starts-with(text(),'Links')]";
        webDriver.findElement(By.xpath(xPathLinksNav));

        String xPathBrokenLinksNav = "//span[starts-with(text(),'Broken Links')]";
        webDriver.findElement(By.xpath(xPathBrokenLinksNav));

        String xPathUploadNav = "//span[starts-with(text(),'Upload')]";
        webDriver.findElement(By.xpath(xPathUploadNav));


        String xPathDynamicPropertiesNav = "//span[starts-with(text(),'Dynamic Properties')]";
        webDriver.findElement(By.xpath(xPathDynamicPropertiesNav));
        //9

        //textbox
        goToNavTab("Text Box", webDriver);
        String xPathFullNameLabel = "//label[starts-with(text(),'Full Name')]";
        webDriver.findElement(By.xpath(xPathFullNameLabel));

        String xPathEmailLabel = "//label[starts-with(text(),'Email')]";
        webDriver.findElement(By.xpath(xPathEmailLabel));

        String xPathCurrentAddressLabel = "//label[starts-with(text(),'Current Address')]";
        webDriver.findElement(By.xpath(xPathCurrentAddressLabel));

        String xPathPermanentAddressLabel = "//label[starts-with(text(),'Permanent Address')]";
        webDriver.findElement(By.xpath(xPathPermanentAddressLabel));

        String xPathFullNameInput = "//input[starts-with(@placeholder,'Full Name')]";
        webDriver.findElement(By.xpath(xPathFullNameInput));

        String xPathEmailInput = "//input[starts-with(@type,'email')]";
        webDriver.findElement(By.xpath(xPathEmailInput));

        String xPathCurrentAddressInput = "//textarea[starts-with(@placeholder,'Current Address')]";
        webDriver.findElement(By.xpath(xPathCurrentAddressInput));

        String xPathSubmit = "//button[starts-with(text(),'Submit')]";
        webDriver.findElement(By.xpath(xPathSubmit));
        //8

        //checkbox
        goToNavTab("Check Box", webDriver);
        String xPathExpandButton = "//button[starts-with(@title,'Expand')]";
        webDriver.findElement(By.xpath(xPathExpandButton));
        webDriver.findElement(By.xpath(xPathExpandButton)).click();

        String xPathCollapseButton = "//button[starts-with(@title,'Collapse')]";
        webDriver.findElement(By.xpath(xPathCollapseButton));

        String xPathTitleHome = "//span[starts-with(text(),'Home')]";
        webDriver.findElement(By.xpath(xPathTitleHome));

        String xPathTitleDesktop = "//span[starts-with(text(),'Desktop')]";
        webDriver.findElement(By.xpath(xPathTitleDesktop));

        String xPathTitleNotes = "//span[starts-with(text(),'Notes')]";
        webDriver.findElement(By.xpath(xPathTitleNotes));

        String xPathTitleCommands = "//span[starts-with(text(),'Commands')]";
        webDriver.findElement(By.xpath(xPathTitleCommands));
        //5

        String xPathLinkTab = "//li[contains(@class,'btn btn-light')]//span[normalize-space()='Links']";
        scrollByVisibleElement(xPathLinkTab);
        //link
        goToNavTab("Links", webDriver);

        String xPathHome = "//a[starts-with(text(),'Home')][1]";
        webDriver.findElement(By.xpath(xPathHome));

        String xPathHome2 = "(//a[starts-with(text(),'Home')])[2]";
        webDriver.findElement(By.xpath(xPathHome2));

        String xPathCreated = "//a[starts-with(text(),'Created')]";
        webDriver.findElement(By.xpath(xPathCreated));

        String xPathNoContent = "//a[starts-with(text(),'No')]";
        webDriver.findElement(By.xpath(xPathNoContent));

        String xPathMoved = "//a[starts-with(text(),'Moved')]";
        webDriver.findElement(By.xpath(xPathMoved));

        String xPathBadRequest = "//a[starts-with(text(),'Bad')]";
        webDriver.findElement(By.xpath(xPathBadRequest));

        String xPathUnauthorized = "//a[starts-with(text(),'Unauth')]";
        webDriver.findElement(By.xpath(xPathUnauthorized));

        String xPathForbidden = "//a[starts-with(text(),'Forbidden')]";
        webDriver.findElement(By.xpath(xPathForbidden));

        String xPathNotFound = "//a[starts-with(text(),'Not')]";
        webDriver.findElement(By.xpath(xPathNotFound));
        //9

    }

    @Test(description = "Locator by Position")
    public void locateByPosition() {
        //Web Tables
        goToNavTab("Web Tables", webDriver);

        String xPathSearchBox = "(//input)[position()=1]";
        webDriver.findElement(By.xpath(xPathSearchBox));

        String xPathPageJump = "(//input)[position()=2]";
        scrollByVisibleElement(xPathPageJump);
        webDriver.findElement(By.xpath(xPathPageJump));

        String xPathButtonAdd = "(//button[@type='button'])[position()=2]";
        webDriver.findElement(By.xpath(xPathButtonAdd));

        String xPathButtonPrevious = "(//button[@type='button'])[position()=3]";
        webDriver.findElement(By.xpath(xPathButtonPrevious));

        String xPathButtonNext = "(//button[@type='button'])[position()=4]";
        webDriver.findElement(By.xpath(xPathButtonNext));

        webDriver.findElement(By.xpath(xPathButtonAdd)).click();

        String xPathFirstNameLabel = "(//label[@class='form-label'])[position()=1]";
        webDriver.findElement(By.xpath(xPathFirstNameLabel));

        String xPathLastNameLabel = "(//label[@class='form-label'])[position()=2]";
        webDriver.findElement(By.xpath(xPathLastNameLabel));

        String xPathEmailLabel = "(//label[@class='form-label'])[position()=3]";
        webDriver.findElement(By.xpath(xPathEmailLabel));

        String xPathAgeLabel = "(//label[@class='form-label'])[position()=4]";
        webDriver.findElement(By.xpath(xPathAgeLabel));

        String xPathSalaryLabel = "(//label[@class='form-label'])[position()=5]";
        webDriver.findElement(By.xpath(xPathSalaryLabel));

        String xPathDepartmentLabel = "(//label[@class='form-label'])[position()=6]";
        webDriver.findElement(By.xpath(xPathDepartmentLabel));

        String xPathFirstNameInput = "(//div[@class='modal-body']/descendant::input)[position()=1]";
        webDriver.findElement(By.xpath(xPathFirstNameInput));

        String xPathLastNameInput = "(//div[@class='modal-body']/descendant::input)[position()=2]";
        webDriver.findElement(By.xpath(xPathLastNameInput));

        String xPathEmailInput = "(//div[@class='modal-body']/descendant::input)[position()=3]";
        webDriver.findElement(By.xpath(xPathEmailInput));

        String xPathAgeInput = "(//div[@class='modal-body']/descendant::input)[position()=4]";
        webDriver.findElement(By.xpath(xPathAgeInput));

        String xPathSalaryInput = "(//div[@class='modal-body']/descendant::input)[position()=5]";
        webDriver.findElement(By.xpath(xPathSalaryInput));

        String xPathDepartmentInput = "(//div[@class='modal-body']/descendant::input)[position()=6]";
        webDriver.findElement(By.xpath(xPathDepartmentInput));

        String xPathExitForm = "//button[@class='close']/span[1]";
        webDriver.findElement(By.xpath(xPathExitForm));
        webDriver.findElement(By.xpath(xPathExitForm)).click();
        waitForDebug(2000);
        //18

        //form
        String xPathForms = "(//div[@class='header-text'])[2]/parent::div";
        scrollByVisibleElement(xPathForms);
        waitForDebug(2000);
        webDriver.findElement(By.xpath(xPathForms)).click();
        waitForDebug(2000);

        String xPathPracticeForm = "//span[text()='Practice Form']";
        webDriver.findElement(By.xpath(xPathPracticeForm)).click();

        String xPathFormFirstNameInput = "(//div/descendant::input)[position()=1]";
        webDriver.findElement(By.xpath(xPathFormFirstNameInput));

        String xPathFormLastNameInput = "(//div/descendant::input)[position()=2]";
        webDriver.findElement(By.xpath(xPathFormLastNameInput));

        String xPathFormEmailInput = "(//div/descendant::input)[position()=3]";
        webDriver.findElement(By.xpath(xPathFormEmailInput));

        String xPathFormMaleInput = "(//div/descendant::input)[position()=4]";
        webDriver.findElement(By.xpath(xPathFormMaleInput));

        String xPathFormFemaleInput = "(//div/descendant::input)[position()=5]";
        webDriver.findElement(By.xpath(xPathFormFemaleInput));

        String xPathFormOtherInput = "(//div/descendant::input)[position()=6]";
        webDriver.findElement(By.xpath(xPathFormOtherInput));

        String xPathFormMobileInput = "(//div/descendant::input)[position()=7]";
        webDriver.findElement(By.xpath(xPathFormMobileInput));

        String xPathFormDoBInput = "(//div/descendant::input)[position()=8]";
        webDriver.findElement(By.xpath(xPathFormDoBInput));

        String xPathFormSubjectsInput = "(//div/descendant::input)[position()=9]";
        webDriver.findElement(By.xpath(xPathFormSubjectsInput));

        String xPathFormSportsInput = "(//div/descendant::input)[position()=10]";
        webDriver.findElement(By.xpath(xPathFormSportsInput));

        String xPathFormReadingInput = "(//div/descendant::input)[position()=11]";
        webDriver.findElement(By.xpath(xPathFormReadingInput));

        String xPathFormMusicInput = "(//div/descendant::input)[position()=12]";
        webDriver.findElement(By.xpath(xPathFormMusicInput));
        //12

    }

    @Test(description = "Locator by Ancestor") //tổ tiên
    public void locateByAncestor() {
        //checkbox
        goToNavTab("Check Box", webDriver);

        webDriver.findElement(By.xpath("//button[@title='Expand all']")).click();

        String xPathCheckboxHome = "//span[text()='Home']/ancestor::label/span[1]";
        webDriver.findElement(By.xpath(xPathCheckboxHome));

        String xPathCheckboxDesktop = "//span[text()='Desktop']/ancestor::label/span[1]";
        webDriver.findElement(By.xpath(xPathCheckboxDesktop));

        String xPathCheckboxNotes = "//span[text()='Notes']/ancestor::label/span[1]";
        webDriver.findElement(By.xpath(xPathCheckboxNotes));

        String xPathCheckboxCommands = "//span[text()='Commands']/ancestor::label/span[1]";
        webDriver.findElement(By.xpath(xPathCheckboxCommands));

        String xPathCheckboxDocuments = "//span[text()='Documents']/ancestor::label/span[contains(@class,'checkbox')]";
        webDriver.findElement(By.xpath(xPathCheckboxDocuments));

        String xPathCheckboxWorkSpace = "//span[text()='WorkSpace']/ancestor::label/span[contains(@class,'checkbox')]";
        webDriver.findElement(By.xpath(xPathCheckboxWorkSpace));

        String xPathCheckboxReact = "//span[text()='React']/ancestor::label/span[contains(@class,'checkbox')]";
        webDriver.findElement(By.xpath(xPathCheckboxReact));

        String xPathCheckboxAngular = "//span[text()='Angular']/ancestor::label/span[contains(@class,'checkbox')]";
        webDriver.findElement(By.xpath(xPathCheckboxAngular));

        String xPathCheckboxVeu = "//span[text()='Veu']/ancestor::label/span[contains(@class,'checkbox')]";
        webDriver.findElement(By.xpath(xPathCheckboxVeu));

        String xPathCheckboxOffice = "//span[text()='Office']/ancestor::label/span[contains(@class,'checkbox')]";
        webDriver.findElement(By.xpath(xPathCheckboxOffice));

        String xPathCheckboxPublic = "//span[text()='Public']/ancestor::label/span[contains(@class,'checkbox')]";
        webDriver.findElement(By.xpath(xPathCheckboxPublic));

        String xPathCheckboxPrivate = "//span[text()='Private']/ancestor::label/span[contains(@class,'checkbox')]";
        webDriver.findElement(By.xpath(xPathCheckboxPrivate));

        String xPathCheckboxClassified = "//span[text()='Classified']/ancestor::label/span[contains(@class,'checkbox')]";
        webDriver.findElement(By.xpath(xPathCheckboxClassified));

        String xPathCheckboxGeneral = "//span[text()='General']/ancestor::label/span[contains(@class,'checkbox')]";
        webDriver.findElement(By.xpath(xPathCheckboxGeneral));

        String xPathCheckboxDownloads = "//span[text()='Downloads']/ancestor::label/span[contains(@class,'checkbox')]";
        webDriver.findElement(By.xpath(xPathCheckboxDownloads));

        String xPathCheckboxWord = "//span[contains(text(),'Word')]/ancestor::label/span[1]";
        webDriver.findElement(By.xpath(xPathCheckboxWord));

        String xPathCheckboxExcel = "//span[contains(text(),'Excel')]/ancestor::label/span[1]";
        webDriver.findElement(By.xpath(xPathCheckboxExcel));
        //17

        //form
        String xPathForms = "(//div[@class='header-text'])[2]/parent::div";
        scrollByVisibleElement(xPathForms);
        waitForDebug(2000);
        webDriver.findElement(By.xpath(xPathForms)).click();
        waitForDebug(2000);

        String xPathPracticeForm = "//span[text()='Practice Form']";
        webDriver.findElement(By.xpath(xPathPracticeForm)).click();

        String xPathFormFirstNameInput = "//label[contains(text(),'Name')]/ancestor::div[@class='mt-2 row']/descendant::input[1]";
        webDriver.findElement(By.xpath(xPathFormFirstNameInput));

        String xPathFormLastNameInput = "//label[contains(text(),'Name')]/ancestor::div[@class='mt-2 row']/descendant::input[2]";
        webDriver.findElement(By.xpath(xPathFormLastNameInput));

        String xPathFormEmailInput = "//label[contains(text(),'Email')]/ancestor::div[@class='mt-2 row']/descendant::input";
        webDriver.findElement(By.xpath(xPathFormEmailInput));

        String xPathFormMaleInput = "//div[contains(text(),'Gender')]/ancestor::div[@class='mt-2 row']/descendant::input[1]";
        webDriver.findElement(By.xpath(xPathFormMaleInput));

        String xPathFormFemaleInput = "//div[contains(text(),'Gender')]/ancestor::div[@class='mt-2 row']/descendant::input[2]";
        webDriver.findElement(By.xpath(xPathFormFemaleInput));

        String xPathFormOtherInput = "//div[contains(text(),'Gender')]/ancestor::div[@class='mt-2 row']/descendant::input[3]";
        webDriver.findElement(By.xpath(xPathFormOtherInput));

        String xPathFormMobileInput = "//label[contains(text(),'Mobile')]/ancestor::div[@class='mt-2 row']/descendant::input";
        webDriver.findElement(By.xpath(xPathFormMobileInput));

        String xPathFormDoBInput = "//label[contains(text(),'Date')]/ancestor::div[@class='mt-2 row']/descendant::input";
        webDriver.findElement(By.xpath(xPathFormDoBInput));

        String xPathFormSubjectsInput = "//label[contains(text(),'Subjects')]/ancestor::div[@class='mt-2 row']/descendant::input";
        webDriver.findElement(By.xpath(xPathFormSubjectsInput));

        String xPathFormSportsInput = "//label[contains(text(),'Hobbies')]/ancestor::div[@class='mt-2 row']/descendant::input[1]";
        webDriver.findElement(By.xpath(xPathFormSportsInput));

        String xPathFormReadingInput = "//label[contains(text(),'Hobbies')]/ancestor::div[@class='mt-2 row']/descendant::input[2]";
        webDriver.findElement(By.xpath(xPathFormReadingInput));

        String xPathFormMusicInput = "//label[contains(text(),'Hobbies')]/ancestor::div[@class='mt-2 row']/descendant::input[3]";
        webDriver.findElement(By.xpath(xPathFormMusicInput));

        String xPathFormPictureInput = "//label[contains(text(),'Picture')]/ancestor::div[@class='mt-2 row']/descendant::input";
        webDriver.findElement(By.xpath(xPathFormPictureInput));
        //13

    }

    @Test(description = "Locator by Descendant") //con cháu
    public void locateByDescendant() {
        //checkbox
        goToNavTab("Check Box", webDriver);

        webDriver.findElement(By.xpath("//button[@title='Expand all']")).click();

        String xPathCheckboxHome = "//label[contains(@for,'home')]/descendant::span[contains(@class,'checkbox')]";
        webDriver.findElement(By.xpath(xPathCheckboxHome));

        String xPathCheckboxDesktop = "//label[contains(@for,'desktop')]/descendant::span[contains(@class,'checkbox')]";
        webDriver.findElement(By.xpath(xPathCheckboxDesktop));

        String xPathCheckboxNotes = "//label[contains(@for,'notes')]/descendant::span[contains(@class,'checkbox')]";
        webDriver.findElement(By.xpath(xPathCheckboxNotes));

        String xPathCheckboxCommands = "//label[contains(@for,'commands')]/descendant::span[contains(@class,'checkbox')]";
        webDriver.findElement(By.xpath(xPathCheckboxCommands));

        String xPathCheckboxDocuments = "//label[contains(@for,'documents')]/descendant::span[contains(@class,'checkbox')]";
        webDriver.findElement(By.xpath(xPathCheckboxDocuments));

        String xPathCheckboxWorkSpace = "//label[contains(@for,'workspace')]/descendant::span[contains(@class,'checkbox')]";
        webDriver.findElement(By.xpath(xPathCheckboxWorkSpace));

        String xPathCheckboxReact = "//label[contains(@for,'react')]/descendant::span[contains(@class,'checkbox')]";
        webDriver.findElement(By.xpath(xPathCheckboxReact));

        String xPathCheckboxAngular = "//label[contains(@for,'angular')]/descendant::span[contains(@class,'checkbox')]";
        webDriver.findElement(By.xpath(xPathCheckboxAngular));

        String xPathCheckboxVeu = "//label[contains(@for,'veu')]/descendant::span[contains(@class,'checkbox')]";
        webDriver.findElement(By.xpath(xPathCheckboxVeu));

        String xPathCheckboxOffice = "//label[contains(@for,'office')]/descendant::span[contains(@class,'checkbox')]";
        webDriver.findElement(By.xpath(xPathCheckboxOffice));

        String xPathCheckboxPublic = "//label[contains(@for,'public')]/descendant::span[contains(@class,'checkbox')]";
        webDriver.findElement(By.xpath(xPathCheckboxPublic));

        String xPathCheckboxPrivate = "//label[contains(@for,'private')]/descendant::span[contains(@class,'checkbox')]";
        webDriver.findElement(By.xpath(xPathCheckboxPrivate));

        String xPathCheckboxClassified = "//label[contains(@for,'classified')]/descendant::span[contains(@class,'checkbox')]";
        webDriver.findElement(By.xpath(xPathCheckboxClassified));

        String xPathCheckboxGeneral = "//label[contains(@for,'general')]/descendant::span[contains(@class,'checkbox')]";
        webDriver.findElement(By.xpath(xPathCheckboxGeneral));

        String xPathCheckboxDownloads = "//label[contains(@for,'downloads')]/descendant::span[contains(@class,'checkbox')]";
        webDriver.findElement(By.xpath(xPathCheckboxDownloads));

        String xPathCheckboxWord = "//label[contains(@for,'word')]/descendant::span[contains(@class,'checkbox')]";
        webDriver.findElement(By.xpath(xPathCheckboxWord));

        String xPathCheckboxExcel = "//label[contains(@for,'excel')]/descendant::span[contains(@class,'checkbox')]";
        webDriver.findElement(By.xpath(xPathCheckboxExcel));
        //17

        //form
        String xPathForms = "(//div[@class='header-text'])[2]/parent::div";
        scrollByVisibleElement(xPathForms);
        waitForDebug(2000);
        webDriver.findElement(By.xpath(xPathForms)).click();
        waitForDebug(2000);

        String xPathPracticeForm = "//span[text()='Practice Form']";
        webDriver.findElement(By.xpath(xPathPracticeForm)).click();

        String xPathFormFirstNameInput = "//label[contains(text(),'Name')]/ancestor::div[@class='mt-2 row']/descendant::input[1]";
        webDriver.findElement(By.xpath(xPathFormFirstNameInput));

        String xPathFormLastNameInput = "//label[contains(text(),'Name')]/ancestor::div[@class='mt-2 row']/descendant::input[2]";
        webDriver.findElement(By.xpath(xPathFormLastNameInput));

        String xPathFormEmailInput = "//label[contains(text(),'Email')]/ancestor::div[@class='mt-2 row']/descendant::input";
        webDriver.findElement(By.xpath(xPathFormEmailInput));

        String xPathFormMaleInput = "//div[contains(text(),'Gender')]/ancestor::div[@class='mt-2 row']/descendant::input[1]";
        webDriver.findElement(By.xpath(xPathFormMaleInput));

        String xPathFormFemaleInput = "//div[contains(text(),'Gender')]/ancestor::div[@class='mt-2 row']/descendant::input[2]";
        webDriver.findElement(By.xpath(xPathFormFemaleInput));

        String xPathFormOtherInput = "//div[contains(text(),'Gender')]/ancestor::div[@class='mt-2 row']/descendant::input[3]";
        webDriver.findElement(By.xpath(xPathFormOtherInput));

        String xPathFormMobileInput = "//label[contains(text(),'Mobile')]/ancestor::div[@class='mt-2 row']/descendant::input";
        webDriver.findElement(By.xpath(xPathFormMobileInput));

        String xPathFormDoBInput = "//label[contains(text(),'Date')]/ancestor::div[@class='mt-2 row']/descendant::input";
        webDriver.findElement(By.xpath(xPathFormDoBInput));

        String xPathFormSubjectsInput = "//label[contains(text(),'Subjects')]/ancestor::div[@class='mt-2 row']/descendant::input";
        webDriver.findElement(By.xpath(xPathFormSubjectsInput));

        String xPathFormSportsInput = "//label[contains(text(),'Hobbies')]/ancestor::div[@class='mt-2 row']/descendant::input[1]";
        webDriver.findElement(By.xpath(xPathFormSportsInput));

        String xPathFormReadingInput = "//label[contains(text(),'Hobbies')]/ancestor::div[@class='mt-2 row']/descendant::input[2]";
        webDriver.findElement(By.xpath(xPathFormReadingInput));

        String xPathFormMusicInput = "//label[contains(text(),'Hobbies')]/ancestor::div[@class='mt-2 row']/descendant::input[3]";
        webDriver.findElement(By.xpath(xPathFormMusicInput));

        String xPathFormPictureInput = "//label[contains(text(),'Picture')]/ancestor::div[@class='mt-2 row']/descendant::input";
        webDriver.findElement(By.xpath(xPathFormPictureInput));
        //13

    }

    @Test(description = "Locator by Following") //node dưới, k phải con cháu
    public void locateByFollowing() {
        //checkbox
        goToNavTab("Check Box", webDriver);

        webDriver.findElement(By.xpath("//button[@title='Expand all']")).click();

        String xPathCheckboxHome = "//input[contains(@id,'home')]/following::span[contains(@class,'checkbox')]";
        webDriver.findElement(By.xpath(xPathCheckboxHome));

        String xPathCheckboxDesktop = "//input[contains(@id,'desktop')]/following::span[contains(@class,'checkbox')]";
        webDriver.findElement(By.xpath(xPathCheckboxDesktop));

        String xPathCheckboxNotes = "//input[contains(@id,'notes')]/following::span[contains(@class,'checkbox')]";
        webDriver.findElement(By.xpath(xPathCheckboxNotes));

        String xPathCheckboxCommands = "//input[contains(@id,'commands')]/following::span[contains(@class,'checkbox')]";
        webDriver.findElement(By.xpath(xPathCheckboxCommands));

        String xPathCheckboxDocuments = "//input[contains(@id,'documents')]/following::span[contains(@class,'checkbox')]";
        webDriver.findElement(By.xpath(xPathCheckboxDocuments));

        String xPathCheckboxWorkSpace = "//input[contains(@id,'workspace')]/following::span[contains(@class,'checkbox')]";
        webDriver.findElement(By.xpath(xPathCheckboxWorkSpace));

        String xPathCheckboxReact = "//input[contains(@id,'react')]/following::span[contains(@class,'checkbox')]";
        webDriver.findElement(By.xpath(xPathCheckboxReact));

        String xPathCheckboxAngular = "//input[contains(@id,'angular')]/following::span[contains(@class,'checkbox')]";
        webDriver.findElement(By.xpath(xPathCheckboxAngular));

        String xPathCheckboxVeu = "//input[contains(@id,'veu')]/following::span[contains(@class,'checkbox')]";
        webDriver.findElement(By.xpath(xPathCheckboxVeu));

        String xPathCheckboxOffice = "//input[contains(@id,'office')]/following::span[contains(@class,'checkbox')]";
        webDriver.findElement(By.xpath(xPathCheckboxOffice));

        String xPathCheckboxPublic = "//input[contains(@id,'public')]/following::span[contains(@class,'checkbox')]";
        webDriver.findElement(By.xpath(xPathCheckboxPublic));

        String xPathCheckboxPrivate = "//input[contains(@id,'private')]/following::span[contains(@class,'checkbox')]";
        webDriver.findElement(By.xpath(xPathCheckboxPrivate));

        String xPathCheckboxClassified = "//input[contains(@id,'classified')]/following::span[contains(@class,'checkbox')]";
        webDriver.findElement(By.xpath(xPathCheckboxClassified));

        String xPathCheckboxGeneral = "//input[contains(@id,'general')]/following::span[contains(@class,'checkbox')]";
        webDriver.findElement(By.xpath(xPathCheckboxGeneral));

        String xPathCheckboxDownloads = "//input[contains(@id,'downloads')]/following::span[contains(@class,'checkbox')]";
        webDriver.findElement(By.xpath(xPathCheckboxDownloads));

        String xPathCheckboxWord = "//input[contains(@id,'word')]/following::span[contains(@class,'checkbox')]";
        webDriver.findElement(By.xpath(xPathCheckboxWord));

        String xPathCheckboxExcel = "//input[contains(@id,'excel')]/following::span[contains(@class,'checkbox')]";
        webDriver.findElement(By.xpath(xPathCheckboxExcel));
        //17

        //form
        String xPathForms = "(//div[@class='header-text'])[2]/parent::div";
        scrollByVisibleElement(xPathForms);
        waitForDebug(2000);
        webDriver.findElement(By.xpath(xPathForms)).click();
        waitForDebug(2000);

        String xPathPracticeForm = "//span[text()='Practice Form']";
        webDriver.findElement(By.xpath(xPathPracticeForm)).click();

        String xPathFormFirstNameInput = "//label[contains(text(),'Name')]/following::input[1]";
        webDriver.findElement(By.xpath(xPathFormFirstNameInput));

        String xPathFormLastNameInput = "//label[contains(text(),'Name')]/following::input[2]";
        webDriver.findElement(By.xpath(xPathFormLastNameInput));

        String xPathFormEmailInput = "//label[contains(text(),'Email')]/following::input";
        webDriver.findElement(By.xpath(xPathFormEmailInput));

        String xPathFormMaleInput = "//div[contains(text(),'Gender')]/following::input[1]";
        webDriver.findElement(By.xpath(xPathFormMaleInput));

        String xPathFormFemaleInput = "//div[contains(text(),'Gender')]/following::input[2]";
        webDriver.findElement(By.xpath(xPathFormFemaleInput));

        String xPathFormOtherInput = "//div[contains(text(),'Gender')]/following::input[3]";
        webDriver.findElement(By.xpath(xPathFormOtherInput));

        String xPathFormMobileInput = "//label[contains(text(),'Mobile')]/following::input";
        webDriver.findElement(By.xpath(xPathFormMobileInput));

        String xPathFormDoBInput = "//label[contains(text(),'Date')]/following::input";
        webDriver.findElement(By.xpath(xPathFormDoBInput));

        String xPathFormSubjectsInput = "//label[contains(text(),'Subjects')]/following::input";
        webDriver.findElement(By.xpath(xPathFormSubjectsInput));

        String xPathFormSportsInput = "//label[contains(text(),'Hobbies')]/following::input[1]";
        webDriver.findElement(By.xpath(xPathFormSportsInput));

        String xPathFormReadingInput = "//label[contains(text(),'Hobbies')]/following::input[2]";
        webDriver.findElement(By.xpath(xPathFormReadingInput));

        String xPathFormMusicInput = "//label[contains(text(),'Hobbies')]/following::input[3]";
        webDriver.findElement(By.xpath(xPathFormMusicInput));

        String xPathFormPictureInput = "//label[contains(text(),'Picture')]/following::input";
        webDriver.findElement(By.xpath(xPathFormPictureInput));
        //13
    }

    @Test(description = "Locator by Preceding") //node trên, k phải tổ tiên
    public void locateByPreceding() {
        //checkbox
        goToNavTab("Check Box", webDriver);

        webDriver.findElement(By.xpath("//button[@title='Expand all']")).click();

        String xPathCheckboxHome = "//span[contains(text(),'Home')]/preceding::span[2]";
        webDriver.findElement(By.xpath(xPathCheckboxHome));

        String xPathCheckboxDesktop = "//span[contains(text(),'Desktop')]/preceding::span[2]";
        webDriver.findElement(By.xpath(xPathCheckboxDesktop));

        String xPathCheckboxNotes = "//span[contains(text(),'Notes')]/preceding::span[2]";
        webDriver.findElement(By.xpath(xPathCheckboxNotes));

        String xPathCheckboxCommands = "//span[contains(text(),'Commands')]/preceding::span[2]";
        webDriver.findElement(By.xpath(xPathCheckboxCommands));

        String xPathCheckboxDocuments = "//span[contains(text(),'Documents')]/preceding::span[2]";
        webDriver.findElement(By.xpath(xPathCheckboxDocuments));

        String xPathCheckboxWorkSpace = "//span[contains(text(),'WorkSpace')]/preceding::span[2]";
        webDriver.findElement(By.xpath(xPathCheckboxWorkSpace));

        String xPathCheckboxReact = "//span[contains(text(),'React')]/preceding::span[2]";
        webDriver.findElement(By.xpath(xPathCheckboxReact));

        String xPathCheckboxAngular = "//span[contains(text(),'Angular')]/preceding::span[2]";
        webDriver.findElement(By.xpath(xPathCheckboxAngular));

        String xPathCheckboxVeu = "//span[contains(text(),'Veu')]/preceding::span[2]";
        webDriver.findElement(By.xpath(xPathCheckboxVeu));

        String xPathCheckboxOffice = "//span[contains(text(),'Office')]/preceding::span[2]";
        webDriver.findElement(By.xpath(xPathCheckboxOffice));

        String xPathCheckboxPublic = "//span[contains(text(),'Public')]/preceding::span[2]";
        webDriver.findElement(By.xpath(xPathCheckboxPublic));

        String xPathCheckboxPrivate = "//span[contains(text(),'Private')]/preceding::span[2]";
        webDriver.findElement(By.xpath(xPathCheckboxPrivate));

        String xPathCheckboxClassified = "//span[contains(text(),'Classified')]/preceding::span[2]";
        webDriver.findElement(By.xpath(xPathCheckboxClassified));

        String xPathCheckboxGeneral = "//span[contains(text(),'General')]/preceding::span[2]";
        webDriver.findElement(By.xpath(xPathCheckboxGeneral));

        String xPathCheckboxDownloads = "//span[contains(text(),'Downloads')]/preceding::span[2]";
        webDriver.findElement(By.xpath(xPathCheckboxDownloads));

        String xPathCheckboxWord = "//span[contains(text(),'Word')]/preceding::span[2]";
        webDriver.findElement(By.xpath(xPathCheckboxWord));

        String xPathCheckboxExcel = "//span[contains(text(),'Excel')]/preceding::span[2]";
        webDriver.findElement(By.xpath(xPathCheckboxExcel));
        //17

        //form
        String xPathForms = "(//div[@class='header-text'])[2]/parent::div";
        scrollByVisibleElement(xPathForms);
        waitForDebug(2000);
        webDriver.findElement(By.xpath(xPathForms)).click();
        waitForDebug(2000);

        String xPathPracticeForm = "//span[text()='Practice Form']";
        webDriver.findElement(By.xpath(xPathPracticeForm)).click();

        String xPathFormNameTitle = "//input[@placeholder='First Name']/preceding::label";
        webDriver.findElement(By.xpath(xPathFormNameTitle));

        String xPathFormEmailTitle = "//input[@placeholder='name@example.com']/preceding::label[text()='Email']";
        webDriver.findElement(By.xpath(xPathFormEmailTitle));

        String xPathFormFirstNameInput = "//input[@placeholder='name@example.com']/preceding::input[2]";
        webDriver.findElement(By.xpath(xPathFormFirstNameInput));

        String xPathFormLastNameInput = "//input[@placeholder='name@example.com']/preceding::input[1]";
        webDriver.findElement(By.xpath(xPathFormLastNameInput));

        String xPathFormEmailInput = "//input[@name='gender']/preceding::div[@class='col-md-9 col-sm-12']/input";
        webDriver.findElement(By.xpath(xPathFormEmailInput));

        String xPathFormGenderTitle = "//input[@name='gender']/preceding::div[text()='Gender']";
        webDriver.findElement(By.xpath(xPathFormGenderTitle));

        String xPathFormMobileTitle = "//input[@placeholder='Mobile Number']/preceding::label[text()='Mobile']";
        webDriver.findElement(By.xpath(xPathFormMobileTitle));

        String xPathFormDoBTitle = "//div[@id='dateOfBirth']/preceding::label[text()='Date of Birth']";
        webDriver.findElement(By.xpath(xPathFormDoBTitle));

        String xPathFormSubjectsTitle = "//div[@id='subjectsContainer']/preceding::label[text()='Subjects']";
        webDriver.findElement(By.xpath(xPathFormSubjectsTitle));

        String xPathFormHobbiesTitle = "//label[@for='hobbies-checkbox-1']/preceding::label[text()='Subjects']";
        webDriver.findElement(By.xpath(xPathFormHobbiesTitle));

        String xPathFormSportsInput = "//label[text()='Picture']//preceding::input[3]";
        webDriver.findElement(By.xpath(xPathFormSportsInput));

        String xPathFormReadingInput = "//label[text()='Picture']//preceding::input[2]";
        webDriver.findElement(By.xpath(xPathFormReadingInput));

        String xPathFormMusicInput = "//label[text()='Picture']//preceding::input[1]";
        webDriver.findElement(By.xpath(xPathFormMusicInput));

        String xPathFormPictureTitle = "//input[@type='file']/preceding::label[text()='Picture']";
        webDriver.findElement(By.xpath(xPathFormPictureTitle));
        //14
    }

    @Test(description = "Locator by Following Sibling") //node dưới, ngang hàng
    public void locateByFollowingSibling() {
        //checkbox
        goToNavTab("Check Box", webDriver);

        webDriver.findElement(By.xpath("//button[@title='Expand all']")).click();

        String xPathCheckboxHome = "//input[contains(@id,'home')]/following-sibling::span[contains(@class,'checkbox')]";
        webDriver.findElement(By.xpath(xPathCheckboxHome));

        String xPathCheckboxDesktop = "//input[contains(@id,'desktop')]/following-sibling::span[contains(@class,'checkbox')]";
        webDriver.findElement(By.xpath(xPathCheckboxDesktop));

        String xPathCheckboxNotes = "//input[contains(@id,'notes')]/following-sibling::span[contains(@class,'checkbox')]";
        webDriver.findElement(By.xpath(xPathCheckboxNotes));

        String xPathCheckboxCommands = "//input[contains(@id,'commands')]/following-sibling::span[contains(@class,'checkbox')]";
        webDriver.findElement(By.xpath(xPathCheckboxCommands));

        String xPathCheckboxDocuments = "//input[contains(@id,'documents')]/following-sibling::span[contains(@class,'checkbox')]";
        webDriver.findElement(By.xpath(xPathCheckboxDocuments));

        String xPathCheckboxWorkSpace = "//input[contains(@id,'workspace')]/following-sibling::span[contains(@class,'checkbox')]";
        webDriver.findElement(By.xpath(xPathCheckboxWorkSpace));

        String xPathCheckboxReact = "//input[contains(@id,'react')]/following-sibling::span[contains(@class,'checkbox')]";
        webDriver.findElement(By.xpath(xPathCheckboxReact));

        String xPathCheckboxAngular = "//input[contains(@id,'angular')]/following-sibling::span[contains(@class,'checkbox')]";
        webDriver.findElement(By.xpath(xPathCheckboxAngular));

        String xPathCheckboxVeu = "//input[contains(@id,'veu')]/following-sibling::span[contains(@class,'checkbox')]";
        webDriver.findElement(By.xpath(xPathCheckboxVeu));

        String xPathCheckboxOffice = "//input[contains(@id,'office')]/following-sibling::span[contains(@class,'checkbox')]";
        webDriver.findElement(By.xpath(xPathCheckboxOffice));

        String xPathCheckboxPublic = "//input[contains(@id,'public')]/following-sibling::span[contains(@class,'checkbox')]";
        webDriver.findElement(By.xpath(xPathCheckboxPublic));

        String xPathCheckboxPrivate = "//input[contains(@id,'private')]/following-sibling::span[contains(@class,'checkbox')]";
        webDriver.findElement(By.xpath(xPathCheckboxPrivate));

        String xPathCheckboxClassified = "//input[contains(@id,'classified')]/following-sibling::span[contains(@class,'checkbox')]";
        webDriver.findElement(By.xpath(xPathCheckboxClassified));

        String xPathCheckboxGeneral = "//input[contains(@id,'general')]/following-sibling::span[contains(@class,'checkbox')]";
        webDriver.findElement(By.xpath(xPathCheckboxGeneral));

        String xPathCheckboxDownloads = "//input[contains(@id,'downloads')]/following-sibling::span[contains(@class,'checkbox')]";
        webDriver.findElement(By.xpath(xPathCheckboxDownloads));

        String xPathCheckboxWord = "//input[contains(@id,'word')]/following-sibling::span[contains(@class,'checkbox')]";
        webDriver.findElement(By.xpath(xPathCheckboxWord));

        String xPathCheckboxExcel = "//input[contains(@id,'excel')]/following-sibling::span[contains(@class,'checkbox')]";
        webDriver.findElement(By.xpath(xPathCheckboxExcel));
        //17

        //form
        String xPathForms = "(//div[@class='header-text'])[2]/parent::div";
        scrollByVisibleElement(xPathForms);
        waitForDebug(2000);
        webDriver.findElement(By.xpath(xPathForms)).click();
        waitForDebug(2000);

        String xPathPracticeForm = "//span[text()='Practice Form']";
        webDriver.findElement(By.xpath(xPathPracticeForm)).click();

        String xPathFormFirstNameInput = "(//label[contains(text(),'Name')]/../following-sibling::div/input)[1]";
        webDriver.findElement(By.xpath(xPathFormFirstNameInput));

        String xPathFormLastNameInput = "(//label[contains(text(),'Name')]/../following-sibling::div/input)[2]";
        webDriver.findElement(By.xpath(xPathFormLastNameInput));

        String xPathFormEmailInput = "//label[contains(text(),'Email')]/../following-sibling::div/input";
        webDriver.findElement(By.xpath(xPathFormEmailInput));

        String xPathFormMaleInput = "(//div[contains(text(),'Gender')]/following-sibling::div/descendant::input)[1]";
        webDriver.findElement(By.xpath(xPathFormMaleInput));

        String xPathFormFemaleInput = "(//div[contains(text(),'Gender')]/following-sibling::div/descendant::input)[2]";
        webDriver.findElement(By.xpath(xPathFormFemaleInput));

        String xPathFormOtherInput = "(//div[contains(text(),'Gender')]/following-sibling::div/descendant::input)[3]";
        webDriver.findElement(By.xpath(xPathFormOtherInput));


        String xPathFormMobileInput = "//label[contains(text(),'Mobile')]/../following-sibling::div/descendant::input";
        webDriver.findElement(By.xpath(xPathFormMobileInput));

        String xPathFormDoBInput = "//label[contains(text(),'Date')]/../following-sibling::div/descendant::input";
        webDriver.findElement(By.xpath(xPathFormDoBInput));

        String xPathFormSubjectsInput = "//label[contains(text(),'Subjects')]/../following-sibling::div/descendant::input";
        webDriver.findElement(By.xpath(xPathFormSubjectsInput));

        String xPathFormSportsInput = "//label[contains(text(),'Hobbies')]/../following-sibling::div/descendant::input[1]";
        webDriver.findElement(By.xpath(xPathFormSportsInput));

        String xPathFormReadingInput = "//label[contains(text(),'Hobbies')]/../following-sibling::div/descendant::input[2]";
        webDriver.findElement(By.xpath(xPathFormReadingInput));

        String xPathFormMusicInput = "//label[contains(text(),'Hobbies')]/../following-sibling::div/descendant::input[3]";
        webDriver.findElement(By.xpath(xPathFormMusicInput));

        String xPathFormPictureInput = "//label[contains(text(),'Picture')]/../following-sibling::div/descendant::input";
        webDriver.findElement(By.xpath(xPathFormPictureInput));
        //13
    }

    @Test(description = "Locator by Preceding-sibling") //node trên, ngang hàng
    public void locateByPrecedingSibling() {
        //checkbox
        goToNavTab("Check Box", webDriver);

        webDriver.findElement(By.xpath("//button[@title='Expand all']")).click();

        String xPathCheckboxHome = "//span[contains(text(),'Home')]/preceding-sibling::span[2]";
        webDriver.findElement(By.xpath(xPathCheckboxHome));

        String xPathCheckboxDesktop = "//span[contains(text(),'Desktop')]/preceding-sibling::span[2]";
        webDriver.findElement(By.xpath(xPathCheckboxDesktop));

        String xPathCheckboxNotes = "//span[contains(text(),'Notes')]/preceding-sibling::span[2]";
        webDriver.findElement(By.xpath(xPathCheckboxNotes));

        String xPathCheckboxCommands = "//span[contains(text(),'Commands')]/preceding-sibling::span[2]";
        webDriver.findElement(By.xpath(xPathCheckboxCommands));

        String xPathCheckboxDocuments = "//span[contains(text(),'Documents')]/preceding-sibling::span[2]";
        webDriver.findElement(By.xpath(xPathCheckboxDocuments));

        String xPathCheckboxWorkSpace = "//span[contains(text(),'WorkSpace')]/preceding-sibling::span[2]";
        webDriver.findElement(By.xpath(xPathCheckboxWorkSpace));

        String xPathCheckboxReact = "//span[contains(text(),'React')]/preceding-sibling::span[2]";
        webDriver.findElement(By.xpath(xPathCheckboxReact));

        String xPathCheckboxAngular = "//span[contains(text(),'Angular')]/preceding-sibling::span[2]";
        webDriver.findElement(By.xpath(xPathCheckboxAngular));

        String xPathCheckboxVeu = "//span[contains(text(),'Veu')]/preceding-sibling::span[2]";
        webDriver.findElement(By.xpath(xPathCheckboxVeu));

        String xPathCheckboxOffice = "//span[contains(text(),'Office')]/preceding-sibling::span[2]";
        webDriver.findElement(By.xpath(xPathCheckboxOffice));

        String xPathCheckboxPublic = "//span[contains(text(),'Public')]/preceding-sibling::span[2]";
        webDriver.findElement(By.xpath(xPathCheckboxPublic));

        String xPathCheckboxPrivate = "//span[contains(text(),'Private')]/preceding-sibling::span[2]";
        webDriver.findElement(By.xpath(xPathCheckboxPrivate));

        String xPathCheckboxClassified = "//span[contains(text(),'Classified')]/preceding-sibling::span[2]";
        webDriver.findElement(By.xpath(xPathCheckboxClassified));

        String xPathCheckboxGeneral = "//span[contains(text(),'General')]/preceding-sibling::span[2]";
        webDriver.findElement(By.xpath(xPathCheckboxGeneral));

        String xPathCheckboxDownloads = "//span[contains(text(),'Downloads')]/preceding-sibling::span[2]";
        webDriver.findElement(By.xpath(xPathCheckboxDownloads));

        String xPathCheckboxWord = "//span[contains(text(),'Word')]/preceding-sibling::span[2]";
        webDriver.findElement(By.xpath(xPathCheckboxWord));

        String xPathCheckboxExcel = "//span[contains(text(),'Excel')]/preceding-sibling::span[2]";
        webDriver.findElement(By.xpath(xPathCheckboxExcel));
        //17

        //form
        String xPathForms = "(//div[@class='header-text'])[2]/parent::div";
        scrollByVisibleElement(xPathForms);
        waitForDebug(2000);
        webDriver.findElement(By.xpath(xPathForms)).click();
        waitForDebug(2000);

        String xPathPracticeForm = "//span[text()='Practice Form']";
        webDriver.findElement(By.xpath(xPathPracticeForm)).click();

        String xPathFormNameTitle = "//input[@placeholder='First Name']/../preceding-sibling::div/label";
        webDriver.findElement(By.xpath(xPathFormNameTitle));

        String xPathFormEmailTitle = "//input[@placeholder='name@example.com']/../preceding-sibling::div/label";
        webDriver.findElement(By.xpath(xPathFormEmailTitle));

        String xPathFormFirstNameInput = "//input[@placeholder='name@example.com']/preceding::input[2]";
        webDriver.findElement(By.xpath(xPathFormFirstNameInput));

        String xPathFormLastNameInput = "//input[@placeholder='name@example.com']/preceding::input[1]";
        webDriver.findElement(By.xpath(xPathFormLastNameInput));

        String xPathFormEmailInput = "//input[@name='gender']/preceding::div[@class='col-md-9 col-sm-12']/input";
        webDriver.findElement(By.xpath(xPathFormEmailInput));

        String xPathFormMaleInput = "//label[text()='Male']/preceding-sibling::input";
        webDriver.findElement(By.xpath(xPathFormMaleInput));

        String xPathFormFemaleInput = "//label[text()='Female']/preceding-sibling::input";
        webDriver.findElement(By.xpath(xPathFormFemaleInput));

        String xPathFormOtherInput = "//label[text()='Other']/preceding-sibling::input";
        webDriver.findElement(By.xpath(xPathFormOtherInput));

        String xPathFormMobileTitle = "//input[@placeholder='Mobile Number']/../preceding-sibling::div/label";
        webDriver.findElement(By.xpath(xPathFormMobileTitle));

        String xPathFormDoBTitle = "//div[@id='dateOfBirth']/preceding-sibling::div/label";
        webDriver.findElement(By.xpath(xPathFormDoBTitle));

        String xPathFormSubjectsTitle = "//div[@id='subjectsContainer']/preceding::label[text()='Subjects']";
        webDriver.findElement(By.xpath(xPathFormSubjectsTitle));

        String xPathFormSportsInput = "//label[text()='Sports']/preceding::input[@type='checkbox']";
        webDriver.findElement(By.xpath(xPathFormSportsInput));

        String xPathFormReadingInput = "//label[text()='Reading']/preceding::input[@type='checkbox']";
        webDriver.findElement(By.xpath(xPathFormReadingInput));

        String xPathFormMusicInput = "//label[text()='Music']/preceding::input[@type='checkbox']";
        webDriver.findElement(By.xpath(xPathFormMusicInput));
        //14
    }

    @Test(description = "Locator by Parent") //node cha
    public void locateByParent() {
        //checkbox
        goToNavTab("Check Box", webDriver);

        webDriver.findElement(By.xpath("//button[@title='Expand all']")).click();

        String xPathCheckboxHome = "//span[text()='Home']/parent::label/span[1]";
        webDriver.findElement(By.xpath(xPathCheckboxHome));

        String xPathCheckboxDesktop = "//span[text()='Desktop']/parent::label/span[1]";
        webDriver.findElement(By.xpath(xPathCheckboxDesktop));

        String xPathCheckboxNotes = "//span[text()='Notes']/parent::label/span[1]";
        webDriver.findElement(By.xpath(xPathCheckboxNotes));

        String xPathCheckboxCommands = "//span[text()='Commands']/parent::label/span[1]";
        webDriver.findElement(By.xpath(xPathCheckboxCommands));

        String xPathCheckboxDocuments = "//span[text()='Documents']/parent::label/span[1]";
        webDriver.findElement(By.xpath(xPathCheckboxDocuments));

        String xPathCheckboxWorkSpace = "//span[text()='WorkSpace']/parent::label/span[1]";
        webDriver.findElement(By.xpath(xPathCheckboxWorkSpace));

        String xPathCheckboxReact = "//span[text()='React']/parent::label/span[1]";
        webDriver.findElement(By.xpath(xPathCheckboxReact));

        String xPathCheckboxAngular = "//span[text()='Angular']/parent::label/span[1]";
        webDriver.findElement(By.xpath(xPathCheckboxAngular));

        String xPathCheckboxVeu = "//span[text()='Veu']/parent::label/span[1]";
        webDriver.findElement(By.xpath(xPathCheckboxVeu));

        String xPathCheckboxOffice = "//span[text()='Office']/parent::label/span[1]";
        webDriver.findElement(By.xpath(xPathCheckboxOffice));

        String xPathCheckboxPublic = "//span[text()='Public']/parent::label/span[1]";
        webDriver.findElement(By.xpath(xPathCheckboxPublic));

        String xPathCheckboxPrivate = "//span[text()='Private']/parent::label/span[1]";
        webDriver.findElement(By.xpath(xPathCheckboxPrivate));

        String xPathCheckboxClassified = "//span[text()='Classified']/parent::label/span[1]";
        webDriver.findElement(By.xpath(xPathCheckboxClassified));

        String xPathCheckboxGeneral = "//span[text()='General']/parent::label/span[1]";
        webDriver.findElement(By.xpath(xPathCheckboxGeneral));

        String xPathCheckboxDownloads = "//span[text()='Downloads']/parent::label/span[1]";
        webDriver.findElement(By.xpath(xPathCheckboxDownloads));

        String xPathCheckboxWord = "//span[text()='Word File.doc']/parent::label/span[1]";
        webDriver.findElement(By.xpath(xPathCheckboxWord));

        String xPathCheckboxExcel = "//span[text()='Excel File.doc']/parent::label/span[1]";
        webDriver.findElement(By.xpath(xPathCheckboxExcel));
        //17

        //form
        String xPathForms = "(//div[@class='header-text'])[2]/parent::div";
        scrollByVisibleElement(xPathForms);
        waitForDebug(2000);
        webDriver.findElement(By.xpath(xPathForms)).click();
        waitForDebug(2000);

        String xPathPracticeForm = "//span[text()='Practice Form']";
        webDriver.findElement(By.xpath(xPathPracticeForm)).click();

        String xPathFormFirstNameInput = "//label[text()='Name']/parent::div/following::div/input";
        webDriver.findElement(By.xpath(xPathFormFirstNameInput));

        String xPathFormLastNameInput = "(//label[text()='Name']/parent::div/following::div/input)[2]";
        webDriver.findElement(By.xpath(xPathFormLastNameInput));

        String xPathFormEmailInput = "//label[text()='Email']/parent::div/following::div/input";
        webDriver.findElement(By.xpath(xPathFormEmailInput));

        String xPathFormMaleInput = "//label[text()='Male']/parent::div/input";
        webDriver.findElement(By.xpath(xPathFormMaleInput));

        String xPathFormFemaleInput = "//label[text()='Female']/parent::div/input";
        webDriver.findElement(By.xpath(xPathFormFemaleInput));

        String xPathFormOtherInput = "//label[text()='Other']/parent::div/input";
        webDriver.findElement(By.xpath(xPathFormOtherInput));

        String xPathFormMobileInput = "(//label[text()='Mobile']/parent::div/following::div/input)[1]";
        webDriver.findElement(By.xpath(xPathFormMobileInput));

        String xPathFormDoBInput = "(//label[text()='Date of Birth']/parent::div/following::div/input)[1]";
        webDriver.findElement(By.xpath(xPathFormDoBInput));

        String xPathFormSubjectsInput = "(//label[text()='Subjects']/parent::div/following::div/input)[1]";
        webDriver.findElement(By.xpath(xPathFormSubjectsInput));

        String xPathFormSportsInput = "//label[text()='Sports']/parent::div/input";
        webDriver.findElement(By.xpath(xPathFormSportsInput));

        String xPathFormReadingInput = "//label[text()='Reading']/parent::div/input";
        webDriver.findElement(By.xpath(xPathFormReadingInput));

        String xPathFormMusicInput = "//label[text()='Music']/parent::div/input";
        webDriver.findElement(By.xpath(xPathFormMusicInput));

        String xPathFormPictureInput = "(//label[text()='Picture']/parent::div/following::div/input)[1]";
        webDriver.findElement(By.xpath(xPathFormPictureInput));
        //13
    }

    @Test(description = "Locator by Child") //node con
    public void locateByChild() {
        //checkbox
        goToNavTab("Check Box", webDriver);

        webDriver.findElement(By.xpath("//button[@title='Expand all']")).click();

        String xPathCheckboxHome = "//label[contains(@for,'home')]/child::span";
        webDriver.findElement(By.xpath(xPathCheckboxHome));

        String xPathCheckboxDesktop = "//label[contains(@for,'desktop')]/child::span";
        webDriver.findElement(By.xpath(xPathCheckboxDesktop));

        String xPathCheckboxNotes = "//label[contains(@for,'notes')]/child::span";
        webDriver.findElement(By.xpath(xPathCheckboxNotes));

        String xPathCheckboxCommands = "//label[contains(@for,'commands')]/child::span";
        webDriver.findElement(By.xpath(xPathCheckboxCommands));

        String xPathCheckboxDocuments = "//label[contains(@for,'doc')]/child::span";
        webDriver.findElement(By.xpath(xPathCheckboxDocuments));

        String xPathCheckboxWorkSpace = "//label[contains(@for,'workspace')]/child::span";
        webDriver.findElement(By.xpath(xPathCheckboxWorkSpace));

        String xPathCheckboxReact = "//label[contains(@for,'react')]/child::span";
        webDriver.findElement(By.xpath(xPathCheckboxReact));

        String xPathCheckboxAngular = "//label[contains(@for,'angular')]/child::span";
        webDriver.findElement(By.xpath(xPathCheckboxAngular));

        String xPathCheckboxVeu = "//label[contains(@for,'veu')]/child::span";
        webDriver.findElement(By.xpath(xPathCheckboxVeu));

        String xPathCheckboxOffice = "//label[contains(@for,'office')]/child::span";
        webDriver.findElement(By.xpath(xPathCheckboxOffice));

        String xPathCheckboxPublic = "//label[contains(@for,'public')]/child::span";
        webDriver.findElement(By.xpath(xPathCheckboxPublic));

        String xPathCheckboxPrivate = "//label[contains(@for,'private')]/child::span";
        webDriver.findElement(By.xpath(xPathCheckboxPrivate));

        String xPathCheckboxClassified = "//label[contains(@for,'classified')]/child::span";
        webDriver.findElement(By.xpath(xPathCheckboxClassified));

        String xPathCheckboxGeneral = "//label[contains(@for,'general')]/child::span";
        webDriver.findElement(By.xpath(xPathCheckboxGeneral));

        String xPathCheckboxDownloads = "//label[contains(@for,'downloads')]/child::span";
        webDriver.findElement(By.xpath(xPathCheckboxDownloads));

        String xPathCheckboxWord = "//label[contains(@for,'word')]/child::span";
        webDriver.findElement(By.xpath(xPathCheckboxWord));

        String xPathCheckboxExcel = "//label[contains(@for,'excel')]/child::span";
        webDriver.findElement(By.xpath(xPathCheckboxExcel));
        //17

        //form
        String xPathForms = "(//div[@class='header-text'])[2]/parent::div";
        scrollByVisibleElement(xPathForms);
        waitForDebug(2000);
        webDriver.findElement(By.xpath(xPathForms)).click();
        waitForDebug(2000);

        String xPathPracticeForm = "//span[text()='Practice Form']";
        webDriver.findElement(By.xpath(xPathPracticeForm)).click();

        String xPathFormFirstNameInput = "//div[@id='userName-wrapper']/child::div[2]/input";
        webDriver.findElement(By.xpath(xPathFormFirstNameInput));

        String xPathFormLastNameInput = "//div[@id='userName-wrapper']/child::div[4]/input";
        webDriver.findElement(By.xpath(xPathFormLastNameInput));

        String xPathFormEmailInput = "//div[@id='userEmail-wrapper']/child::div/input";
        webDriver.findElement(By.xpath(xPathFormEmailInput));

        String xPathFormMaleInput = "//div[@id='genterWrapper']/child::div/descendant::input[1]";
        webDriver.findElement(By.xpath(xPathFormMaleInput));

        String xPathFormFemaleInput = "//div[@id='genterWrapper']/child::div/descendant::input[2]";
        webDriver.findElement(By.xpath(xPathFormFemaleInput));

        String xPathFormOtherInput = "//div[@id='genterWrapper']/child::div/descendant::input[3]";
        webDriver.findElement(By.xpath(xPathFormOtherInput));

        String xPathFormMobileInput = "//div[@id='userNumber-wrapper']/child::div/input";
        webDriver.findElement(By.xpath(xPathFormMobileInput));

        String xPathFormDoBInput = "//div[@id='dateOfBirth']/child::div/descendant::input";
        webDriver.findElement(By.xpath(xPathFormDoBInput));

        String xPathFormSubjectsInput = "//div[@id='subjectsWrapper']/child::div/descendant::input";
        webDriver.findElement(By.xpath(xPathFormSubjectsInput));

        String xPathFormSportsInput = "//div[@id='hobbiesWrapper']/child::div/descendant::input[1]";
        webDriver.findElement(By.xpath(xPathFormSportsInput));

        String xPathFormReadingInput = "//div[@id='hobbiesWrapper']/child::div/descendant::input[2]";
        webDriver.findElement(By.xpath(xPathFormReadingInput));

        String xPathFormMusicInput = "//div[@id='hobbiesWrapper']/child::div/descendant::input[3]";
        webDriver.findElement(By.xpath(xPathFormMusicInput));

        String xPathFormPictureInput = "//div[@class='form-file']/child::input";
        webDriver.findElement(By.xpath(xPathFormPictureInput));
        //13
    }

    @Test(description = "Locator by Normalize-space")
    public void locateByNormalizeSpace() {
        //checkbox
        goToNavTab("Check Box", webDriver);

        webDriver.findElement(By.xpath("//button[@title='Expand all']")).click();

        String xPathCheckboxHome = "//span[text()[normalize-space() = 'Home']]/preceding::span[2]";
        webDriver.findElement(By.xpath(xPathCheckboxHome));

        String xPathCheckboxDesktop = "//span[normalize-space(text()) = 'Desktop']/preceding::span[2]";
        webDriver.findElement(By.xpath(xPathCheckboxDesktop));

        String xPathCheckboxNotes = "//span[normalize-space(text()) = 'Notes']/preceding::span[2]";
        webDriver.findElement(By.xpath(xPathCheckboxNotes));

        String xPathCheckboxCommands = "//span[normalize-space(text()) = 'Commands']/preceding::span[2]";
        webDriver.findElement(By.xpath(xPathCheckboxCommands));

        String xPathCheckboxDocuments = "//span[text()[normalize-space() = 'Documents']]/preceding::span[2]";
        webDriver.findElement(By.xpath(xPathCheckboxDocuments));

        String xPathCheckboxWorkSpace = "//span[text()[normalize-space() = 'WorkSpace']]/preceding::span[2]";
        webDriver.findElement(By.xpath(xPathCheckboxWorkSpace));

        String xPathCheckboxReact = "//span[text()[normalize-space() = 'React']]/preceding::span[2]";
        webDriver.findElement(By.xpath(xPathCheckboxReact));

        String xPathCheckboxAngular = "//span[text()[normalize-space() = 'Angular']]/preceding::span[2]";
        webDriver.findElement(By.xpath(xPathCheckboxAngular));

        String xPathCheckboxVeu = "//span[text()[normalize-space() = 'Veu']]/preceding::span[2]";
        webDriver.findElement(By.xpath(xPathCheckboxVeu));

        String xPathCheckboxOffice = "//span[text()[normalize-space() = 'Office']]/preceding::span[2]";
        webDriver.findElement(By.xpath(xPathCheckboxOffice));

        String xPathCheckboxPublic = "//span[text()[normalize-space() = 'Public']]/preceding::span[2]";
        webDriver.findElement(By.xpath(xPathCheckboxPublic));

        String xPathCheckboxPrivate = "//span[text()[normalize-space() = 'Private']]/preceding::span[2]";
        webDriver.findElement(By.xpath(xPathCheckboxPrivate));

        String xPathCheckboxClassified = "//span[text()[normalize-space() = 'Classified']]/preceding::span[2]";
        webDriver.findElement(By.xpath(xPathCheckboxClassified));

        String xPathCheckboxGeneral = "//span[text()[normalize-space() = 'General']]/preceding::span[2]";
        webDriver.findElement(By.xpath(xPathCheckboxGeneral));

        String xPathCheckboxDownloads = "//span[text()[normalize-space() = 'Downloads']]/preceding::span[2]";
        webDriver.findElement(By.xpath(xPathCheckboxDownloads));

        String xPathCheckboxWord = "//span[text()[normalize-space() = 'Word File.doc']]/preceding::span[2]";
        webDriver.findElement(By.xpath(xPathCheckboxWord));

        String xPathCheckboxExcel = "//span[text()[normalize-space() = 'Excel File.doc']]/preceding::span[2]";
        webDriver.findElement(By.xpath(xPathCheckboxExcel));
        //17

        //form
        String xPathForms = "(//div[@class='header-text'])[2]/parent::div";
        scrollByVisibleElement(xPathForms);
        waitForDebug(2000);
        webDriver.findElement(By.xpath(xPathForms)).click();
        waitForDebug(2000);

        String xPathPracticeForm = "//span[text()='Practice Form']";
        webDriver.findElement(By.xpath(xPathPracticeForm)).click();

        String xPathFormFirstNameInput = "//input[@placeholder[normalize-space() = 'First Name']]";
        webDriver.findElement(By.xpath(xPathFormFirstNameInput));

        String xPathFormLastNameInput = "//input[@placeholder[normalize-space() = 'Last Name']]";
        webDriver.findElement(By.xpath(xPathFormLastNameInput));

        String xPathFormEmailInput = "//input[normalize-space(@placeholder) = 'name@example.com']";
        webDriver.findElement(By.xpath(xPathFormEmailInput));

        String xPathFormMaleInput = "//label[normalize-space(@for) = 'gender-radio-1']";
        webDriver.findElement(By.xpath(xPathFormMaleInput));

        String xPathFormFemaleInput = "//label[normalize-space(@for) = 'gender-radio-2']";
        webDriver.findElement(By.xpath(xPathFormFemaleInput));

        String xPathFormOtherInput = "//label[normalize-space(@for) = 'gender-radio-3']";
        webDriver.findElement(By.xpath(xPathFormOtherInput));

        String xPathFormMobileInput = "//input[normalize-space(@placeholder) = 'Mobile Number']";
        webDriver.findElement(By.xpath(xPathFormMobileInput));

        String xPathFormDoBInput = "//input[normalize-space(@id) = 'dateOfBirthInput']";
        webDriver.findElement(By.xpath(xPathFormDoBInput));

        String xPathFormSubjectsInput = "//input[normalize-space(@id) = 'subjectsInput']";
        webDriver.findElement(By.xpath(xPathFormSubjectsInput));

        String xPathFormSportsInput = "//label[normalize-space(@for) = 'hobbies-checkbox-1']";
        webDriver.findElement(By.xpath(xPathFormSportsInput));

        String xPathFormReadingInput = "//label[normalize-space(@for) = 'hobbies-checkbox-2']";
        webDriver.findElement(By.xpath(xPathFormReadingInput));

        String xPathFormMusicInput = "//label[normalize-space(@for) = 'hobbies-checkbox-3']";
        webDriver.findElement(By.xpath(xPathFormMusicInput));

        String xPathFormPictureInput = "//input[normalize-space(@type) = 'file']";
        webDriver.findElement(By.xpath(xPathFormPictureInput));
        //13
    }

    @Test(description = "Locator by Text And Ancestor")
    public void locateByTextAndAncestor() {
        //form
        String xPathForms = "(//div[@class='header-text'])[2]/parent::div";
        scrollByVisibleElement(xPathForms);
        waitForDebug(2000);
        webDriver.findElement(By.xpath(xPathForms)).click();
        waitForDebug(2000);

        String xPathPracticeForm = "//span[text()='Practice Form']";
        webDriver.findElement(By.xpath(xPathPracticeForm)).click();

        String xPathFormFirstNameInput = "//label[text()='Name']/ancestor::div[@class='mt-2 row']/div[2]/input";
        webDriver.findElement(By.xpath(xPathFormFirstNameInput));

        String xPathFormLastNameInput = "//label[text()='Name']/ancestor::div[@class='mt-2 row']/div[4]/input";
        webDriver.findElement(By.xpath(xPathFormLastNameInput));

        String xPathFormEmailInput = "//label[text()='Email']/ancestor::div[@class='mt-2 row']/descendant::input";
        webDriver.findElement(By.xpath(xPathFormEmailInput));

        String xPathFormMaleInput = "//div[text()='Gender']/ancestor::div[@class='mt-2 row']/descendant::input[1]";
        webDriver.findElement(By.xpath(xPathFormMaleInput));

        String xPathFormFemaleInput = "//div[text()='Gender']/ancestor::div[@class='mt-2 row']/descendant::input[2]";
        webDriver.findElement(By.xpath(xPathFormFemaleInput));

        String xPathFormOtherInput = "//div[text()='Gender']/ancestor::div[@class='mt-2 row']/descendant::input[3]";
        webDriver.findElement(By.xpath(xPathFormOtherInput));

        String xPathFormMobileInput = "//label[text()='Mobile']/ancestor::div[@class='mt-2 row']/descendant::input";
        webDriver.findElement(By.xpath(xPathFormMobileInput));

        String xPathFormDoBInput = "//label[text()='Date of Birth']/ancestor::div[@class='mt-2 row']/descendant::input";
        webDriver.findElement(By.xpath(xPathFormDoBInput));

        String xPathFormSubjectsInput = "//label[text()='Subjects']/ancestor::div[@class='mt-2 row']/descendant::input";
        webDriver.findElement(By.xpath(xPathFormSubjectsInput));

        String xPathFormSportsInput = "//label[text()='Hobbies']/ancestor::div[@class='mt-2 row']/descendant::input[1]";
        webDriver.findElement(By.xpath(xPathFormSportsInput));

        String xPathFormReadingInput = "//label[text()='Hobbies']/ancestor::div[@class='mt-2 row']/descendant::input[2]";
        webDriver.findElement(By.xpath(xPathFormReadingInput));

        String xPathFormMusicInput = "//label[text()='Hobbies']/ancestor::div[@class='mt-2 row']/descendant::input[3]";
        webDriver.findElement(By.xpath(xPathFormMusicInput));

        String xPathFormPictureInput = "//label[text()='Picture']/ancestor::div[@class='mt-2 row']/descendant::input";
        webDriver.findElement(By.xpath(xPathFormPictureInput));
        //13
    }

    @Test(description = "Locator by Text And Preceding")
    public void locateByTextAndPreceding() {
        //checkbox
        goToNavTab("Check Box", webDriver);

        webDriver.findElement(By.xpath("//button[@title='Expand all']")).click();

        String xPathCheckboxHome = "//span[text()='Home']/preceding::span[2]";
        webDriver.findElement(By.xpath(xPathCheckboxHome));

        String xPathCheckboxDesktop = "//span[text() = 'Desktop']/preceding::span[2]";
        webDriver.findElement(By.xpath(xPathCheckboxDesktop));

        String xPathCheckboxNotes = "//span[text() = 'Notes']/preceding::span[2]";
        webDriver.findElement(By.xpath(xPathCheckboxNotes));

        String xPathCheckboxCommands = "//span[text() = 'Commands']/preceding::span[2]";
        webDriver.findElement(By.xpath(xPathCheckboxCommands));

        String xPathCheckboxDocuments = "//span[text() = 'Documents']/preceding::span[2]";
        webDriver.findElement(By.xpath(xPathCheckboxDocuments));

        String xPathCheckboxWorkSpace = "//span[text() = 'WorkSpace']/preceding::span[2]";
        webDriver.findElement(By.xpath(xPathCheckboxWorkSpace));

        String xPathCheckboxReact = "//span[text() = 'React']/preceding::span[2]";
        webDriver.findElement(By.xpath(xPathCheckboxReact));

        String xPathCheckboxAngular = "//span[text() = 'Angular']/preceding::span[2]";
        webDriver.findElement(By.xpath(xPathCheckboxAngular));

        String xPathCheckboxVeu = "//span[text() = 'Veu']/preceding::span[2]";
        webDriver.findElement(By.xpath(xPathCheckboxVeu));

        String xPathCheckboxOffice = "//span[text() = 'Office']/preceding::span[2]";
        webDriver.findElement(By.xpath(xPathCheckboxOffice));
    }

    @Test(description = "Locator by Text And Following")
    public void locateByTextAndFollowing() {
        //form
        String xPathForms = "(//div[@class='header-text'])[2]/parent::div";
        scrollByVisibleElement(xPathForms);
        waitForDebug(2000);
        webDriver.findElement(By.xpath(xPathForms)).click();
        waitForDebug(2000);

        String xPathPracticeForm = "//span[text()='Practice Form']";
        webDriver.findElement(By.xpath(xPathPracticeForm)).click();

        String xPathFormFirstNameInput = "//label[text()='Name']/following::input[1]";
        webDriver.findElement(By.xpath(xPathFormFirstNameInput));

        String xPathFormLastNameInput = "//label[text()='Name']/following::input[2]";
        webDriver.findElement(By.xpath(xPathFormLastNameInput));

        String xPathFormEmailInput = "//label[text()='Email']/following::input";
        webDriver.findElement(By.xpath(xPathFormEmailInput));

        String xPathFormMaleInput = "//div[text()='Gender']/following::input[@name='gender'][1]";
        webDriver.findElement(By.xpath(xPathFormMaleInput));

        String xPathFormFemaleInput = "//div[text()='Gender']/following::input[@name='gender'][2]";
        webDriver.findElement(By.xpath(xPathFormFemaleInput));

        String xPathFormOtherInput = "//div[text()='Gender']/following::input[@name='gender'][3]";
        webDriver.findElement(By.xpath(xPathFormOtherInput));

        String xPathFormMobileInput = "//label[text()='Mobile']/following::input";
        webDriver.findElement(By.xpath(xPathFormMobileInput));

        String xPathFormDoBInput = "//label[text()='Date of Birth']/following::input";
        webDriver.findElement(By.xpath(xPathFormDoBInput));

        String xPathFormSubjectsInput = "//label[text()='Subjects']/following::input";
        webDriver.findElement(By.xpath(xPathFormSubjectsInput));

        String xPathFormSportsInput = "//label[text()='Hobbies']/following::input[@type='checkbox'][1]";
        webDriver.findElement(By.xpath(xPathFormSportsInput));

        String xPathFormReadingInput = "//label[text()='Hobbies']/following::input[@type='checkbox'][2]";
        webDriver.findElement(By.xpath(xPathFormReadingInput));

        String xPathFormMusicInput = "//label[text()='Hobbies']/following::input[@type='checkbox'][3]";
        webDriver.findElement(By.xpath(xPathFormMusicInput));

        String xPathFormPictureInput = "//label[text()='Picture']/following::input";
        webDriver.findElement(By.xpath(xPathFormPictureInput));
        //13
    }

    @Test(description = "Locator by Normalize-space And Ancestor")
    public void locateByNormalizeSpaceAndAncestor() {
        //form
        String xPathForms = "(//div[@class='header-text'])[2]/parent::div";
        scrollByVisibleElement(xPathForms);
        waitForDebug(2000);
        webDriver.findElement(By.xpath(xPathForms)).click();
        waitForDebug(2000);

        String xPathPracticeForm = "//span[normalize-space()='Practice Form']";
        webDriver.findElement(By.xpath(xPathPracticeForm)).click();

        String xPathFormFirstNameInput = "//label[normalize-space()='Name']/ancestor::div[@class='mt-2 row']/div[2]/input";
        webDriver.findElement(By.xpath(xPathFormFirstNameInput));

        String xPathFormLastNameInput = "//label[normalize-space()='Name']/ancestor::div[@class='mt-2 row']/div[4]/input";
        webDriver.findElement(By.xpath(xPathFormLastNameInput));

        String xPathFormEmailInput = "//label[normalize-space()='Email']/ancestor::div[@class='mt-2 row']/descendant::input";
        webDriver.findElement(By.xpath(xPathFormEmailInput));

        String xPathFormMaleInput = "//div[normalize-space()='Gender']/ancestor::div[@class='mt-2 row']/descendant::input[1]";
        webDriver.findElement(By.xpath(xPathFormMaleInput));

        String xPathFormFemaleInput = "//div[normalize-space()='Gender']/ancestor::div[@class='mt-2 row']/descendant::input[2]";
        webDriver.findElement(By.xpath(xPathFormFemaleInput));

        String xPathFormOtherInput = "//div[normalize-space()='Gender']/ancestor::div[@class='mt-2 row']/descendant::input[3]";
        webDriver.findElement(By.xpath(xPathFormOtherInput));

        String xPathFormMobileInput = "//label[normalize-space(text())='Mobile']/ancestor::div[@class='mt-2 row']/descendant::input";
        webDriver.findElement(By.xpath(xPathFormMobileInput));

        String xPathFormDoBInput = "//label[normalize-space()='Date of Birth']/ancestor::div[@class='mt-2 row']/descendant::input";
        webDriver.findElement(By.xpath(xPathFormDoBInput));

        String xPathFormSubjectsInput = "//label[normalize-space()='Subjects']/ancestor::div[@class='mt-2 row']/descendant::input";
        webDriver.findElement(By.xpath(xPathFormSubjectsInput));

        String xPathFormSportsInput = "//label[normalize-space()='Hobbies']/ancestor::div[@class='mt-2 row']/descendant::input[1]";
        webDriver.findElement(By.xpath(xPathFormSportsInput));

        String xPathFormReadingInput = "//label[normalize-space()='Hobbies']/ancestor::div[@class='mt-2 row']/descendant::input[2]";
        webDriver.findElement(By.xpath(xPathFormReadingInput));

        String xPathFormMusicInput = "//label[normalize-space()='Hobbies']/ancestor::div[@class='mt-2 row']/descendant::input[3]";
        webDriver.findElement(By.xpath(xPathFormMusicInput));

        String xPathFormPictureInput = "//label[normalize-space()='Picture']/ancestor::div[@class='mt-2 row']/descendant::input";
        webDriver.findElement(By.xpath(xPathFormPictureInput));
        //13
    }

    @Test(description = "Locator by Normalize-space() And Preceding")
    public void locateByNormalizeSpaceAndPreceding() {
        //checkbox
        goToNavTab("Check Box", webDriver);

        webDriver.findElement(By.xpath("//button[@title='Expand all']")).click();

        String xPathCheckboxHome = "//span[normalize-space()='Home']/preceding::span[2]";
        webDriver.findElement(By.xpath(xPathCheckboxHome));

        String xPathCheckboxDesktop = "//span[normalize-space() = 'Desktop']/preceding::span[2]";
        webDriver.findElement(By.xpath(xPathCheckboxDesktop));

        String xPathCheckboxNotes = "//span[normalize-space() = 'Notes']/preceding::span[2]";
        webDriver.findElement(By.xpath(xPathCheckboxNotes));

        String xPathCheckboxCommands = "//span[normalize-space() = 'Commands']/preceding::span[2]";
        webDriver.findElement(By.xpath(xPathCheckboxCommands));

        String xPathCheckboxDocuments = "//span[normalize-space() = 'Documents']/preceding::span[2]";
        webDriver.findElement(By.xpath(xPathCheckboxDocuments));

        String xPathCheckboxWorkSpace = "//span[normalize-space() = 'WorkSpace']/preceding::span[2]";
        webDriver.findElement(By.xpath(xPathCheckboxWorkSpace));

        String xPathCheckboxReact = "//span[normalize-space() = 'React']/preceding::span[2]";
        webDriver.findElement(By.xpath(xPathCheckboxReact));

        String xPathCheckboxAngular = "//span[normalize-space() = 'Angular']/preceding::span[2]";
        webDriver.findElement(By.xpath(xPathCheckboxAngular));

        String xPathCheckboxVeu = "//span[normalize-space() = 'Veu']/preceding::span[2]";
        webDriver.findElement(By.xpath(xPathCheckboxVeu));

        String xPathCheckboxOffice = "//span[normalize-space() = 'Office']/preceding::span[2]";
        webDriver.findElement(By.xpath(xPathCheckboxOffice));
    }

    @Test(description = "Locator by Normalize-space And Following")
    public void locateByNormalizeSpaceAndFollowing() {
        //form
        String xPathForms = "(//div[@class='header-text'])[2]/parent::div";
        scrollByVisibleElement(xPathForms);
        waitForDebug(2000);
        webDriver.findElement(By.xpath(xPathForms)).click();
        waitForDebug(2000);

        String xPathPracticeForm = "//span[normalize-space()='Practice Form']";
        webDriver.findElement(By.xpath(xPathPracticeForm)).click();

        String xPathFormFirstNameInput = "//label[normalize-space()='Name']/following::input[1]";
        webDriver.findElement(By.xpath(xPathFormFirstNameInput));

        String xPathFormLastNameInput = "//label[normalize-space()='Name']/following::input[2]";
        webDriver.findElement(By.xpath(xPathFormLastNameInput));

        String xPathFormEmailInput = "//label[normalize-space()='Email']/following::input";
        webDriver.findElement(By.xpath(xPathFormEmailInput));

        String xPathFormMaleInput = "//div[normalize-space()='Gender']/following::input[@name='gender'][1]";
        webDriver.findElement(By.xpath(xPathFormMaleInput));

        String xPathFormFemaleInput = "//div[normalize-space()='Gender']/following::input[@name='gender'][2]";
        webDriver.findElement(By.xpath(xPathFormFemaleInput));

        String xPathFormOtherInput = "//div[normalize-space()='Gender']/following::input[@name='gender'][3]";
        webDriver.findElement(By.xpath(xPathFormOtherInput));

        String xPathFormMobileInput = "//label[normalize-space(text())='Mobile']/following::input";
        webDriver.findElement(By.xpath(xPathFormMobileInput));

        String xPathFormDoBInput = "//label[normalize-space()='Date of Birth']/following::input";
        webDriver.findElement(By.xpath(xPathFormDoBInput));

        String xPathFormSubjectsInput = "//label[normalize-space()='Subjects']/following::input";
        webDriver.findElement(By.xpath(xPathFormSubjectsInput));

        String xPathFormSportsInput = "//label[normalize-space()='Hobbies']/following::input[@type='checkbox'][1]";
        webDriver.findElement(By.xpath(xPathFormSportsInput));

        String xPathFormReadingInput = "//label[normalize-space()='Hobbies']/following::input[@type='checkbox'][2]";
        webDriver.findElement(By.xpath(xPathFormReadingInput));

        String xPathFormMusicInput = "//label[normalize-space()='Hobbies']/following::input[@type='checkbox'][3]";
        webDriver.findElement(By.xpath(xPathFormMusicInput));

        String xPathFormPictureInput = "//label[normalize-space()='Picture']/following::input";
        webDriver.findElement(By.xpath(xPathFormPictureInput));
        //13
    }

    @Test(description = "Locator by Contains And Ancestor")
    public void locateByContainsAndAncestor() {
        //form
        String xPathForms = "(//div[@class='header-text'])[2]/parent::div";
        scrollByVisibleElement(xPathForms);
        waitForDebug(2000);
        webDriver.findElement(By.xpath(xPathForms)).click();
        waitForDebug(2000);

        String xPathPracticeForm = "//span[text()='Practice Form']";
        webDriver.findElement(By.xpath(xPathPracticeForm)).click();

        String xPathFormFirstNameInput = "//label[contains(text(),'Name')]/ancestor::div[@class='mt-2 row']/div[2]/input";
        webDriver.findElement(By.xpath(xPathFormFirstNameInput));

        String xPathFormLastNameInput = "//label[contains(text(),'Name')]/ancestor::div[@class='mt-2 row']/div[4]/input";
        webDriver.findElement(By.xpath(xPathFormLastNameInput));

        String xPathFormEmailInput = "//label[contains(text(),'Email')]/ancestor::div[@class='mt-2 row']/descendant::input";
        webDriver.findElement(By.xpath(xPathFormEmailInput));

        String xPathFormMaleInput = "//div[contains(text(),'Gender')]/ancestor::div[@class='mt-2 row']/descendant::input[1]";
        webDriver.findElement(By.xpath(xPathFormMaleInput));

        String xPathFormFemaleInput = "//div[contains(text(),'Gender')]/ancestor::div[@class='mt-2 row']/descendant::input[2]";
        webDriver.findElement(By.xpath(xPathFormFemaleInput));

        String xPathFormOtherInput = "//div[contains(text(),'Gender')]/ancestor::div[@class='mt-2 row']/descendant::input[3]";
        webDriver.findElement(By.xpath(xPathFormOtherInput));

        String xPathFormMobileInput = "//label[contains(text(),'Mobile')]/ancestor::div[@class='mt-2 row']/descendant::input";
        webDriver.findElement(By.xpath(xPathFormMobileInput));

        String xPathFormDoBInput = "//label[contains(text(),'Date')]/ancestor::div[@class='mt-2 row']/descendant::input";
        webDriver.findElement(By.xpath(xPathFormDoBInput));

        String xPathFormSubjectsInput = "//label[contains(text(),'Subjects')]/ancestor::div[@class='mt-2 row']/descendant::input";
        webDriver.findElement(By.xpath(xPathFormSubjectsInput));

        String xPathFormSportsInput = "//label[contains(text(),'Hobbies')]/ancestor::div[@class='mt-2 row']/descendant::input[1]";
        webDriver.findElement(By.xpath(xPathFormSportsInput));

        String xPathFormReadingInput = "//label[contains(text(),'Hobbies')]/ancestor::div[@class='mt-2 row']/descendant::input[2]";
        webDriver.findElement(By.xpath(xPathFormReadingInput));

        String xPathFormMusicInput = "//label[contains(text(),'Hobbies')]/ancestor::div[@class='mt-2 row']/descendant::input[3]";
        webDriver.findElement(By.xpath(xPathFormMusicInput));

        String xPathFormPictureInput = "//label[contains(text(),'Picture')]/ancestor::div[@class='mt-2 row']/descendant::input";
        webDriver.findElement(By.xpath(xPathFormPictureInput));
        //13
    }

    @Test(description = "Locator by Contains And Preceding")
    public void locateByContainsAndPreceding() {
        //checkbox
        goToNavTab("Check Box", webDriver);

        webDriver.findElement(By.xpath("//button[@title='Expand all']")).click();

        String xPathCheckboxHome = "//span[contains(text(),'Home')]/preceding::span[2]";
        webDriver.findElement(By.xpath(xPathCheckboxHome));

        String xPathCheckboxDesktop = "//span[contains(text(),  'Desktop')]/preceding::span[2]";
        webDriver.findElement(By.xpath(xPathCheckboxDesktop));

        String xPathCheckboxNotes = "//span[contains(text(),  'Notes')]/preceding::span[2]";
        webDriver.findElement(By.xpath(xPathCheckboxNotes));

        String xPathCheckboxCommands = "//span[contains(text(),  'Commands')]/preceding::span[2]";
        webDriver.findElement(By.xpath(xPathCheckboxCommands));

        String xPathCheckboxDocuments = "//span[contains(text(),  'Documents')]/preceding::span[2]";
        webDriver.findElement(By.xpath(xPathCheckboxDocuments));

        String xPathCheckboxWorkSpace = "//span[contains(text(),  'WorkSpace')]/preceding::span[2]";
        webDriver.findElement(By.xpath(xPathCheckboxWorkSpace));

        String xPathCheckboxReact = "//span[contains(text(),  'React')]/preceding::span[2]";
        webDriver.findElement(By.xpath(xPathCheckboxReact));

        String xPathCheckboxAngular = "//span[contains(text(), 'Angular')]/preceding::span[2]";
        webDriver.findElement(By.xpath(xPathCheckboxAngular));

        String xPathCheckboxVeu = "//span[contains(text(),  'Veu')]/preceding::span[2]";
        webDriver.findElement(By.xpath(xPathCheckboxVeu));

        String xPathCheckboxOffice = "//span[contains(text(),  'Office')]/preceding::span[2]";
        webDriver.findElement(By.xpath(xPathCheckboxOffice));
    }

    @Test(description = "Locator by Contains And Following")
    public void locateByContainsAndFollowing() {
        //form
        String xPathForms = "(//div[@class='header-text'])[2]/parent::div";
        scrollByVisibleElement(xPathForms);
        waitForDebug(2000);
        webDriver.findElement(By.xpath(xPathForms)).click();
        waitForDebug(2000);

        String xPathPracticeForm = "//span[text()='Practice Form']";
        webDriver.findElement(By.xpath(xPathPracticeForm)).click();

        String xPathFormFirstNameInput = "//label[contains(text(),'Name')]/following::input[1]";
        webDriver.findElement(By.xpath(xPathFormFirstNameInput));

        String xPathFormLastNameInput = "//label[contains(text(),'Name')]/following::input[2]";
        webDriver.findElement(By.xpath(xPathFormLastNameInput));

        String xPathFormEmailInput = "//label[contains(text(),'Email')]/following::input";
        webDriver.findElement(By.xpath(xPathFormEmailInput));

        String xPathFormMaleInput = "//div[contains(text(),'Gender')]/following::input[@name='gender'][1]";
        webDriver.findElement(By.xpath(xPathFormMaleInput));

        String xPathFormFemaleInput = "//div[contains(text(),'Gender')]/following::input[@name='gender'][2]";
        webDriver.findElement(By.xpath(xPathFormFemaleInput));

        String xPathFormOtherInput = "//div[contains(text(),'Gender')]/following::input[@name='gender'][3]";
        webDriver.findElement(By.xpath(xPathFormOtherInput));

        String xPathFormMobileInput = "//label[contains(text(),'Mobile')]/following::input";
        webDriver.findElement(By.xpath(xPathFormMobileInput));

        String xPathFormDoBInput = "//label[contains(text(),'Date of Birth')]/following::input";
        webDriver.findElement(By.xpath(xPathFormDoBInput));

        String xPathFormSubjectsInput = "//label[contains(text(),'Subjects')]/following::input";
        webDriver.findElement(By.xpath(xPathFormSubjectsInput));

        String xPathFormSportsInput = "//label[contains(text(),'Hobbies')]/following::input[@type='checkbox'][1]";
        webDriver.findElement(By.xpath(xPathFormSportsInput));

        String xPathFormReadingInput = "//label[contains(text(),'Hobbies')]/following::input[@type='checkbox'][2]";
        webDriver.findElement(By.xpath(xPathFormReadingInput));

        String xPathFormMusicInput = "//label[contains(text(),'Hobbies')]/following::input[@type='checkbox'][3]";
        webDriver.findElement(By.xpath(xPathFormMusicInput));

        String xPathFormPictureInput = "//label[contains(text(),'Picture')]/following::input";
        webDriver.findElement(By.xpath(xPathFormPictureInput));
        //13
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
