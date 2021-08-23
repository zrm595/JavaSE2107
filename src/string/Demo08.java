package string;

public class Demo08 {
    public static void main(String[] args) {
        /*
         * 如何处理大小写混合问题
         * 将字符串统一转换为大写或者小写,在进行处理
         */
        String filename = "demo.Jpg";
        if(filename.toLowerCase().endsWith(".jpg")){
            System.out.println("这个是照片文件!");
        }
    }
}
