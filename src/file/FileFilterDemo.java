package file;

import java.io.File;
import java.io.FileFilter;

public class FileFilterDemo {
    public static void main(String[] args) {
        /*
         * 有条件的列出目录的内容
         *   listFiles(过滤条件)
         * - 有条件的列出目录 的内容, 满足条件的文件作为返回数组的成员
         * - 不满足条件的文件被过滤掉
         * - 过滤条件是一个接口, 包含一个过滤方法
         *    listFiles 会自动调用过滤方法,筛选文件
         * 过滤条件: FileFilter
         * Filter: 过滤器
         */
        //过滤条件: 筛选 .txt 的文件
        FileFilter filter = new FileFilter() {
            @Override //过滤器的筛选方法
            public boolean accept(File pathname) {
                //写筛选逻辑: pathname 代表每个被赛选的文件
                //先找到文件名, 检查文件名的末尾是否以.txt为结束
                //方法返回true表示文件是被选定的文件,
                //返回false就是被忽略的文件
                String name = pathname.getName();
                return name.endsWith(".txt");
            }
        };
        File dir = new File("./");
        if (dir.isDirectory()){
            File[] files = dir.listFiles(filter);
            for(File file: files){
                System.out.println(file);
            }
        }

    }
}
