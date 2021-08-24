package string;

public class StringBuilderDemo1 {
    public static void main(String[] args) {
        /*
         * StringBuilder 演示
         * - new StringBuilder("天气不错") 创建对象,将参数添加到char数组中
         */
        StringBuilder builder = new StringBuilder("天气不错");
        builder.append("!")                  //追加内容
                .insert(0,"今天")    //插入内容
                .setCharAt(0, '昨'); //替换指定位置的字符
        builder.reverse(); //将字符序列进行翻转
        //toString() 方法可以将StringBuilder转化为String
        //转换为String类型的目的,一般都是为了调用String的API方法
        String str = builder.toString();
        System.out.println(str);

    }
}
