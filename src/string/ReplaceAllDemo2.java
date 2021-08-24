package string;

import java.util.Scanner;

public class ReplaceAllDemo2 {
    public static void main(String[] args) {
        /*
         * 替换用户输入信息中的敏感词
         */
        Scanner in = new Scanner(System.in);
        System.out.print("输入信息:");
        String str = in.nextLine();
        String s = str.replaceAll("我[去草艹]","XXX");
        //显示替换以后的结果
        System.out.println(s);
    }
}
