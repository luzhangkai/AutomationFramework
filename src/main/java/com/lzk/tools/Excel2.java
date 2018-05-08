package com.lzk.tools;

import com.lzk.log4j.LoggerControler;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Excel2 {
    final static LoggerControler log = LoggerControler.getLogger(Excel2.class);
    public static Workbook getWorkbook(String filePath){
        Workbook workbook = null;
        try {
            if(filePath.endsWith(".xls")){
                File file = new File(filePath);
                FileInputStream inputStream = new FileInputStream(file);
                workbook = new HSSFWorkbook(inputStream);
            }else if(filePath.endsWith(".xlsx")){
                workbook = new XSSFWorkbook(filePath);
            }

        }catch (IOException e){
            e.printStackTrace();
        }
        return  workbook;
    }
    public static String getCellValue(Sheet sheet,int rowNum,int cellNum){
        Cell cell = sheet.getRow(rowNum).getCell(cellNum);
        String value = Excel2.getCellValue(cell);
        return  value;
    }
    public static String getCellValue(Cell cell){
        String value="";
        switch (cell.getCellTypeEnum()){
            case STRING:
                value = String.valueOf(cell.getStringCellValue());
                return value;
            case NUMERIC:
                value = String.valueOf(cell.getNumericCellValue());
                return value;
            case BOOLEAN:
                value = String.valueOf(cell.getBooleanCellValue());
                return value;
            case FORMULA:
                value = String.valueOf(cell.getCellFormula());
                return value;
        }
        return  value;
    }
    public static Object[][] getData(String file){
        ArrayList<String > arrayList = new ArrayList<String>();
        Workbook workbook = Excel2.getWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);
        //获取总行数
        int rows = sheet.getLastRowNum()+1;
        //获取总列数
        int columns = sheet.getRow(0).getPhysicalNumberOfCells();
        HashMap<String,String>[][] map = new HashMap[rows-1][1];
        if(rows>1){
            for(int i=0;i<rows-1;i++){
                map[i][0] = new HashMap();
            }
        }else {
            log.error("测试文件无数据");
        }
        //获取首行列名
        for(int i=0;i<columns;i++){
            String cellValue = Excel2.getCellValue(sheet,0,i);
            arrayList.add(cellValue);
        }
        for(int i=1;i<rows;i++){
            for(int j=0;j<columns;j++){
                String cellValue = Excel2.getCellValue(sheet,i,j);
                map[i-1][0].put(arrayList.get(j),cellValue);
            }
        }
        return  map;
    }
}
