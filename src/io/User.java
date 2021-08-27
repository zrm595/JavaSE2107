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







