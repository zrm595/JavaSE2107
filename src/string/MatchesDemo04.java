package string;


public class MatchesDemo04 {
    public static void main(String[] args) {
        /*
         * 缩写的数量词
         * 检查电话号码规则: 156 0010 1234 或者 15600101234
         *  \d{3}\s*\d{4}\s*\d{4}
         * mobile: 移动, 移动电话
         */
        String mobile = "156 0010  1234";
        boolean b = mobile.matches("\\d{3}\\s*\\d{4}\\s*\\d{4}");
        System.out.println(b);

    }
}
