package string;

public class Demo07 {
    public static void main(String[] args) {
        /*
         * 检查一个字符串后缀情况
         * - 检查文件是否是jpeg照片
         */
        String filename = "demo.jpg";
        //检查文件名是否是 .jpg 后缀的
        if(filename.endsWith(".jpg")){
            System.out.println("这是一个jpeg图片");
        }
    }
}
