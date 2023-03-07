package nganttt.btvn.buoi8.common;

import nganttt.btvn.buoi8.model.StudentModel;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class XLSReader {
    private static XSSFSheet ExcelWSheet;
    private static XSSFWorkbook ExcelWBook;
    private static XSSFCell Cell;
    private static XSSFRow Row;

    public static String getCellData(int row, int column) {//Lay GT o hang,cot
        try {
            Cell = ExcelWSheet.getRow(row).getCell(column);//lay data
            String cellValue = Cell.getStringCellValue();
            return cellValue;
        } catch (Exception e) {
            return "";
        }
    }

    public static Object[][] getDataFromExcel(String pathFile, String sheetName) throws IOException {
        String[][] tableData;

        FileInputStream excelFile = new FileInputStream(pathFile);
        ExcelWBook  = new XSSFWorkbook(excelFile);
        ExcelWSheet = ExcelWBook.getSheet(sheetName);
        int startRow = 1;
        int startColumn = 1;
        int ci;//hang data
        int cj;//cot data
        int totalRows = ExcelWSheet.getLastRowNum();
        int totalColumn = ExcelWSheet.getRow(0).getLastCellNum() - 1;
        
        Object[][] studentData = new StudentModel[totalRows][1];
        
        tableData = new String[totalRows][totalColumn];
        for (int i = startRow; i <= totalRows; i++) {
            ci = i - 1;
            for (int j = startColumn; j <= totalColumn; j++) {
                cj = j - 1;
                tableData[ci][cj] = getCellData(i, j);
            }
            var studentModel = StudentModel.builder().firstName(tableData[ci][0]).lastName(tableData[ci][1]).email(tableData[ci][2]).gender(tableData[ci][3]).mobile(tableData[ci][4]).day(tableData[ci][5]).month(tableData[ci][6]).year(tableData[ci][7]).subject(tableData[ci][8]).hobbies(tableData[ci][9]).fileName(tableData[ci][10]).address(tableData[ci][11]).state(tableData[ci][12]).city(tableData[ci][13]).build();
            studentData[ci][0]=studentModel;
        }
        excelFile.close();
        return studentData;
    }
}
