package file;

import java.io.File;

public class MkDirDemo {
    public static void main(String[] args) {
        /*
         * File 可以代表文件夹
         * - File 提供了创建文件夹方法 mkdir
         *   mk: make  dir:目录
         * - mkdirs 创建系列文件夹方法
         *   照片/老虎/第一位/2020年
         */
        File dir = new File("./照片/老虎/第一位/2020年");
        if (! dir.exists()){
            //dir.mkdir(); //创建文件夹
            dir.mkdirs();
            System.out.println("创建了文件夹!");
        }else{
            System.out.println("已经存在!");
        }
    }
}
