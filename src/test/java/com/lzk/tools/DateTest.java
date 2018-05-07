package com.lzk.tools;

import org.testng.annotations.Test;

public class DateTest {
    @Test
    public void test(){
        DateFormate.format(DateFormate.ZN_DATE_FORMAT);
        DateFormate.time();
    }
}
