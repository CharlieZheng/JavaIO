package com.cdc;

import java.io.*;

/**
 * 练习：将一个文本文件的数据展示在控制台上
 * Created by hanrong on 2016/4/3.
 */
public class Text2Console {

    public static void main(String[] args) {

        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
//            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("原件.txt"), "utf-8"));
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("原件no-utf8.txt"), "GBK"));
//            bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out, "utf-8"));
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out, "GBK"));
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
