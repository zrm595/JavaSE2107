package io;

import java.io.*;

public class BufferedDemo {
    public static void main(String[] args) throws IOException {
        /*
         * 缓冲流案例
         * - 在改变IO代码情况下, 可以为程序添加缓冲区, 提升性能
         * - 建议所有文件访问时候, 都有添加缓冲流!
         * - 缓冲流是高级流, 必须依赖其他流
         */
        FileInputStream fis = new FileInputStream("./image.jpg");
        //将缓冲流套在文件输入流的外面, 为文件流扩展了缓冲区. 扩展后不要再使用
        //原有的文件流fis, 要直接使用缓冲流bis
        BufferedInputStream bis = new BufferedInputStream(fis);

        FileOutputStream fos = new FileOutputStream("./img.jpg");
        //在文件输出流外面套接缓冲流, 就是为文件输出流扩展了缓冲区
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        int b;
        while((b = bis.read())!=-1){
            bos.write(b);
        }
        //关闭外部的处理流时候, 处理流就会关闭内部套接的底层流
        bis.close();
        bos.close();
        System.out.println("复制完成!");
    }
}
