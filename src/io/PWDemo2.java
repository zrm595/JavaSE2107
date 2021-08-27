package io;

import java.io.*;

public class PWDemo2 {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        //低级流,负责将字节写入文件
        FileOutputStream fos = new FileOutputStream("pw.txt");
        //负责衔接其他字符流与字节流
        OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
        //负责块写文本数据加速
        BufferedWriter bw = new BufferedWriter(osw);
        //负责按行写出字符串,自动行刷新
        PrintWriter pw = new PrintWriter(bw);
        /*
            上述流连接后,pw.println("你好")的写出过程:
            "你好"---pw--->"你好\n"---bw--->加速写---osw--->字节---fos--->写入文件
                   按行写          缓冲加速       字符转字节      写入文件
         */
        pw.println("你好");
        pw.println("再见!");

        pw.close();
    }
}
