package com.lzk.drivers;

import com.lzk.find.WebElementUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class WebElementsTest {
    @Test
    public  void test(){
        WebDriver driver = SeleniumDriver.open("chrome");
        driver.get("file:///F:/webdriver_demo/selenium_html/index.html");
        List<WebElement> webElements = WebElementUtils.findElements(By.xpath("//*[@id=\"moreSelect\"]/option"));
        String a[] ={"iphone","oppe","vivo","meizu","huawei","xiaomi"};
        for(int i=0;i<webElements.size();i++){
            String text = webElements.get(i).getText();
            System.out.println(text);
            Assert.assertEquals(a[i],text);
        }
        SeleniumDriver.close();
    }
}
