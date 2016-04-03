package com.cdc;

import java.io.*;
import java.util.Properties;

/**
 * 记录一个程序运行的次数，当满足指定次数时，该程序就不可以再继续运行了
 * 通常可用于软件使用次数的限定
 * Created by hanrong on 2016/4/3.
 */
public class NomoreUsed2 {
    private static final int MAX_TIMES = 2;
    private static final int INVALID_VALUE = Integer.MIN_VALUE;

    private static Properties properties;

    public static void main(String[] args) {
        properties = new Properties();
        int usedTimesInt = INVALID_VALUE;
        BufferedInputStream bufferedInputStream ;
        BufferedOutputStream bufferedOutputStream ;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream("usedTimes.txt"));
            properties.load(bufferedInputStream);
            String usedTimes = properties.getProperty("usedTimes");
            System.out.println(usedTimes);
            usedTimesInt = Integer.valueOf(usedTimes);

            bufferedInputStream.close();
        }  catch (IOException e) {
            e.printStackTrace();
        }

        try {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("usedTimes.txt"));
            if (usedTimesInt == INVALID_VALUE) {

                properties.store(bufferedOutputStream, "usedTimes=0");

            } else {

                properties.store(bufferedOutputStream, "usedTimes=" + (++usedTimesInt) + "");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        if (usedTimesInt > MAX_TIMES) {
// 不可用
            System.out.println("不可用");
        } else if (usedTimesInt == INVALID_VALUE) {
            System.out.println("出错");

        } else {
            // 可用
            System.out.println("可用");
        }
    }
}
