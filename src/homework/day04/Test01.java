package homework.day04;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 改正下面程序的错误
 * <p>
 * 程序实现的功能需求:复制一个文件
 *
 * @author Xiloer
 */
public class Test01 {
    public static void main(String[] args) throws IOException {
        //导包
        FileInputStream fis
                = new FileInputStream("test.txt");
        //向复制文件写操作要用文件输出流
        FileInputStream fos
                = new FIleInputStream("test_cp.txt");//这里类名拼写也有错误

        int d;
        while ((d = fis.read()) != -1) {
            fos.write(fis.read());//复制过程不能读两次，写一次
        }
        System.out.println("复制完毕!");
        fis.close();
        fos.close();
    }
}




