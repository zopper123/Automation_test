package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.*;
import java.util.*;

public class ExcelCSVUtility {

    public static List<Map<String, String>> readExcel(String filePath) throws IOException {
        List<Map<String, String>> data = new ArrayList<>();
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0);

        Row headerRow = sheet.getRow(0);
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            Map<String, String> rowData = new HashMap<>();
            for (int j = 0; j < row.getLastCellNum(); j++) {
                rowData.put(headerRow.getCell(j).getStringCellValue(), row.getCell(j).toString());
            }
            data.add(rowData);
        }
        workbook.close();
        return data;
    }
}
