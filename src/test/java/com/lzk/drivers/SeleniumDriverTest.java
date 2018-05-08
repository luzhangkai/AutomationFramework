package com.lzk.drivers;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class SeleniumDriverTest {
    @Test
    public void openTest(){
        WebDriver driver = SeleniumDriver.open("chrome");
        SeleniumDriver.close();
    }
}
