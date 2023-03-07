package nganttt.btvn.buoi8.dataprovider;

import nganttt.btvn.buoi8.common.XLSReader;
import org.testng.annotations.DataProvider;

import java.io.IOException;

public class TestDataProvider {
    String path = System.getProperty("user.dir");
    String excelPath = "\\src\\test\\resources\\datatest\\nganttt\\StudenData.xlsx";
    @DataProvider(name = "StudentInfoFunction")
    public Object[][] studentInfoProvider() throws IOException {
        Object[][] testObject = XLSReader.getDataFromExcel(path+excelPath,"Sheet1");
        return testObject;
//        return new Object[][]{
//                {StudentModel.builder().firstName("Ngan").lastName("Truong").email("Abc@gmail.com").gender("Female").mobile("0984235678").day("12").month("March").year("1997").subject("Maths").hobbies("Reading").fileName("1.jpg").address("NA").state("NCR").city("Delhi").build()}
//        };
    }
}
