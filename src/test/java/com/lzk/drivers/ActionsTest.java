package com.lzk.drivers;

import com.lzk.actions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class ActionsTest {
    @Test
    public void test(){
        WebDriver driver = SeleniumDriver.open("chrome");
        driver.get("https://www.baidu.com/");
        Actions.sendKeys(By.name("wd"),"selenium");
        Actions.click(By.id("su"));
        driver.close();
    }
    @Test
    public  void test2(){
        WebDriver driver = SeleniumDriver.open("chrome");
        driver.get("file:///F:/webdriver_demo/selenium_html/index.html");
        ArrayList arrayList = Actions.getTexts(By.xpath("//*[@id=\"moreSelect\"]/option"));
        for(int i=0;i<arrayList.size();i++){
            System.out.println(arrayList.get(i));
        }
        driver.close();
    }

}
