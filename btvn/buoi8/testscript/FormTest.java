package nganttt.btvn.buoi8.testscript;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import nganttt.btvn.buoi8.dataprovider.TestDataProvider;
import nganttt.btvn.buoi8.model.StudentModel;
import nganttt.btvn.buoi8.page.FormPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.io.File;

public class FormTest {
    private FormPage formPage;
    private WebDriver webDriver;
    String path = System.getProperty("user.dir");
    String extensionPath = "\\src\\test\\java\\nganttt\\btvn\\buoi8\\extension\\extension_5_3_3_0.crx";

    String nameLabelText = "Student Name";
    String emailLabelText = "Student Email";
    String genderLabelText = "Gender";
    String mobileLabelText = "Mobile";
    String dobLabelText = "Date of Birth";
    String subjectLabelText = "Subjects";
    String hobbiesLabelText = "Hobbies";
    String pictureLabelText = "Picture";
    String addressLabelText = "Address";
    String stateAndCityLabelText = "State and City";

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.getInstance(DriverManagerType.CHROME);

        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File(path + extensionPath));

        webDriver = new ChromeDriver(options);

        formPage = new FormPage(webDriver);

    }

    @BeforeMethod
    public void beforeMethod() {
        formPage.gotoPage();

        String originalWindow = webDriver.getWindowHandle();
        webDriver.switchTo().window(originalWindow);
    }

    @Test(dataProvider = "StudentInfoFunction", dataProviderClass = TestDataProvider.class)
    public void enterInfoToForm(StudentModel studentModel) throws InterruptedException {
        String name, dob, stateAndCity;

        name = studentModel.getFirstName() + " " + studentModel.getLastName();
        if (studentModel.getDay().length() == 1) {
            dob = "0" + studentModel.getDay() + " " + studentModel.getMonth() + "," + studentModel.getYear();
        } else {
            dob = studentModel.getDay() + " " + studentModel.getMonth() + "," + studentModel.getYear();
        }
        if (studentModel.getState() != "") {
            stateAndCity = studentModel.getState() + " " + studentModel.getCity();
        } else {
            stateAndCity = studentModel.getState() + studentModel.getCity();
        }

        formPage.isGoToPageSuccess();

        formPage.enterInfo(studentModel);
        formPage.verifyValue(nameLabelText, name);
        formPage.verifyValue(emailLabelText, studentModel.getEmail());
        formPage.verifyValue(genderLabelText, studentModel.getGender());
        formPage.verifyValue(mobileLabelText, studentModel.getMobile());
        formPage.verifyValue(dobLabelText, dob);
        formPage.verifyValue(subjectLabelText, studentModel.getSubject());
        formPage.verifyValue(hobbiesLabelText, studentModel.getHobbies());
        formPage.verifyValue(pictureLabelText, studentModel.getFileName());
        formPage.verifyValue(addressLabelText, studentModel.getAddress());
        formPage.verifyValue(stateAndCityLabelText, stateAndCity);
    }

    @AfterClass
    public void afterClass() {
        webDriver.quit();
    }
}
