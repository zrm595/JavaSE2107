package io;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * 缓冲字符流
 * java.io.BufferedWriter和BufferedReader
 * 缓冲字符流内部也有一个数组用于块读写文本数据来提高读写效率
 *
 * java.io.PrintWriter具有自动行刷新的缓冲字符输出流并且可以按行写出字符串,其内部总是
 * 连接这BufferedWriter作为缓冲加速
 */
public class PWDemo {
    public static void main(String[] args) throws FileNotFoundException {
        /*
            提供了对文件写操作的构造方法
            PrintWriter(File file)
            PrintWriter(String filename)
         */
        //对文件pw.txt写操作
        PrintWriter pw = new PrintWriter("pw.txt");

        pw.println("万丈高楼平地起,辉煌只能靠自己~");
        pw.println("社会很单纯,复杂滴是人~");
        pw.println("嘿~巴扎黑~");
        System.out.println("写出完毕!");
        pw.close();

    }
}
