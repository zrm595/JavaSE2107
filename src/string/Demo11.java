package string;

public class Demo11 {
    public static void main(String[] args) {
        /*
         * Java 数据类型在输出之前会调用valueOf方法
         * 将数据转换为 String 类型再输出.
         * valueOf方法是目的是将底层2进制数据转换为
         * 人类熟悉的字符串\10进制, 然后再输出
         */
        int num = 55;
        double d = 3.1415926535897932;
        String s1 = String.valueOf(num);
        String s2 = String.valueOf(d);
        System.out.println(s1);
        System.out.println(s2);
        //println方法的底层会自动调用valueOf方法
        System.out.println(num);
        System.out.println(d);
        //字符串连接期间, 会自动调用valueOf转换数据为
        //字符串类型, 然后再进行字符串的连接
        System.out.println("PI="+d);
    }
}
