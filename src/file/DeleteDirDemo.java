package file;

import java.io.File;

public class DeleteDirDemo {
    public static void main(String[] args) {
        /*
         * 删除文件夹
         * - delete方法只能删除空文件夹
         */
        File dir = new File("./照片");
        if (dir.exists()){
            boolean del = dir.delete();
            if(del){
                System.out.println("删除成功!");
            }else{
                System.out.println("删除失败!");
            }
        }else{
            System.out.println("不存在!");
        }


    }
}
