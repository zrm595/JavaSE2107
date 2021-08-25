package file;

import java.io.File;
import java.io.IOException;

public class CreateNewFile {
    public static void main(String[] args) throws Exception {
        /*
         * file API 提供了创建文件的方法
         *   file.createNewFile()
         * - 磁盘上没有文件时候才能创建一个新文件
         *   并且返回true表示文件创建成功
         * - 如果磁盘上已经有文件了, 就不创建文件
         *   返回false表示创建失败
         * - 如果创建时候文件系统不能写,会出现异常
         */
        File file = new File("./test.txt");
//        boolean created = file.createNewFile();
//        if (created){
//            System.out.println("创建成功!");
//        }else {
//            System.out.println("创建失败!");
//        }

        if (! file.exists()){
            file.createNewFile();
            System.out.println("创建了文件");
        }else {
            System.out.println("文件已经存在");
        }

    }
}


