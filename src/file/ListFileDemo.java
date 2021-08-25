package file;

import java.io.File;

public class ListFileDemo {
    public static void main(String[] args) {
        /*
         * Java File API 提供了获取文件夹中文件列表的功能
         * - dir.listFiles() 获取dir中全部的文件和文件夹
         * - dir 必须是一个文件夹! 否则返回 null
         * - 如果是一个文件夹, 就会把文件夹内容放到数组中返回
         */
        File file = new File("./demo.txt");
        //在文件上调用 listFiles() 会返回 null(没有)
        File[] files = file.listFiles();
        System.out.println(files);

        File dir = new File("./笔记");
        //在文件夹上调用 listFiles()会返回文件夹中全部的文件和文件夹
        files = dir.listFiles();
        for(File f: files){
            System.out.println(f);
        }


    }
}
