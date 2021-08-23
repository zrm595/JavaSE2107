package string;

public class Demo03 {
    public static void main(String[] args) {
        /*
         * 字符串对象是不变的！
         */
        String s1 = "ABC";
        String s2 = s1;
        s1 += "DEF";
        System.out.println(s1);//ABCDEF
        System.out.println(s2);
    }
}
