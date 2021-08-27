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







