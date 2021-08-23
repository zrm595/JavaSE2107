package string;

public class Demo09 {
    public static void main(String[] args) {
        /*
         * 去除字符串两端的空白
         * - 如果原字符串两端包含空白字符, 就返回
         *   不包含两端空白的新字符串.
         * - 这里的空白包括: 编码小于32的全部控制字符.其中:
         *   - 空格 编码 32
         *   - tab
         *   - 换行等
         * - 经常用于去除用户输入信息中意外输入的空白字符
         */
        String name = "  \t \r \n Tom And Jerry  ";
        String n = name.trim();
        System.out.println(n);//"Tom And Jerry"
        System.out.println(name);
    }
}
