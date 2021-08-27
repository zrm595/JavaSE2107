# day05

#### 对象流

java.io.ObjectOutputStream和ObjectInputSteam

对象流是一对高级流，在流连接中的作用是进行对象的序列化与反序列化。

对象序列化:将一个java对象按照其结构转换为一组字节的过程

对象反序列化:将一组字节还原为java对象(前提是这组字节是一个对象序列化得到的字节)

##### 对象序列化的流连接操作原理图:

![image-20210827115905270](image-20210827115905270.png)

```java
package io;

import java.io.*;

/**
 * 对象流java.io.ObjectOutputStream和ObjectInputStream
 * 对象流是一对高级流,功能是进行对象的序列化与反序列化.
 * 对象序列化:将一个对象按照其结构转换为一组字节的过程.
 */
public class OOSDemo {
    public static void main(String[] args) throws IOException {
        User user = new User("刘苍松","123456",60,"苍老师");

        FileOutputStream fos = new FileOutputStream("user.obj");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        /*
         *  User对象---oos--->字节(2进制)---fos--->写入文件中
         *           序列化               持久化
         *
         * 持久化:将数据写入磁盘做长久保存的过程
         *
         *
         * 对象流在进行对象序列化时要求写出的对象必须实现可序列化接口,否则会抛出异常:
         * java.io.NotSerializableException: io.User
         *                                 冒号后面是实际要序列化对象的包名+类名
         *                                 表示该类没有实现序列化接口
         */
        oos.writeObject(user);
        System.out.println("写出完毕!");
        oos.close();
    }
}
```

##### 对象反序列化

```java
package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * 对象输入流,进行对象的反序列化
 */
public class OISDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //读取user.obj文件,将User对象读取回来
        FileInputStream fis = new FileInputStream("user.obj");
        ObjectInputStream ois = new ObjectInputStream(fis);

        User user = (User)ois.readObject();
        System.out.println(user);
        ois.close();
    }
}
```

```java
package io;

import java.io.Serializable;

/**
 * 使用当前类测试对象流的对象序列化与反序列化操作
 *
 * 只有实现了java.io.Serializable的类才能进行对象序列化与反序列化
 */
public class User implements Serializable {
    private String username;
    private String password;
    private int age;
    //被transient修饰的属性在进行序列化时会被忽略.
    private transient String nickname;

    public User(String username, String password, int age, String nickname) {
        this.username = username;
        this.password = password;
        this.age = age;
        this.nickname = nickname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", nickname='" + nickname + '\'' +
                '}';
    }

}
```

### 字符流

- java将流按照读写单位划分为字节流与字符流.
- java.io.InputStream和OutputStream是所有字节流的超类
- 而java.io.Reader和Writer则是所有字符流的超类,它们和字节流的超类是平级关系.
- Reader和Writer是两个抽象类,里面规定了所有字符流都必须具备的读写字符的相关方法.
- 字符流最小读写单位为字符(char),但是底层实际还是读写字节,只是字符与字节的转换工作由字符流完成.

#### 转换流

java.io.InputStreamReader和OutputStreamWriter

它们是字符流非常常用的一对实现类同时也是一对高级流,实际开发中我们不直接操作它们,但是它们在流连接中是非常重要的一环.

