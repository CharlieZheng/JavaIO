package com.cdc;

import java.io.*;

/**
 * 将键盘录入的数据存储到一个文件中
 * Created by hanrong on 2016/4/3.
 */
public class Console2Text {
    public static void main(String[] args) {

        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
//            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("原件.txt"), "utf-8"));
            bufferedReader = new BufferedReader(new InputStreamReader(System.in, "utf-8"));
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("复件.txt"), "utf-8"));
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                bufferedWriter.write(str);
                bufferedWriter.flush();
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
