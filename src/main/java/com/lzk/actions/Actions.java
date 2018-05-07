package com.lzk.actions;

import com.lzk.drivers.SeleniumDriver;
import com.lzk.find.WebElementUtils;
import com.lzk.log4j.LoggerControler;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Actions extends SeleniumDriver {
    final static LoggerControler log = LoggerControler.getLogger(Actions.class);
    //点击方法
    public  static  void click(By by){
        WebElementUtils.findElement(by).click();
        log.info("点击："+by);
    }
    //文本框输入
    public static  void sendKeys(By by,String text){
        WebElementUtils.findElement(by).clear();
        WebElementUtils.findElement(by).sendKeys(text);
        log.info("文本框"+by+"输入"+text);
    }
    //获取文本
    public  static  String getText(By by){
        String text = WebElementUtils.findElement(by).getText();
        return  text;
    }
    //获取文本集
    public  static ArrayList getTexts(By by){
        ArrayList arrayList = new ArrayList();
        List<WebElement> list = WebElementUtils.findElements(by);
        for(int i=0;i<list.size();i++){
            String text = list.get(i).getText();
            arrayList.add(text);
        }
        return  arrayList;
    }
}
