package com.lzk.tools;

import com.lzk.log4j.LoggerControler;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;

public class Execl2Test {
    final static LoggerControler log = LoggerControler.getLogger(Execl2Test.class);
    @DataProvider(name="test")
    public Object[][] getData(){
        return Excel2.getData("D:\\IdeaProjects\\Selenium_Framework\\a.xlsx");
    }
    @Test(dataProvider = "test")
    public void test(HashMap<String,String> data){
        log.info(data.get("username"));
    }
}
