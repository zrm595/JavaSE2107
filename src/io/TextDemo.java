package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class TextDemo {
    public static void main(String[] args) throws IOException {
        /*
         * 写文本文件
         */
        String str = "万丈高楼平地起,辉煌成功靠自己";
        /*
         * 将字符串按照 "UTF-8" 标准进行编码, 得到编码以后
         * 的字节序列: 英文1字节, 希腊字母2字节, 中文3字节
         */
        byte[] bytes = str.getBytes("UTF-8");
        System.out.println(bytes.length);
        FileOutputStream out=new FileOutputStream("./text.txt");
        //将编码以后的字节数据存储到文件中, 存储文本编码的文件是文本文件
        out.write(bytes);
        out.close();
        //读取文本文件:
        bytes = new byte[2000];
        FileInputStream in = new FileInputStream("./text.txt");
        int n = in.read(bytes);
        System.out.println("读取了字节数:"+n);
        //对读取结果进行解码:
        String s = new String(bytes, 0, n, "UTF-8");
        System.out.println(s);
        in.close();
    }

}
