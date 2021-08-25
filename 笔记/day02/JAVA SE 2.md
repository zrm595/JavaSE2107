# JAVA SE 2

## StringBuilder API

### 构造器

- 默认初始化字符数组长度为16的缓冲区
- 指定一个整数参数, 表示初始化为指定长度的字符数组缓存区, 用在预先知道最终字符串长度的情况下优化性能, 设置了字符数组容量可以避免扩容.
- 指定一字符串参数, 用于直接将字符串添加到字符数组中

### 方法

- 追加方法 append, 有重载,可以将任何类型添加到字符缓存区中
- 插入方法 insert, 有重载,可以将任何类型插入到字符缓存区中
- 删除方法, 可以将缓存区中指定范围内的字符删除

### String 和 StringBuilder

- String 是不可改变的对象: 创建以后,其内部封装的字符数组内容不可改变
  - 可以方便复用
  - 系统的输出采用的是String
  - 大量动态字符串连接, 性能不好
- StringBuilder是可以改变的对象, 创建以后, API可以修改其内部char数组内容
  - 时候动态编辑字符串内容, 编辑性能好

案例: StringBuilder连接性能更好:

```java
package string;

public class StringBuilderDemo02 {
    public static void main(String[] args) {
        int n = 50000;
        //System.currentTimeMillis() 获取当前系统时间毫秒数
        long t1 = System.currentTimeMillis();
        String s = "";
        for(int i=0; i<n; i++){
            s = s+"A";
        }
        long t2 = System.currentTimeMillis();
        StringBuilder buf = new StringBuilder();
        for (int i=0; i<n; i++){
            buf.append("A");
        }
        long t3 = System.currentTimeMillis();
        System.out.println(t2-t1);
        System.out.println(t3-t2);

    }
}
```

# 正则表达式

## 什么是正则

正则表达式是用来描述一个字符串的内容格式,使用它通常用来匹配一个字符串的内容是否符合

## 正则语法

基本语法: 字符集

[字符] 表示用于限定一个字符, 其字符是[]范围内的一个字符

例子:

```
[abc] 匹配一个字符, 字符是a或者b或者c之一
      例子: 我[去草] 第一个字符是 我, 第二个开始是 去或者草
```



### Java 提供了正则API

matches: 匹配

用于检查一个字符串是否符合正则规则

str.matches(正则表达式)

将字符串 str 与 正则表达式匹配, 如果匹配成功则返回 true 表示匹配! 否则false.

```java
String str = "我去"; //被检查的字符串
boolean b = str.matches("我[去草]"); //"我[去草]" 字符串规则
//b 是true
str = "我来"; //被检查的字符串
b = str.matches("我[去草]");
//b 是false
```

案例:

```java
public class MatchesDemo {
    public static void main(String[] args) {
        /*
         * 测试正则表达式
         * [去草艹] 匹配一个字符,这个字符是 "去草艹" 之一
         */
        String str = "我去"; //被检查的字符串
        //对字符串进行规则(正则表达式)检查
        boolean b = str.matches("我[去草艹]");//正则规则
        System.out.println(b);

        str = "我来"; //被检查的字符串
        b = str.matches("我[去草艹]"); //正则规则
        System.out.println(b);

        //测试两个字符的变量名规则: [a-zA-Z_$][a-zA-Z0-9_$]
        String name = "_1";
        b = name.matches("[a-zA-Z_$][a-zA-Z0-9_$]");
        System.out.println(b);
    }
}
```

匹配字符:

[abc]

[abcdef] 可以简化为 [a-f] 匹配一个字符, 这个字符是小写 a到f中的某一个

[a-z] 匹配一个字符, 这个字符是小写 a到z中的某一个

[A-Z]匹配一个字符, 这个字符是大写 A到Z中的某一个

[0-9] 匹配一个字符, 这个字符是小写0到9中的某一个

[a-zA-Z0-9] 匹配一个字符, 这个字符是大小写 a到z 和数字0-9中的某一个

[^abc] ^除了, 排除abc的其他任意一个字符

例子: 两个字符的变量名称: `[a-zA-Z_$][a-zA-Z0-9_$]` 



预定义字符集

 \d 是 [0-9]  匹配一个0-9的数字

\w [a-zA-Z0-9_]  单词字符, 匹配一个英文大小写或者 _

\s  匹配一个空白字符(空格 tab 回车等)

\D  表示非数字, 除了数字以外任意一个字符

\W 表示非单词字符, 除了英文大小写数字和下划线以外的任意一个字符

\S 表示非空白

. 表示任意一个字符 

匹配一个 日期格式:  yyyy MM dd  正则: \d\d\d\d\s\d\d\s\d\d

例子: 两个字符的变量名称: `[a-zA-Z_$][\w$]` 

```java
public class MatchesDemo2 {
    public static void main(String[] args) {
        /*
         * 测试一下 缩写字符集
         * 注意: Java字符串中写 \ 需要转义为 \\
         * \d\d\d\d\s\d\d\s\d\d 要写成 "\\d\\d\\d\\d\\s\\d\\d\\s\\d\\d"
         */
        String date = "2021 07 30";
        System.out.println("\\d"); // \\表示一个\
        boolean b = date.matches("\\d\\d\\d\\d\\s\\d\\d\\s\\d\\d");
        System.out.println(b);

    }
}
```



数量词

约定左侧字符出现的次数

X{n} 表示X连续出现n次, 例子 \d{4} 表示连续出现4个数字

X{n,m} 表示X连续出现最少n次, 最多m次, 例子: \d{3,8} 最少3个数字, 最多8个数字

X{n,}  表示X连续出现最少n次, 多了不限

例子: 某个网站登录用户名规则:  8到20个字符, 英文大小写数字下划线组成

正则:   \w{8, 20}

```java
public class MatchesDemo03 {
    public static void main(String[] args) {
        /*
         * 正则数量词
         * \w{8,20} 匹配 8到20个单词字符
         */
        String name = "Andy_Wang";
        boolean b = name.matches("\\w{8,20}");
        System.out.println(b);
    }
}
```

匹配一个 日期格式:  yyyy MM dd  正则: \d{4}\s\d{2}\s\d{2}

缩写数量词:

?  等价与 {0,1}  可以没有, 最多1个

例子: \d? 数字可以有或者没有

`*` 等价 {0,} 可以没有, 或者更多个

例子:  \s* 可以没有或者很多空白

`+` 等价 {1,} 至少有一个, 或者更多

例子: \s+ 至少出现一个空白

电话号:  156 0010 1234 或者 15600101234

利用正则表示:  \d{3}\s?\d{4}\s?\d{4}

```java
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

```



分组 ()

将一个部分规则作为一个整体看待

例子, 正则 (233)+ 可以匹配:  233233233233233233

比如 手机号: 可以是 008615600101234 或者 15600101234, 也就是 0086 作为一个整体, 可以有可以没有

正则规则:  (0086)?\d{11}



特殊字符的匹配:

`.  \ [ ] (  ) { }  ? + *  `

转义为: ` \.  \\ \[ \] \( \) ...`

匹配一个jpg图片文件名:   logo.jpg  demo.jpg  美女.jpg

匹配规则: `.+\.jpg`

```JAVA
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
```

案例: 一个邮箱地址正则规则

liucangsong@tarena(.com)(.cn) 

fancq@tarena(.com)(.cn)

liucs@tedu(.cn)

编写正则:  `\w+@\w+(\.\w{2,})+`

```JAVA
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

```



## 正则表达式API

matches 方法, 检查一个字符串整体是否符合正则规则. 



### split 劈开 

用于将字符串进行拆分和解析

str.split(正则)

将字符串 str 按照正则表达式匹配的位置进行拆分, 将匹配到符号劈掉, 剩下的保存到数组中;

举个栗子:

```java
//           编号 姓名  电话         邮箱
String str = "1, 老王, 15601011234, tom@tedu.cn";
//  data  =  "1" "老王" "15601011234" "15601011234"
//将如上字符串进行拆分, 提取用户名, 电话, 邮箱等信息
String[] data = str.split(",");
System.out.println(data[1]); //老王
System.out.println(data[2]); //15601011234
//...
```

案例:

```java
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

```



### 替换 replaceAll

replace: 替换  all 全部

规则:

str.replaceAll(正则, 替换内容) 将字符串 str 中全部被 正则 匹配的内容, 替换为 "替换内容"

如:  

```java
String str = "aaa6bbb7ggg8def";
String s = str.replaceAll("\\d", ",");
//替换结果: s = "aaa,bbb,ggg,def"
```



案例: 敏感词替换:

```java
package string;

import java.util.Scanner;

public class ReplaceAllDemo2 {
    public static void main(String[] args) {
        /*
         * 替换用户输入信息中的敏感词
         */
        Scanner in = new Scanner(System.in);
        System.out.print("输入信息:");
        String str = in.nextLine();
        String s = str.replaceAll("我[去草艹]","XXX");
        //显示替换以后的结果
        System.out.println(s);
    }
}

```



 





























