package string;

public class Demo01 {
    public static void main(String[] args) {
        /*
         * 创建字符串对象
         */
        String s = "ABC";
        char[] chs = {'A','B','C'};
        String s1 = new String(chs);
        /*
         * s 和 s1 基本一样，可以看做“ABC”是
         * new String(chs) 的简化版
         */
        System.out.println(s);
        System.out.println(s1);
    }
}
