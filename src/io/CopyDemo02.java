package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class CopyDemo02 {
    public static void main(String[] args) throws IOException {
        /*
         * 利用缓冲区复制文件
         */
        FileInputStream in = new FileInputStream("./image.jpg");
        FileOutputStream out = new FileOutputStream("./img.jpg");
        long t1 = System.currentTimeMillis();
        byte[] bytes = new byte[1024*8];
        int n;
        while ((n = in.read(bytes))!=-1){
            out.write(bytes,0,n);
        }
        in.close();
        out.close();
        long t2 = System.currentTimeMillis();
        System.out.println("复制完毕!耗时:"+(t2-t1));
    }
}
