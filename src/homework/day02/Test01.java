package homework.day02;

import java.util.Scanner;

/**
 * 正则表达式练习:
 * 1:编写匹配数字的正则表达式,数字至少一位以上.
 *   \d+
 * 2:匹配字符串,要求输入3-15位,内容只能是数字,字母下,划线
 *   \w{3,15}
 * 完成下面编程题:
 * 程序启动后,要求用户输入用户名,用户名出现内容要求上述正则表达式2的要求.不匹配则直接
 * 提示用户名有误.
 * 如果无误,则要求用户继续输入年龄,规则为上述正则表达式1的要求,不匹配则提示年龄有误
 * 以上两个输入获取是都要求以字符串形式接受(Scanner的nextLine方法获取)
 * 
 * 最后验证年龄在1-100岁之间(包含1和100) Integer.parseInt(str)
 * 提示:这里可以不用正则表达式验证范围,是否转换为数字判定更方便?
 * @author Xiloer
 *
 */
public class Test01 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("输入用户名:");
		String name = in.nextLine();
		if (name.matches("\\w{3,15}")){
			System.out.println("输入无误!");
			System.out.print("输入年龄:");
			String num = in.nextLine();
			if(num.matches("\\d+")){
				int age = Integer.parseInt(num);
				if (age>=1 && age<=100){
					System.out.println(name+":"+age);
				}else{
					System.out.println("年龄超出范围");
				}
			}else{
				System.out.println("年龄有误!");
			}
		}else{
			System.out.println("用户名有误!");
		}
	}
}





