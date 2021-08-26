package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FISDemo03 {
    public static void main(String[] args) throws IOException {
        /*
         * 循环读取文件全部字节
         */
        FileInputStream in = new FileInputStream("./fos.dat");
        int b;
        //     (b=-1)
        //      -1 != -1  false
        while((b=in.read())!=-1){ //读取到-1就结束了
            System.out.println(b);//50 51 52 255 66 67 68
        }
        System.out.println(b);
        in.close();
    }
}
