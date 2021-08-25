# Java SE 3

Git URL: 

```
https://gitee.com/robin_home/JavaSE2107
```

## Object 类

Java 所有的类都继承于Object, Object上定义的方法被所有类继承.

### toString() 方法

输出一个对象

```
* - println(obj) 方法会自动调用obj的toString(),输出对象信息
* - Object定义了toString()方法, 所有子类都继承了toString()
* - Object提供的toString()默认返回值: 类全名(全限定名)@散列值
* - 经常重写toString()方法, 返回对象的描述
* - 开发工具提供了快速重写toString()的功能, 重写时候利用此功能即可
```

```java
package object;

public class ToStringDemo {
    public static void main(String[] args) {
        /*
         * toString()
         * - println(obj) 方法会自动调用obj的toString(),输出对象信息
         * - Object定义了toString()方法, 所有子类都继承了toString()
         * - Object提供的toString()默认返回值: 类全名(全限定名)@散列值
         * - 经常重写toString()方法, 返回对象的描述
         * - 开发工具提供了快速重写toString()的功能, 重写时候利用此功能即可
         */
        Ship ship = new Ship();//大船
        System.out.println(ship);
        Boat boat = new Boat();//小船
        System.out.println(boat);
        Bomb bomb = new Bomb(4,5,6,7);
        System.out.println(bomb);
    }
}
class Bomb{
    private double x;
    private double y;
    private double w;
    private double h;
    public Bomb(double x, double y, double w, double h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }
    @Override
    public String toString() {
        return "Bomb{" +
                "x=" + x +
                ", y=" + y +
                ", w=" + w +
                ", h=" + h +
                '}';
    }
}
class Ship{
}
class Boat{
    @Override //注解 Override 重写, 通知编译器检查后续方法是否符合重写语法
    public String toString() {
        return "小船";
    }
}
```

### equals() 方法

比较两个对象是否相等.

```java
package object;

import java.util.Objects;

public class EqualsDemo {
    public static void main(String[] args) {
        /*
         * 对象相等问题
         * - == 用于比较两个变量的值是否相等, 引用变量时候
         *      比较的是变量中存储的对象地址值是否一样
         * - 如果两个引用变量存储的地址是不同对象的地址 ==
         *      比较的结果为false
         * - 得到一个结论: == 不能用于比较对象是否相等!
         * - Object 上定义了equals方法, 用于比较对象是否相等
         *    - 其默认规则与 == 一致, 建议利用重写进行修改!
         *    - 可以利用开发工具重写equals方法,实现根据属性比较
         *      对象是否相等
         */
        Point p1 = new Point(4,5);
        Point p2 = new Point(4,5);
        //p1点和p2点在逻辑上应该是相等的点
        System.out.println(p1 == p2); //false
        System.out.println(p1.equals(p2));//true
    }
}
//Point 点
class Point{
    int x;
    int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x &&
                y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
```

## 包装类

- 将基本类型包装为对象. 
  - Java为了性能保留了 基本类型 
  - java 设计了包装类, 将基本类型包装了对象, 可以安装对象统一管理.
    - 在集合等使用包装类.  在后续课程中使用.
- 8个基本类, 8个包装类, 全部在 java.lang包
  - int 的 包装类 Integer
  - long 的包装类 Long
  - byte 的包装类 Byte
  - short 的包装类 Short
  - flaot 的包装类 Float
  - double 的包装类 Double
  - boolean 的包装类 Boolean
  - char 的包装类 Character 
- Java 5  开始提供了自动包装功能: 
  - 基本类型赋值该包装类型时候, 自动转换为对象

```java
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
```

输入整数:

```java
public class IntegerInputDemo {
    public static void main(String[] args) {
        /*
         * 输入数据时候, 可以利用parseInt方法将10进制整数
         * 字符串转换为 int 数据:
         */
        Scanner in = new Scanner(System.in);
        System.out.print("输入年龄:");
        String str = in.nextLine();
        int age = Integer.parseInt(str);
        System.out.println(age);
    }
}
```







