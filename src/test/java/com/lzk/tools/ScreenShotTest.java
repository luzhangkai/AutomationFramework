package com.lzk.tools;

import com.lzk.drivers.SeleniumDriver;
import com.lzk.log4j.LoggerControler;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class ScreenShotTest {
    final static LoggerControler log = LoggerControler.getLogger(ScreenShotTest.class);
    @Test
    public void test(){
        WebDriver driver = SeleniumDriver.open("chrome");
        driver.get("https://www.baidu.com/");
        MyAssert.assertEquals("aa1","111");
    }


}
