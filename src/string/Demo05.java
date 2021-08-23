package string;

public class Demo05 {
    public static void main(String[] args) {
        /*
         * 经典面试题目：
         *  new String("ABC") 创建了几个字符串对象
         * 如果面试时候问:
         *  new String("ABC") 创建了几个对象
         */
        //1. Java首先创建创建静态字符串 "ABC"
        //   这个静态字符串的引用被缓存到了字符串常量池
        //2. 然后利用静态字符串作为参数创建一个
        //   动态字符串 new String(...)
        String s = new String("ABC");

    }
}
