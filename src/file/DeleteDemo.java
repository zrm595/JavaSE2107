package file;

import java.io.File;

public class DeleteDemo {
    public static void main(String[] args) {
        /*
         * 删除一个文件
         * delete 删除
         * remove 删除
         */
        File file = new File("./test.txt");
        boolean deleted = file.delete();
        if (deleted){
            System.out.println("已经删除");
        }else {
            System.out.println("删除失败!");
        }
    }
}
