package string;

public class MatchesDemo2 {
    public static void main(String[] args) {
        /*
         * 测试一下 缩写字符集
         * 注意: Java字符串中写 \ 需要转义为 \\
         * \d\d\d\d\s\d\d\s\d\d 要写成 "\\d\\d\\d\\d\\s\\d\\d\\s\\d\\d"
         */
        String date = "2021 07 30";
        System.out.println("\\d"); // \\表示一个\
        boolean b = date.matches("\\d\\d\\d\\d\\s\\d\\d\\s\\d\\d");
        System.out.println(b);

    }
}
