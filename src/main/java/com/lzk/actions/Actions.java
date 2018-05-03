package com.lzk.actions;

import com.lzk.drivers.SeleniumDriver;
import com.lzk.find.WebElementUtils;
import org.openqa.selenium.By;

public class Actions extends SeleniumDriver {
    //点击方法
    public  static  void click(By by){
        WebElementUtils.findElement(by).click();
    }
    //文本框输入
    public static  void sendKeys(By by,String text){
        WebElementUtils.findElement(by).clear();
        WebElementUtils.findElement(by).sendKeys(text);
    }
}
