package warp;

public class WarpClass {
    public static void main(String[] args) {
        /*
         * 包装类型
         * 基本类型可以包装为包装类型
         * 包装类型可以换行为基本类型
         */
        int n = 5; //基本类型
        //Java 自动的将int类型的8 包装为 Integer类型的对象
        Integer x = 8; //int包装类型
        //上述代码相当于
        Integer y = Integer.valueOf(8);
        System.out.println(y);

        Double d = 3.5; //double 包装类型
        //上述代码相当于
        Double dx = Double.valueOf(3.5);
        System.out.println(dx);

        //自动拆包: 自动的将包装类转换为 基本类型
        int a = x;
        a = x.intValue(); //与上述代码一样
        double b = d;
        b = d.doubleValue(); //与上述代码一样

        /*
         * 包装类型: 是对象, 可以使用面对对象的特性 封装\继承\多态
         *          但是性能慢
         * 基本类型: 不能对象, 不能 封装\继承\多态, 性能好
         */
        long t1 = System.currentTimeMillis();
        int sum = 0;
        for(int i=0; i<500000; i++){
            sum += i;
        }
        long t2 = System.currentTimeMillis();
        Integer sumI = 0;
        for (int i=0; i<500000; i++){
            sumI += i;
        }
        long t3 = System.currentTimeMillis();
        System.out.println(t2-t1);
        System.out.println(t3-t2);

        /*
         * 包装类型, 为了优化性能利用常量池复用了 -128~127之间的
         *     整数包装类型对象.
         *    -128~127 之间的Integer类型对象被替换同一个对象
         */
        Integer i1 = -20;
        Integer i2 = -20;
        System.out.println(i1 == i2); //true
        i1 = 128;
        i2 = 128;
        System.out.println(i1 == i2); //false

        /*
         * 包装类型提供常用API
         * - 提供了数据类型的最大最小值常量
         * - 提供了将10进制字符串转换为 对应数据类型的方法
         */
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        long lmax = Long.MAX_VALUE;
        long lmin = Long.MIN_VALUE;
        System.out.println(max);
        System.out.println(min);
        System.out.println(lmax);
        System.out.println(lmin);

        /*
         * 包装类提供 将 10进制字符串 转换为Java数据类型的方法
         * 如果参数不能10进制字符串,将出现"格式化异常"
         */
        String str = "1234.9"; //10进制整数字符串
        //String str = "1234.9"; 不是10进制整数,不能转换
        int num = Integer.parseInt(str);
        str = "123.56"; //10进制小数字符串
        double dnum = Double.parseDouble(str);
        System.out.println(num);
        System.out.println(dnum);
    }
}
