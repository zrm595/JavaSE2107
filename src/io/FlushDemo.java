package io;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FlushDemo {
    public static void main(String[] args) throws IOException {
        /*
         * 演示文件缓冲刷出功能
         */
        FileOutputStream fis = new FileOutputStream("./flush.txt");
        BufferedOutputStream bos=new BufferedOutputStream(fis);

        bos.write(65);
        bos.write(66);
        bos.write(67);
        bos.write(67);
        /*
         * - flush()强行将缓冲区内容写到文件中
         * - 尽管调用flash可以可靠写数据, 但是频繁调用flash就会降低缓冲性能
         */
        //bos.flush();
        //close() 方法包含 flush功能, 也就是关闭文件时候会自动将缓冲内容写到
        // 文件中, 这样体现关闭文件的重要性! 也就是关闭文件可以保证数据可靠写到文件中
        bos.close();
    }
}
