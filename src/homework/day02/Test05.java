package homework.day02;

import java.util.Scanner;

/**
 * 改错题目:
 *
 * 程序需求:
 * 程序启动后，实例化一个Person，然后要求用户输入用户名
 * 和年龄.并加以验证:
 * 名字至少一个字符，否则输出:姓名不能为空!
 * 年龄必须是0-100之间的数字，否则输出:年龄不合法!
 * 
 * 都输入正确时最后输出该用户信息
 * 
 * 将下面写好的代码解除注释改正里面的错误使得程序可以正常
 * 运行。
 * 异常记一记:
 * 下面会出现的每一种异常先翻译异常的名字，然后解决该异常后
 * 思考是什么原因引起的错误并在注释中标注出来
 *
 * @author Xiloer
 *
 */
public class Test05 {
	public static void main(String[] args) {
		Person p = new Person();
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入姓名:");
		String name = scanner.nextLine();
		//空指针异常: 当一个引用类型变量的值为null, 在访问了这个
		// 变量属性方法或者数组元素时候, 发生空指针异常
		// 发生条件有两个: 变量为null, 访问属性/方法/成员
		// 解决办法: 将变量合理赋值, 在访问之前用if判断是否空,如果空不访问
		if(name.length()==0) {
			System.out.println("姓名不能为空!");
		}else{
			p.setName(name); //OK
		}
		System.out.println("请输入年龄:");
		int age = scanner.nextInt();
		if(age<0 || age>100) {
			System.out.println("年龄不合法!");
		}else{
			//p.age = age;
			p.setAge(age);
		}
		System.out.println("姓名:"+p.getName());
		System.out.println("年龄:"+p.getAge());
	}
	
}

class Person{
	private String name; //null
	private int age; //0
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}