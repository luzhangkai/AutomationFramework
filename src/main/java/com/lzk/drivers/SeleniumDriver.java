package com.lzk.drivers;

import com.lzk.log4j.LoggerControler;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class SeleniumDriver {
    final static LoggerControler log = LoggerControler.getLogger(SeleniumDriver.class);
    public  static WebDriver driver;
    public  static WebDriver open(String browser){
        String path=System.getProperty("user.dir");
        if(browser.equals("chrome")){
            System.setProperty("webdriver.chrome.driver",path+"/drivers/chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.setHeadless(true);
            options.addArguments("disable-infobars");
            driver = new ChromeDriver(options);
        }else if(browser.equals("IE")){
            System.setProperty("webdriver.ie.driver",path+"/drivers/IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }else if(browser.equals("FireFox")){
            System.setProperty("webdriver.gecko.driver",path+"/drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        }else if(browser.equals("Edge")){
            System.setProperty("webdriver.edge.driver",path+"/drivers/MicrosoftWebDriver.exe");
            driver = new EdgeDriver();
        }else{
//            System.out.println("您输入的浏览器名称有误"+browser);
            log.error("您输入的浏览器名称有误");
        }
        return driver;
    }
    public static void close(){
        driver.close();
    }
}
