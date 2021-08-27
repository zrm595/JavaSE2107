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




