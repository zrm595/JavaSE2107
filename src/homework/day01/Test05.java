package homework.day01;

import java.util.Scanner;

/**
 * 改正下面代码的错误
 * <p>
 * 代码要实现的功能:要求用户输入一个网址，格式如:
 * www.baidu.com
 * 然后判断根据域名判断是百度(baidu)或者达内(tedu)或其他
 * 然后输出判断结果
 * <p>
 * 单词记一记:
 * start 开始
 * end 结束
 * <p>
 * 解决问题后，记录下来遇到的问题，以及解决办法
 *
 * host: 主机, 也就是服务器名
 * @author Xiloer
 */
public class Test05 {
    public static void main(String[] args) {
        System.out.println("请输入一个网址:");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        //检查line 中是否包含 ".baidu." 包含就认为是百度了
        if (line.indexOf(".baidu.")>=0){
            System.out.println("这个是百度");
        }else if (line.indexOf(".tedu.")>=0){
            System.out.println("这个是达内");
        }else {
            System.out.println("其他网站");
        }

        /*
        int index1 = line.indexOf('.');
        int index2 = line.lastIndexOf('.');
        String host = line.substring(index1+1, index2);
        if(host.equals("baidu")){
            System.out.println("这个是百度");
        }else if(host.equals("tedu")){
            System.out.println("这个是达内");
        }else {
            System.out.println("其他网站");
        }

         */
    }
}






