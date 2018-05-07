package com.lzk.tools;

import com.lzk.log4j.LoggerControler;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;
public class DateFormate {
    final static LoggerControler log = LoggerControler.getLogger(DateFormate.class);
    public static final String ZH_DATE_FORMAT="yyyy-MM-dd HH:mm:ss";
    public static final String ZN_DATE_FORMAT="yyyy年MM月dd日 HH:mm:ss";
    public static final String ZC_DATE_FORMAT="yyyy年MM月dd日";
    public static final String SHORT_DATE_FORMAT = "yy-MM-dd HH:mm";
    public static final String CHECK_LOG_FORMAT = "yyyyMMdd";
    public static final String REPORT_CSV_FORMAT = "yyyyMMdd_HHmmss";
    private static SimpleDateFormat simpleDateFormat;

    public static String format(String type){
        simpleDateFormat=new SimpleDateFormat(type);
        String s=simpleDateFormat.format(new Date());
        log.info("当前时间为："+s);
        return s;
    }
    public static String time(){
        long currtime= System.currentTimeMillis()/100;
        String randomNum=String.valueOf(currtime);
        log.info("11位的随机数为："+randomNum);
        return randomNum;
    }
}
