package homework.day03;

import java.io.File;
import java.io.FileFilter;

/**
 * 列出当前目录中所有名字包含s的子项。
 * 
 * 使用匿名内部类和lambda两种写法
 * 
 * 单词记一记:
 * FileFilter   文件过滤器
 * accept       接受
 * 
 * @author Xiloer
 *
 */
public class Test02 {
	public static void main(String[] args) {
		File dir = new File("./");
		if(dir.isDirectory()){
			File[] files = dir.listFiles(new FileFilter() {
				@Override
				public boolean accept(File pathname) {
					//return pathname.getName().indexOf('s')>=0;
					//contains 包含, 检查字符串中是否包含"s"
					return pathname.getName().contains("s");
				}
			});
			for(File file: files){
				System.out.println(file.getName());
			}
		}

		//Lambda
		// (File pathname)->{return pathname.getName().contains("s");}
		// 只有一个参数时候, 省略参数括号和参数类型
		// pathname->{return pathname.getName().contains("s");}
		// 方法体只有一行时候, 省略{} 和 return
		// pathname->pathname.getName().contains("s")
		// 简化变量名
		// f->f.getName().contains("s")

		if(dir.isDirectory()){
			File[] files = dir.listFiles(f->f.getName().contains("s"));
			for(File file: files){
				System.out.println(file.getName());
			}
		}
	}
}
