package io;

import java.io.*;

/**
 * 使用转换流读取文本数据
 */
public class ISRDemo {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("osw.txt");
        InputStreamReader isr = new InputStreamReader(fis,"UTF-8");
        /*
            字符输入流也提供了read方法用于读取字符.
            int read()
            读取一个字符,并以int型返回,若返回的int值为-1则表示读取到了末尾.
         */
        int d;
        while((d = isr.read()) != -1) {
            char c = (char) d;
            System.out.print(c);
        }
        isr.close();

    }
}
