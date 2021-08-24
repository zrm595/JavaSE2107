package string;

public class MatchesDemo03 {
    public static void main(String[] args) {
        /*
         * 正则数量词
         * \w{8,20} 匹配 8到20个单词字符
         */
        String name = "Andy_Wang";
        boolean b = name.matches("\\w{8,20}");
        System.out.println(b);
    }
}
