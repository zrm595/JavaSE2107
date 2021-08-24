package string;

public class MatchesDemo {
    public static void main(String[] args) {
        /*
         * 测试正则表达式
         * [去草艹] 匹配一个字符,这个字符是 "去草艹" 之一
         */
        String str = "我去"; //被检查的字符串
        //对字符串进行规则(正则表达式)检查
        boolean b = str.matches("我[去草艹]");//正则规则
        System.out.println(b);

        str = "我来"; //被检查的字符串
        b = str.matches("我[去草艹]"); //正则规则
        System.out.println(b);

        //测试两个字符的变量名规则: [a-zA-Z_$][a-zA-Z0-9_$]
        String name = "_1";
        b = name.matches("[a-zA-Z_$][a-zA-Z0-9_$]");
        System.out.println(b);
    }
}
