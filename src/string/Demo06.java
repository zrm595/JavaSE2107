package string;

public class Demo06 {
    public static void main(String[] args) {
        /*
         * 将字符串转换为大写(UpperCase)
         * - 如果转换以后字符串有改变,就返回一个新字符串
         *   原字符串对象不变
         * 小写(LowerCase)
         */
        String str = "Thinking in Java 是本好书!";
        String s = str.toUpperCase();
        System.out.println(s);
        System.out.println(str);

    }
}
