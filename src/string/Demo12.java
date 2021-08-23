package string;

public class Demo12 {
    public static void main(String[] args) {
        String str = "Thinking in Java 是本好书";

        String s1 = str.substring(9,11); //in, 包含开始,不包含结束
        String s2 = str.substring(9,9+2);//in, 从9开始,连续截取两个字符
        String s3 = str.substring(4,4+4);
        String s4 = str.substring(4,8);
        String s5 = str.substring(12);//"Java 是本好书"

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
        System.out.println(s5);

    }
}
