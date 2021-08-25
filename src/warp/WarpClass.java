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

    }
}
