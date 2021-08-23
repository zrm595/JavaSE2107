package string;

public class Demo10 {
    public static void main(String[] args) {
        /*
         * 比较两个字符串内容是否一致
         * equals 严格比较两个字符串, 大小写不一致
         * 也会返回false
         */
        String s1 = "ABC";
        String s2 = "ABC";
        String s3 = new String("ABC");
        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(s3));
        String s4 = "Abc";
        System.out.println(s1.equals(s4));
        /*
         * 比较验证码问题? 需要忽略大小写比较相等
         * - 利用大小写转换配合equals方法可以实现忽略大小写比较相等
         * - String 还提供了忽略大小写比较的专用方法
         * equals: 相等
         * Ignore: 忽略
         * Case: 大小写
         */
        System.out.println(s1.equals(s4.toUpperCase()));
        System.out.println(s1.equalsIgnoreCase(s4));
        //StringBuilder
    }
}
