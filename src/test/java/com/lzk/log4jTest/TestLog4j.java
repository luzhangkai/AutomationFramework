package com.lzk.log4jTest;

import com.lzk.log4j.LoggerControler;
import org.testng.annotations.Test;

public class TestLog4j {
    final static  LoggerControler log = LoggerControler.getLogger(TestLog4j.class);
    @Test
    public void test(){
        log.info("123");
        log.debug("qqwe");
    }
}
