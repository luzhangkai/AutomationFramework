package com.lzk.drivers;

import com.lzk.find.WebElementUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class WebElementUtilsTest {
    @Test
    public void findTest(){
        WebDriver driver = SeleniumDriver.open("chrome");
        driver.get("file:///F:/webdriver_demo/selenium_html/index.html");
        WebElementUtils.findElement(By.className("wait")).click();
        String text = WebElementUtils.findElement(By.className("red")).getText();
        System.out.println(text);
    }
}
