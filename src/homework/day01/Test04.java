package homework.day01;
/**
 * 改正下面代码的逻辑错误
 * 
 * 代码要实现的功能:根据文件名判断是否为png格式的图片
 * 代码思路:只要文件名是以".png"结尾的即可
 * 
 * 单词记一记：
 * check  检查
 * @author Xiloer
 *
 */
public class Test04 {
	public static void main(String[] args) {
		String fileName = "123.PNG";
		//startsWith是用来判断以指定的内容开始的
		//boolean check = fileName.startsWith(".png");
		boolean check = fileName.toLowerCase().endsWith(".png");

		if(check) {
			System.out.println("是png图片!");
		}else {
			System.out.println("不是png图片!");
		}
	}
}






