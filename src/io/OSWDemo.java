package io;

import java.io.*;

/**
 * 字符流
 * java将IO中的流按照读写数据的单位划分为字节流与字符流
 * 字节流的超类:java.io.InputStream和OutputStream
 * 字符流的超类:java.io.Reader和Writer
 * 字符流是以字符(char)为最小单位读写数据的,因此字符流仅适合读写文本数据.
 *
 *
 * 转换流
 * java.io.InputStreamReader和OutputStreamWriter
 * 它们是常用的字符流实现类,实际开发中我们通常不会直接操作这两个流,但是在流连接中它们是重要
 * 的一环.
 *
 */
public class OSWDemo {
    public static void main(String[] args) throws IOException {

        FileOutputStream fos = new FileOutputStream("osw.txt");
        //第二个参数为字符集,通过当前字符流写出的字符都会按照该字符集转换为字节
        OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");

        String str = "苍老师:吃个桃桃~";
        osw.write(str);
        osw.write("嗯~~好凉凉~");

        System.out.println("写出完毕!");
        osw.close();



    }
}
