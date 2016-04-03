package com.cdc;

import java.io.*;

/**
 * 字节流
 * Created by hanrong on 2016/4/3.
 */
public class ByteStream {

    public static void main(String[] args) {

        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
//            bufferedInputStream = new BufferedInputStream(new FileInputStream("原件.txt"));
//            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("复件.txt"));
            bufferedInputStream = new BufferedInputStream(new FileInputStream("原件.jpg"));
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("复件.jpg"));

            int i;
            byte[] bytes = new byte[1];
            while ((i = bufferedInputStream.read(bytes)) != -1) {
                bufferedOutputStream.write(bytes);
                bufferedOutputStream.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedInputStream.close();
                bufferedOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
