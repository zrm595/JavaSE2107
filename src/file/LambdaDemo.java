package file;

import java.io.File;
import java.io.FileFilter;

public class LambdaDemo {
    public static void main(String[] args) {
        /*
         * lambda 表达式
         * Java 8 提供一个语法
         * - 用于简化匿名内部类的定义
         * - 可以看做不用关心类名和方法名的匿名类
         * - 如果参数只有一个, 可以省略 () 和 变量类型
         *   如果方法体只有一行 可以省略 {;} 和 return
         * - 要求: 接口只能有一个方法时候才能使用lambda语法
         */
        FileFilter filter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".txt");
            }
        };
        //简化版本1: 省略的类名和方法名
        FileFilter filter1 =
                (File pathname)->{return pathname.getName().endsWith(".txt");};
        //简化版本2: 省略了()参数类型, 省略了{} 和 return
        FileFilter filter2 = pathname->pathname.getName().endsWith(".txt");

        File dir = new File("./");
        if (dir.isDirectory()){
            File[] files = dir.listFiles(
                    pathname->pathname.getName().endsWith(".txt"));
            for(File file: files){
                System.out.println(file);
            }
        }

    }
}
