package string;

public class MatchesDemo05 {
    public static void main(String[] args) {
        /*
         * 测试特殊字符匹配规则
         * 特殊字符使用转义字符进行匹配:  . 使用 \. 匹配
         * 如匹配一个 .jpg 文件名的规则:  .+\.jpg
         *  这里 .+ 表示匹配一个以上任意字符
         *      \.jpg 表示匹配 .jpg 后缀
         */
        String file = "demo.jpg";
        boolean match = file.matches(".+\\.jpg");
        if (match){
            System.out.println("这个是 jpg 文件");
        }else {
            System.out.println("不是JPG文件");
        }
    }
}
