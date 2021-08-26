package io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FOSDemo2 {
    public static void main(String[] args) throws IOException {
        /*
         * 追加方式打开文件
         * - 打开文件时候 append 设置为true, 则按追加方式打开文件
         *   如果append设置为false, 则覆盖方式, 文件指针在位置0
         * - 文件指针位置在 文件的末尾处, 如果写数据就会接在原有数据之后.
         *
         * fso -> 00110010 00110011 00110100 11111111 _ _ _ _ _
         *        0        1        2        3        4
         * 文件指针                                    ^
         *
         */
        FileOutputStream fos =
                new FileOutputStream("./fos.dat", true);
        fos.write(66);
        fos.write(67);
        fos.write(68);
        fos.close();

    }
}
