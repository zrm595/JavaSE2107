package homework.day03;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * 程序启动后，要求用户输入一个文件名，如果文件存在则提示
 * 并要求用户更换，直到该文件还不存在为止，然后将这个文件
 * 在当前目录中创建出来。
 * 
 * 单词记一记:
 * exsits 存在
 * create 创建
 * new    新的
 * 
 * @author Xiloer
 *
 */
public class Test01 {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		String filename;
		File file;
		boolean exists;
		do {
			System.out.print("输入要创建的文件名:");
			filename = scanner.nextLine();
			file = new File(filename);
			exists = file.exists();
			if (exists){
				System.out.println("文件已经存在!");
			}
		}while (exists);
		if(file.createNewFile()){
			System.out.println("成功创建文件");
		}else{
			System.out.println("创建失败");
		}
	}
}








