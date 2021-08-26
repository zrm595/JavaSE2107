package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyDemo01 {
    public static void main(String[] args) throws IOException {
        /*
         * 利用IO流赋值文件
         * 复制原理:
         * - 将原文件打开, 一字节一字节读取数据
         * - 将目标文件打开, 一字节一字节写入数据
         */
        //in 是原始文件
        FileInputStream in=new FileInputStream("./image.jpg");
        //out 是目标新文件
        FileOutputStream out = new FileOutputStream("./image_cp.jpg");
        /*
         * in =  01100111 10111101 11100111 00110001        ________
         *       0        1        2        3        4  ... 90
         * 指针                                              ^
         * b = in.read();
         * int b=00000000 00000000 00000000 10111101
         * out.write(b)
         * out=  01100111 10111101 -------- -------- ---------
         *       0        1        2
         * 指针                    ^
         */
        int b;
        while ((b = in.read())!=-1){
            //不要再次调用 read()
            out.write(b);
        }
        in.close();
        out.close();
    }
}

