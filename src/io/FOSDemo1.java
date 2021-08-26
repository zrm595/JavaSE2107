package io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FOSDemo1 {
    public static void main(String[] args) throws IOException {
        /*
         * 文件输出流
         */
        /*
         * 构造器
         * - 必须提供目标文件名, 或者文件对象
         * - 创建文件输出流时候, 如果文件没有就创建新文件
         *   如果文件已经存在, 就覆盖文件(替换原文件)
         * - 如果文件创建失败, 就抛出异常
         * - 刚刚打开的文件指针位置在 0
         */
        FileOutputStream fos = new FileOutputStream("./fos.dat");
        /*
         * write(int) 将数据写到文件中
         * 工作过程:
         * - 将参数int类型的低8位写入到文件中, 文件中保存一个字节信息
         * n = 50+256    00000000 00000000 00000001 00110010
         * write                                    00110010  一个字节
         * - 写入后文件指针自动向后移动, 为下次写字节做准备
         *
         * fso -> 00110010 00110011 00110100 _ _ _ _ _
         *        0        1        2        3        4
         * 文件指针                           ^
         *
         * - 如果文件出现故障, 将出现异常
         */
        int n = 50+256;
        fos.write(n);
        fos.write(51);
        fos.write(52);
        /*
         * 文件使用完毕, 务必关闭 close()
         */
        fos.close();
    }
}
