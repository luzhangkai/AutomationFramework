package com.lzk.tools;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelData {
    public static Object[][] getData(String filePath,String fileName,String sheetName) throws IOException {
        File file = new File(filePath+"\\"+fileName);
        FileInputStream inputStream = new FileInputStream(file);
        Workbook Workbook = null;
        String fileExtensionName = fileName.substring(fileName.indexOf("."));
        if(fileExtensionName.equals(".xlsx")){
            Workbook = new XSSFWorkbook(inputStream);
        }else  if(fileExtensionName.equals(".xls")){
            Workbook = new HSSFWorkbook(inputStream);
        }
        Sheet Sheet = Workbook.getSheet(sheetName);
        int rowCount = Sheet.getLastRowNum() - Sheet.getFirstRowNum();
        List<Object[]> records = new ArrayList<Object[]>();
        for(int i=1;i<rowCount+1;i++){
            Row row = Sheet.getRow(i);
            String fields[] = new String[row.getLastCellNum()];
            for(int j=0;j<row.getLastCellNum();j++){
                fields[j]=row.getCell(j).getStringCellValue();
            }
            records.add(fields);
        }
        Object[][] results = new Object[records.size()][];
        for(int i=0;i<records.size();i++){
            results[i]=records.get(i);
        }
        return results;
    }
}
