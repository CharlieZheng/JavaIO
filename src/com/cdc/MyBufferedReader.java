package com.cdc;

import java.io.*;

/**
 * 字符流
 * Created by hanrong on 2016/4/3.
 */
public class MyBufferedReader {
    private FileReader fileReader;
    private String fileName;

    public MyBufferedReader(FileReader fileReader) {
        this.fileReader = fileReader;
    }

    public MyBufferedReader(String fileName) {
        this.fileName = fileName;
        if (fileReader == null) {
            try {
                fileReader = new FileReader(fileName);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public String readLine() {
        StringBuffer stringBuffer = new StringBuffer();

        try {
            int i;
            while ((i = fileReader.read()) != -1) {
                if (i == '\r') {
                    continue;
                } else if (i == '\n') {
                    return stringBuffer.toString();
                }

                stringBuffer.append((char) i);
            }
            if (stringBuffer != null && stringBuffer.length() > 0) {
                return stringBuffer.toString();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void close() {
        try {
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {

        MyBufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
//            bufferedReader = new MyBufferedReader(new FileReader("原件.txt"));
            bufferedReader = new MyBufferedReader("原件.txt");
            bufferedWriter = new BufferedWriter(new FileWriter("复件.txt"));
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
                bufferedReader.close();
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
