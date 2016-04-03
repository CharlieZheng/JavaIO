package com.cdc;

import java.io.*;

/**
 * 记录一个程序运行的次数，当满足指定次数时，该程序就不可以再继续运行了
 * 通常可用于软件使用次数的限定
 * Created by hanrong on 2016/4/3.
 */
public class NomoreUsed {
    private static final int MAX_TIMES = 2;
    private static final int INVALID_VALUE = Integer.MIN_VALUE;

    public static void main(String[] args) {
        int usedTimes = INVALID_VALUE;
        BufferedReader bufferedReader;
        BufferedWriter bufferedWriter;
        try {
            bufferedReader = new BufferedReader(new FileReader("usedTimes.txt"));
            String str;
            while ((str = bufferedReader.readLine()) != null) {


                usedTimes = Integer.valueOf(str);


            }


                bufferedReader.close();


        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            try {
                bufferedWriter = new BufferedWriter(new FileWriter("usedTimes.txt"));
                bufferedWriter.write("0");
                bufferedWriter.flush();
                bufferedWriter.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        }

        try {
            bufferedWriter = new BufferedWriter(new FileWriter("usedTimes.txt"));
            if (usedTimes == INVALID_VALUE) {

                bufferedWriter.write("0");
                bufferedWriter.flush();

            } else {
                bufferedWriter.write((++usedTimes) + "");
                bufferedWriter.flush();
            }

                bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (usedTimes > MAX_TIMES) {
// 不可用
            System.out.println("不可用");
        } else if (usedTimes == INVALID_VALUE) {
            System.out.println("出错");

        } else {
            // 可用
            System.out.println("可用");
        }
    }
}
