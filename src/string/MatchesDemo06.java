package string;

public class MatchesDemo06 {
    public static void main(String[] args) {
        /*
         * 检查一个邮箱是否符合规则
         * 邮箱规则:  \w+@\w+(\.\w{2,})+
         *  \w+ 匹配名字部分,表示一个以上单词字符
         *  @ 匹配邮箱地址的人名和服务器名分隔符 @
         *  \w+ 匹配服务器名称
         *  \.\w{2,} 匹配服务器名称后缀, 包含一个点, 后续是2个以上的字符
         *  (\.\w{2,})+ 表示将服务器后缀看做一个组合, 这里至少有一组以上的后缀
         */
        String email = "liucangsong@tedu.com.cn";
        boolean match = email.matches("\\w+@\\w+(\\.\\w{2,})+");
        if (match){
            System.out.println("这个邮箱地址正确");
        }else {
            System.out.println("邮箱地址错误");
        }
    }
}
