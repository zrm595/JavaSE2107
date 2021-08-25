package file;

import java.io.File;
import java.util.Date;

public class FileDemo {
    public static void main(String[] args) {
        /*
         * File API
         * - File 代表一个文件夹或者文件夹
         * - 使用时候需要先创建File对象, 创建时候需要给定代表文件\文件夹名
         */
        /*
         * 文件名两种表示方式:绝对路径, 相对路径
         * 绝对路径: C:\Users\TEDU\IdeaProjects\JavaSE2107\demo.txt
         *   绝对路径使用非常不方便, 开发时候经常使用相对路径
         * 相对路径: 相对路径的起始位置是java程序命令的启动位置.
         *   在IDEA Java程序启动位置就是 项目文件夹 JavaSE2107
         *   当写成 ./demo.txt 时候,就表示在 JavaSE2107中的demo.txt
         *   相对路径, 可以兼容各种操作系统
         */
        File file = new File("./demo.txt");
        System.out.println(file);
        /*
         * File 能够访问文件的属性信息: 文件长度\文件创建时间\文件是否可读
         */
        long length = file.length(); //返回文件中字节的个数
        System.out.println(length); //如果返回是0表示没有找到文件或者长度真的0
        /*
         * 检查文件是否可读 可写
         * can: 能否
         * Read: 读
         * Write: 写
         */
        boolean r = file.canRead();
        boolean w = file.canWrite();
        System.out.println("可读:"+r);
        System.out.println("可写:"+w);

        /*
         * 读取文件的最后编辑时间
         * last: 最后
         * Modify: 编辑
         * 返回值: java 底层的系统时间, 从1970年元旦到现在累计的毫秒数
         */
        long t = file.lastModified();
        System.out.println("最后编辑时间:"+t);
        //手动计算显示时间
        long y = t/1000/60/60/24/365 + 1970;
        System.out.println(y);
        //利用java.util.Date 显示时间
        System.out.println(new Date(t));

    }
}
