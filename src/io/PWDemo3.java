package io;

import java.io.*;
import java.util.Scanner;

/**
 * 简易记事本
 * 程序启动后,要求将控制台输入的每一行字符串都按行写入到文件note.txt中
 * 当单独输入exit时程序退出.
 * 要求:自行完成流连接
 */
public class PWDemo3 {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        FileOutputStream fos = new FileOutputStream("note.txt");
        OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
        BufferedWriter bw = new BufferedWriter(osw);
        PrintWriter pw = new PrintWriter(bw,true);

//        PrintWriter pw = new PrintWriter(
//                new BufferedWriter(
//                        new OutputStreamWriter(
//                                new FileOutputStream("note.txt"),"UTF-8"
//                        )
//                )
//        );

        Scanner scanner = new Scanner(System.in);
        while(true){
            String line = scanner.nextLine();
            if("exit".equals(line)){
                break;
            }
            pw.println(line);
        }

        pw.close();
    }
}
