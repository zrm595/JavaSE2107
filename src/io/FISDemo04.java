package io;

import java.io.FileInputStream;
import java.io.IOException;

public class FISDemo04 {
    public static void main(String[] args) throws IOException {
        /*
         * 批量读取文件
         * 每次将从文件中读取尽可能多的数据填充到 byte数组中
         * 返回读取的字节数据, 如果读取到文件末尾, 返回-1
         */
        FileInputStream in = new FileInputStream("./image.jpg");
        //创建一个内存数组, 也称为内存缓冲区. 大小为 8K
        byte[] bytes = new byte[1024*8];
        int n;
        while ((n = in.read(bytes))!=-1){
            System.out.println(n);
        }
        System.out.println(n);
        in.close();
    }
}
