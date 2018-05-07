package com.lzk.tools;

import com.lzk.log4j.LoggerControler;
import org.testng.annotations.Test;

public class TestRandom {
    final static LoggerControler log = LoggerControler.getLogger(TestRandom.class);
    @Test
    public  void test(){
        String a = RandomNum.getNumRandom(5);
        log.info(a);
    }
    @Test
    public  void test2(){
        String a =String.valueOf(RandomNum.getNumRandom(1000,2000)) ;
        log.info(a);
    }
    @Test
    public void test3(){
        String b = RandomNum.getStringRandom(10);
        log.info(b);
    }
}
