package com.lzk.tools;

import com.lzk.log4j.LoggerControler;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class ExcelTest {
    final static LoggerControler log = LoggerControler.getLogger(ExcelTest.class);
    @DataProvider(name="test")
    public static Object[][] getTestData() throws IOException {
        return  ExcelData.getData("D:\\IdeaProjects\\Selenium_Framework","a.xlsx","Sheet1");
    }
    @Test(dataProvider = "test")
    public void test(String a,String b){
        log.info(a);
        log.info(b);
    }
}
