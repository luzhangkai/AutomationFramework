package com.lzk.actions;

import com.lzk.drivers.SeleniumDriver;
import com.lzk.log4j.LoggerControler;
import com.lzk.tools.DateFormate;
import com.lzk.tools.MyFile;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;

import java.io.File;
import java.io.IOException;

public class ScreenShot extends SeleniumDriver {
    static final LoggerControler log = LoggerControler.getLogger(ScreenShot.class);
    static String path = System.getProperties().getProperty("user.dir") + "/error-img/";
    /**
     * 错误截图，通过日期命名的截图
     **/
    public static void screenShots() {
        WebDriver augmentedDriver = new Augmenter().augment(driver);
        File file = ((TakesScreenshot)augmentedDriver).getScreenshotAs(OutputType.FILE);
        //根据日期创建文件夹，CHECK_LOG_FORMAT = "yyyyMMdd";REPORT_CSV_FORMAT = "yyyyMMdd_HHmmss";
        MyFile myFile=new MyFile();
        String myPath=path+String.valueOf(DateFormate.format(DateFormate.CHECK_LOG_FORMAT));
        System.out.print(myPath);
        myFile.createFile1(myPath);
        try {
             FileUtils.copyFile(file,new File(myPath + "/" + DateFormate.format(DateFormate.REPORT_CSV_FORMAT) + ".png"));
        } catch (IOException e) {
            log.error("截图失败！！");
            e.printStackTrace();
        }
    }
    /**
     * 错误截图,通过传入name来给截图命名
     **/
    public static void screenShots1(String name) {
        WebDriver augmentedDriver = new Augmenter().augment(driver);
        File file = ((TakesScreenshot)augmentedDriver).getScreenshotAs(OutputType.FILE);
        try {
            MyFile myFile = new MyFile();
            myFile.createFile1(path + DateFormate.format(DateFormate.CHECK_LOG_FORMAT));
            log.info(DateFormate.format(DateFormate.ZH_DATE_FORMAT));
            FileUtils.copyFile(file,new File(path + DateFormate.format(DateFormate.CHECK_LOG_FORMAT) + "/" + name + ".jpg"));
        } catch (IOException e) {
            log.error("截图失败！！");
            e.printStackTrace();
        }
    }

    /**
     * 判断文件夹，没有就新建
     */
/*    public static void fileExists() {
        String fileName = DateUtil.format(DateUtil.CHECK_LOG_FORMAT);
        File file = new File(path + fileName);
        if (!file.exists()) {
            file.mkdirs();
        }
    }*/
}


