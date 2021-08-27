package io;

import java.io.*;

/**
 * 使用缓冲字符输入流读取文本数据
 */
public class BRDemo {
    public static void main(String[] args) throws IOException {
        /*
            将当前程序源代码读取出来并输出到控制台上
         */
        FileInputStream fis = new FileInputStream("./src/io/BRDemo.java");
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        String line;
        /*
            String readLine()
            读取一行字符串,返回的字符串不包含这行最后的换行符.如果此行为空行则返回值为空字符串.
            当流读取到了末尾时会返回null.
         */
        while((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
    }
}






