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

### File API

file: 文件 

File类的每一个实例可以表示硬盘(文件系统)中的一个文件或目录(实际上表示的是一个抽象路径)

使用File可以做到:

- 1:访问其表示的文件或目录的属性信息,例如:名字,大小,修改时间等等
- 2:创建和删除文件或目录
- 3:访问一个目录中的子项

但是File不能访问文件数据.

```java
package file;

import java.io.File;
import java.util.Date;

public class FileDemo {
    public static void main(String[] args) {
        /*
         * File API
         * - File 代表一个文件夹或者文件夹
         * - 使用时候需要先创建File对象, 创建时候需要给定代表文件\文件夹名
         */
        /*
         * 文件名两种表示方式:绝对路径, 相对路径
         * 绝对路径: C:\Users\TEDU\IdeaProjects\JavaSE2107\demo.txt
         *   绝对路径使用非常不方便, 开发时候经常使用相对路径
         * 相对路径: 相对路径的起始位置是java程序命令的启动位置.
         *   在IDEA Java程序启动位置就是 项目文件夹 JavaSE2107
         *   当写成 ./demo.txt 时候,就表示在 JavaSE2107中的demo.txt
         *   相对路径, 可以兼容各种操作系统
         */
        File file = new File("./demo.txt");
        System.out.println(file);
        /*
         * File 能够访问文件的属性信息: 文件长度\文件创建时间\文件是否可读
         */
        long length = file.length(); //返回文件中字节的个数
        System.out.println(length); //如果返回是0表示没有找到文件或者长度真的0
        /*
         * 检查文件是否可读 可写
         * can: 能否
         * Read: 读
         * Write: 写
         */
        boolean r = file.canRead();
        boolean w = file.canWrite();
        System.out.println("可读:"+r);
        System.out.println("可写:"+w);

        /*
         * 读取文件的最后编辑时间
         * last: 最后
         * Modify: 编辑
         * 返回值: java 底层的系统时间, 从1970年元旦到现在累计的毫秒数
         */
        long t = file.lastModified();
        System.out.println("最后编辑时间:"+t);
        //手动计算显示时间
        long y = t/1000/60/60/24/365 + 1970;
        System.out.println(y);
        //利用java.util.Date 显示时间
        System.out.println(new Date(t));

    }
}
```



```java
package file;

import java.io.File;
import java.io.IOException;

public class CreateNewFile {
    public static void main(String[] args) throws Exception {
        /*
         * file API 提供了创建文件的方法
         *   file.createNewFile()
         * - 磁盘上没有文件时候才能创建一个新文件
         *   并且返回true表示文件创建成功
         * - 如果磁盘上已经有文件了, 就不创建文件
         *   返回false表示创建失败
         * - 如果创建时候文件系统不能写,会出现异常
         */
        File file = new File("./test.txt");
//        boolean created = file.createNewFile();
//        if (created){
//            System.out.println("创建成功!");
//        }else {
//            System.out.println("创建失败!");
//        }

        if (! file.exists()){
            file.createNewFile();
            System.out.println("创建了文件");
        }else {
            System.out.println("文件已经存在");
        }

    }
}
```



```java
package file;

import java.io.File;

public class DeleteDemo {
    public static void main(String[] args) {
        /*
         * 删除一个文件
         * delete 删除
         * remove 删除
         */
        File file = new File("./test.txt");
//        boolean deleted = file.delete();
//        if (deleted){
//            System.out.println("已经删除");
//        }else {
//            System.out.println("删除失败!");
//        }
        /*
         * exists 存在
         */
        //boolean e = file.exists();
        //System.out.println("文件存在:"+e);
        if(file.exists()){
            file.delete();
            System.out.println("删除文件");
        }else {
            System.out.println("文件不存在!");
        }
    }
}
```



```java
package file;

import java.io.File;

public class MkDirDemo {
    public static void main(String[] args) {
        /*
         * File 可以代表文件夹
         * - File 提供了创建文件夹方法 mkdir
         *   mk: make  dir:目录
         * - mkdirs 创建系列文件夹方法
         *   照片/老虎/第一位/2020年
         */
        File dir = new File("./照片/老虎/第一位/2020年");
        if (! dir.exists()){
            //dir.mkdir(); //创建文件夹
            dir.mkdirs();
            System.out.println("创建了文件夹!");
        }else{
            System.out.println("已经存在!");
        }
    }
}
```



```java
package file;

import java.io.File;

public class DeleteDirDemo {
    public static void main(String[] args) {
        /*
         * 删除文件夹
         * - delete方法只能删除空文件夹
         */
        File dir = new File("./照片");
        if (dir.exists()){
            boolean del = dir.delete();
            if(del){
                System.out.println("删除成功!");
            }else{
                System.out.println("删除失败!");
            }
        }else{
            System.out.println("不存在!");
        }


    }
}
```



```java
package file;

import java.io.File;

public class ListFileDemo {
    public static void main(String[] args) {
        /*
         * Java File API 提供了获取文件夹中文件列表的功能
         * - dir.listFiles() 获取dir中全部的文件和文件夹
         * - dir 必须是一个文件夹! 否则返回 null
         * - 如果是一个文件夹, 就会把文件夹内容放到数组中返回
         */
        File file = new File("./demo.txt");
        //在文件上调用 listFiles() 会返回 null(没有)
        File[] files = file.listFiles();
        System.out.println(files);

        File dir = new File("./笔记");
        //在文件夹上调用 listFiles()会返回文件夹中全部的文件和文件夹
        files = dir.listFiles();
        /*
         * Java 5 提供了增强for循环(for each循环), 用于替换传统for循环
         * 原因是 代码短!!! for(File f: files)
         */
        for(File f: files){
        //for (int i=0; i<files.length; i++){
        //    File f = files[i];
            System.out.println(f);
        }
        /*
         * File 提供了API 方法用于检查是文件还是文件夹
         * - isFile() 如果当前对象是一个文件则返回true否则返回false
         * - isDirectory() 如果当前对象是一个文件夹返回true, 否则false
         */
        System.out.println(file.isDirectory()); //false
        System.out.println(file.isFile());      //true
        System.out.println(dir.isDirectory());  //true
        System.out.println(dir.isFile());       //false

        /*
         * 改进版本: 如果当前对象是一个目录(文件夹),再执行列出
         * 文件夹内容的功能.
         *  ./ 表示当前文件夹, 这里就是当前项目文件夹
         */
        dir = new File("./");
        System.out.println("列出当前目录内容:");
        if(dir.isDirectory()){
            File[] files1 = dir.listFiles();
            for (File f: files1){
                System.out.println(f);
            }
        }

    }
}
```



```java
package file;

import java.io.File;
import java.io.FileFilter;

public class FileFilterDemo {
    public static void main(String[] args) {
        /*
         * 有条件的列出目录的内容
         *   listFiles(过滤条件)
         * - 有条件的列出目录 的内容, 满足条件的文件作为返回数组的成员
         * - 不满足条件的文件被过滤掉
         * - 过滤条件是一个接口, 包含一个过滤方法
         *    listFiles 会自动调用过滤方法,筛选文件
         * 过滤条件: FileFilter
         * Filter: 过滤器
         */
        //过滤条件: 筛选 .txt 的文件
//        FileFilter filter = new FileFilter() {
//            @Override //过滤器的筛选方法
//            public boolean accept(File pathname) {
//                //写筛选逻辑: pathname 代表每个被赛选的文件
//                //先找到文件名, 检查文件名的末尾是否以.txt为结束
//                //方法返回true表示文件是被选定的文件,
//                //返回false就是被忽略的文件
//                String name = pathname.getName();
//                return name.endsWith(".txt");
//            }
//        };
        File dir = new File("./");
        if (dir.isDirectory()){
            //listFiles 在执行期间会自动调用 filter中的方法
            //File[] files = dir.listFiles(filter);
            //将匿名内部类直接写到listFiles方法的参数上,使代码更加紧凑
            File[] files = dir.listFiles(new FileFilter() {
                @Override
                public boolean accept(File pathname) {
                    return pathname.getName().endsWith(".txt");
                }
            });
            for(File file: files){
                System.out.println(file);
            }
        }

    }
}
```

```java
package file;

import java.io.File;
import java.io.FileFilter;

public class LambdaDemo {
    public static void main(String[] args) {
        /*
         * lambda 表达式
         * Java 8 提供一个语法
         * - 用于简化匿名内部类的定义
         * - 可以看做不用关心类名和方法名的匿名类
         * - 如果参数只有一个, 可以省略 () 和 变量类型
         *   如果方法体只有一行 可以省略 {;} 和 return
         * - 要求: 接口只能有一个方法时候才能使用lambda语法
         */
        FileFilter filter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".txt");
            }
        };
        //简化版本1: 省略的类名和方法名
        FileFilter filter1 =
                (File pathname)->{return pathname.getName().endsWith(".txt");};
        //简化版本2: 省略了()参数类型, 省略了{} 和 return
        FileFilter filter2 = pathname->pathname.getName().endsWith(".txt");

        File dir = new File("./");
        if (dir.isDirectory()){
            File[] files = dir.listFiles(
                    pathname->pathname.getName().endsWith(".txt"));
            for(File file: files){
                System.out.println(file);
            }
        }

    }
}
```