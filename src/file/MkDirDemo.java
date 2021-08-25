package file;

import java.io.File;

public class MkDirDemo {
    public static void main(String[] args) {
        /*
         * File 可以代表文件夹
         * - File 提供了创建文件夹方法 mkdir
         *   mk: make  dir:目录
         */
        File dir = new File("./mydir");
        if (! dir.exists()){
            dir.mkdir(); //创建文件夹
            System.out.println("创建了文件夹!");
        }else{
            System.out.println("已经存在!");
        }
    }
}
