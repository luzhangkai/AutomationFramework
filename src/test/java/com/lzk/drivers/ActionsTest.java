package com.lzk.drivers;

import com.lzk.actions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class ActionsTest {
    @Test
    public void test(){
        WebDriver driver = SeleniumDriver.open("chrome");
        driver.get("https://www.baidu.com/");
        Actions.sendKeys(By.name("wd"),"selenium");
        Actions.click(By.id("su"));

    }
}
