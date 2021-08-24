package homework.day01;

import java.util.Scanner;

/**
 * 要求用户在控制台输入自己的用户名。
 * 然后要求做如下验证工作:
 * 1:用户名不能为空(至少要有一个字符)
 * 2:用户名必须在20个字以内
 * @author Xiloer
 * 123
 */
public class Test02 {
    public static void main(String[] args) {
        //1 获取用户输入的用户名
        //2 检查用户名的长度 1~20
        //3 如果错误返回 1
        Scanner in = new Scanner(System.in);
        int length;
        String name;
        do{
            System.out.print("请输入用户名:");
            name = in.nextLine().trim(); //去除空白更加合理
            length = name.length();
            System.out.println("length:"+length);
        }while (length<1 || length>20);
        System.out.println("合理用户名:"+name);
    }
}
