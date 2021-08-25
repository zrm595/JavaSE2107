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
        /*
         * Java 5 提供了增强for循环(for each循环), 用于替换传统for循环
         * 原因是 代码短!!! for(File f: files)
         */
        for(File f: files){
        //for (int i=0; i<files.length; i++){
        //    File f = files[i];
            System.out.println(f);
        }
        /*
         * File 提供了API 方法用于检查是文件还是文件夹
         * - isFile() 如果当前对象是一个文件则返回true否则返回false
         * - isDirectory() 如果当前对象是一个文件夹返回true, 否则false
         */
        System.out.println(file.isDirectory()); //false
        System.out.println(file.isFile());      //true
        System.out.println(dir.isDirectory());  //true
        System.out.println(dir.isFile());       //false

        /*
         * 改进版本: 如果当前对象是一个目录(文件夹),再执行列出
         * 文件夹内容的功能.
         *  ./ 表示当前文件夹, 这里就是当前项目文件夹
         */
        dir = new File("./");
        System.out.println("列出当前目录内容:");
        if(dir.isDirectory()){
            File[] files1 = dir.listFiles();
            for (File f: files1){
                System.out.println(f);
            }
        }

    }
}
