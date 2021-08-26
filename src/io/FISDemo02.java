package io;

import java.io.FileInputStream;
import java.io.IOException;

public class FISDemo02 {
    public static void main(String[] args) throws IOException {
        /*
         * 文件输入流
         */
        /*
         * 构造器
         * - 必须提供文件名参数, 或者文件对象
         * - 如果文件存在, 就打开文件, 如果文件不存在则出现异常
         * - 文件打开后文件指针在0位置
         */
        FileInputStream fis = new FileInputStream("./fos.dat");
        /*
         * 文件读取方法
         * fis ->  00110010 00110011 00110100 _ _ _ _ _
         *         0        1        2        3        4
         * 文件指针                            ^
         *
         * b =     00000000 00000000 00000000 00110010
         * b =     00000000 00000000 00000000 00110011
         * b =     00000000 00000000 00000000 00110100
         * b =     11111111 11111111 11111111 11111111
         * 读取原理 read():
         * - 每次从文件中读取一个字节, 填充到int的低8位返回
         *    正常返回值范围: 0 ~ 255
         * - 自动将文件指针移动到下一个位置, 为下次读取做准备
         * - 当读取到文件末尾时候, 返回-1表示结束
         */
        int b = fis.read(); //50
        System.out.println(b);
        b = fis.read();  //51
        System.out.println(b);
        b = fis.read();  //52
        System.out.println(b);
        b = fis.read();  //-1
        System.out.println(b);
        fis.close();
    }
}
