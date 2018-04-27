package com.lzk.find;

import com.lzk.drivers.SeleniumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class WebElementUtils extends SeleniumDriver {
    public  static WebElement findElement(final By by){
        WebElement element = null;
        try{
            WebDriverWait wait =new WebDriverWait(driver,30);
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
        }catch (Exception e){
            System.out.println("元素查找超时");
            e.printStackTrace();
        }
        return driver.findElement(by);
    }
    public static List<WebElement> findElements(By by){
        List<WebElement> webElements = null;
        try{
            WebDriverWait wait =new WebDriverWait(driver,30);
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
        }catch (Exception e){
            System.out.println("元素查找超时");
            e.printStackTrace();
        }
        return driver.findElements(by);
    }
}
