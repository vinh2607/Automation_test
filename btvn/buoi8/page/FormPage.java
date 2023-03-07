package nganttt.btvn.buoi8.page;

import nganttt.btvn.buoi8.common.BaseConst;
import nganttt.btvn.buoi8.common.BasePage;
import nganttt.btvn.buoi8.model.StudentModel;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class FormPage extends BasePage {
    /**
     * Init a new instance
     *
     * @param webDriver : The WebDriver to interact with elements
     */
    public FormPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void gotoPage() {
        webDriver.get(BaseConst.URL);
        webDriver.manage().window().maximize();
    }

    public void isGoToPageSuccess() {
        waitUntilVisibleElement(BaseConst.logoXPath);
        Assert.assertTrue(findElement(BaseConst.logoXPath).isDisplayed());
    }

    public void enterInfo(StudentModel studentModel) {
        String path = System.getProperty("user.dir");
        String folderPath = "\\src\\test\\java\\nganttt\\btvn\\buoi8\\libs\\";
        String placeholderFirstName = "First Name";
        String placeholderLastName = "Last Name";
        String placeholderEmail = "name@example.com";
        String placeholderMobile = "Mobile Number";
        String idSubjectInput = "subjectsInput";
        String placeholderAddress = "Current Address";
        String stateDropdownID = "state";
        String cityDropdownID = "city";
        String submitButtonText = "Submit";

        String xPathSubmitButton = getStringXPath(BaseConst.DYNAMIC_BUTTON_FORM, submitButtonText);

        inputTextWithType(BaseConst.DYNAMIC_INPUT_TEXT_FORM, placeholderFirstName, studentModel.getFirstName());
        inputTextWithType(BaseConst.DYNAMIC_INPUT_TEXT_FORM, placeholderLastName, studentModel.getLastName());
        inputTextWithType(BaseConst.DYNAMIC_INPUT_TEXT_FORM, placeholderEmail, studentModel.getEmail());
        clickWithType(BaseConst.DYNAMIC_INPUT_LABEL_FORM, studentModel.getGender());
        inputTextWithType(BaseConst.DYNAMIC_INPUT_TEXT_FORM, placeholderMobile, studentModel.getMobile());
        selectDay(studentModel.getYear(), studentModel.getMonth(), studentModel.getDay());
        enterTextToInputDropdown(idSubjectInput, studentModel.getSubject());
        clickWithType(BaseConst.DYNAMIC_INPUT_LABEL_FORM, studentModel.getHobbies());
        inputFile(BaseConst.inputFileXPath, path + folderPath, studentModel.getFileName());
        inputTextWithType(BaseConst.DYNAMIC_INPUT_TEXTAREA_FORM, placeholderAddress, studentModel.getAddress());
        selectDivDropdown(stateDropdownID, studentModel.getState());
        selectDivDropdown(cityDropdownID, studentModel.getCity());
        clickElementByJS(xPathSubmitButton);
    }

    public void selectDivDropdown(String dropdownID, String value) {
        if (value != "") {
            String xPathDropdown = getStringXPath(BaseConst.DYNAMIC_DROPDOWN_DIV_FORM, dropdownID);
            scrollByVisibleElement(xPathDropdown);
            clickToElement(xPathDropdown);
            String xPathOption = getStringXPath(BaseConst.DYNAMIC_DROPDOWN_DIV_OPTION_FORM, value);
            scrollByVisibleElement(xPathOption);
            clickToElement(xPathOption);
        }
    }

    public void selectDay(String year, String month, String day) {
        String textYearClass = "year-select";
        String textMonthClass = "month-select";
        String xPathYear = getStringXPath(BaseConst.DYNAMIC_DROPDOWN_SELECT_FORM, textYearClass);
        String xPathMonth = getStringXPath(BaseConst.DYNAMIC_DROPDOWN_SELECT_FORM, textMonthClass);
        String xPathDay = getStringXPath(BaseConst.DYNAMIC_DAY_SELECT_FORM, day);
        clickToElement(BaseConst.inputDOBXPath);
        selectItemInDropdown(xPathYear, year);
        selectItemInDropdown(xPathMonth, month);
        clickToElement(xPathDay);
    }

    public void verifyValue(String label, String expectedValue) {
        String valueXPath = getStringXPath(BaseConst.DYNAMIC_TEXT_INFO_FORM, label);
        waitUntilVisibleElement(valueXPath);
        String actualValue = findElement(valueXPath).getText();
        Assert.assertEquals(actualValue, expectedValue, "Verify " + label);
    }

    @AfterMethod
    public void afterMethod() {
        webDriver.quit();
    }

}
