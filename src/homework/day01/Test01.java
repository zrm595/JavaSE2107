package homework.day01;
/**
 * 实现方法,完成获取下列文件名中的后缀名
 * @author Xiloer
 *
 * 单词记一记:
 * file   文件
 * name   名字           --->       fileName 文件名
 *
 * ext 这里是单词extension的前三个字母，这里指"后缀"的意思。
 * 注:开发中当一个单词作为标识符命名比较长时，可以用类似方式简写
 * 
 * get 获取，获得
 * 
 * getExtByName 表示获取后缀根据名字
 * 
 * logo 商标，徽标
 */
public class Test01 {
	public static void main(String[] args) {
		String fileName1 = "logo.png";//要png
		String fileName2 = "jquery.1.1.2.js";//要js
		
		String ext = getExtByName(fileName1);
		System.out.println(ext);//png
		ext = getExtByName(fileName2);
		System.out.println(ext);//js
	}
	/**
	 * 获取给定文件名中的后缀名部分
	 * @param name	文件名
	 * @return
	 * 
	 */
	public static String getExtByName(String name) {
		// 截取文件名: logo.png logo.jpeg logo.master.png
		//           jquery.1.1.2.js
		// 业务计算规则:截取点后面的所有个字符
		// substring(开始,结束) 按照范围截取, 按照长度截取
		// substring(开始) 从开始截取到末尾
		// indexOf() 找到字符/字符串的位置
		// lastIndexOf() 从后向前找到字符
		//找到 . 所在的位置 index
		int index = name.lastIndexOf('.');
		System.out.println("index:"+index);
		//从 . 的下一个位置开始截取子字符串
		String ext = name.substring(index+1);
		System.out.println("ext:"+ext);
		return ext;
	}
}





