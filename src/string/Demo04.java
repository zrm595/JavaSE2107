package string;

public class Demo04 {
    public static final String S = "ABC";
    public static void main(String[] args) {
        /*
         * 字符串常量池复用 静态字符串
         */
        //java 在第一次创建 静态字符串“ABC”时候，会将其
        //引用存储到字符串常量池中一份
        String s1 = "ABC";
        //第二次遇到 “ABC” 时候就不再创建新对象，而是从
        //常量池中获取原有 “ABC”的引用，赋值给s2
        //也就是说 s1 和 s2 (复用)引用了同一个对象
        String s2 = "ABC";
        //利用s1==s2 检查s1和s2是否引用同一个对象
        System.out.println(s1==s2);//true
        //使用new运算创建的字符串，是动态字符串，不会
        //放到常量池， 不会被复用
        String s3 = new String("ABC");
        System.out.println(s1==s3);

        System.out.println(S==s1);

        String s4 = "AB"+"C"; //编译以后 "ABC"

        String s6 = "AB";
        String s7 = "C";
        String s8 = s6+s7; //编译后 s6+s7 运行期计算
        //运行期间  s6+s7 连接以后会创建新String对象
        //这个对象不会缓存到字符串常量池。
        System.out.println(s1 == s4);//true
        System.out.println(s1 == s8);//false

    }
}
