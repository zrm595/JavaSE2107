package warp;

import java.util.Scanner;

public class IntegerInputDemo {
    public static void main(String[] args) {
        /*
         * 输入数据时候, 可以利用parseInt方法将10进制整数
         * 字符串转换为 int 数据:
         */
        Scanner in = new Scanner(System.in);
        System.out.print("输入年龄:");
        String str = in.nextLine();
        int age = Integer.parseInt(str);
        System.out.println(age);
    }
}
