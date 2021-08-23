package string;

public class Demo02 {
    public static void main(String[] args) {
        /*
         * 字符串API方法：
         *  字符串中每个字符都有下标序号，下标序号从0开始
         *  charAt(index) 返回字符串中指定位置的字符
         *  length() 返回字符串中字符的个数
         */
        String s = "ABC";
        //          012
        char c = s.charAt(1); //'B'
        int l = s.length(); //3
        System.out.println(c);
        System.out.println(l);
        /*
         * charAt和length 配合可以实现字符串中字符的遍历
         * 例子：统计一个字符串中全部英文大写字符个数
         * length: 长度
         * char 字符  At 在
         */
        String str = "Thinking In Java 是一本好书";
        int sum = 0;
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(ch>='A' && ch<='Z') {
                sum++;
            }
        }
        System.out.println(sum);
    }
}
