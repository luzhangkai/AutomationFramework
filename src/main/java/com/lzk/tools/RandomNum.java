package com.lzk.tools;

import com.lzk.log4j.LoggerControler;

import java.util.Random;

public class RandomNum {
    final static LoggerControler log = LoggerControler.getLogger(RandomNum.class);
    //获取一个n位数的数字
    public static  String getNumRandom(int length){
        String num ;
        num  = String.valueOf((long)(Math.random()*Math.pow(10,length)));
        return num;
    }
    //获取一个m,n之间的数
    public static long getNumRandom(int min,int max){
        int num = 0;
        Random random = new Random();
        num = random.nextInt(max-min+1)+min;
        return num;
    }
    //获取一个n位长度的字母加数字组合
    public static  String getStringRandom(int length){
        String var="";
        Random random = new Random();
        for(int i=0;i<length;i++){
            String charornum = random.nextInt(2)%2==0?"char":"num";
            if(charornum.equals("char")){
                int temp = random.nextInt(2)%2==0?65:97;
                var+=(char)(random.nextInt(26)+temp);
            }else if(charornum.equals("num")){
                var+=String.valueOf(random.nextInt(10));
            }
        }
        return  var;
    }
}
