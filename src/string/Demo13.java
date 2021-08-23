package string;

public class Demo13 {
    public static void main(String[] args) {
        StringBuilder buf = new StringBuilder();
        buf.append("范老师")//追加
                .append("早晨起来")
                .append("干了惊天动地大事情")
                .append("!")
                .insert(1,"传奇") //插入
                .delete(3, 3+2); //删除
        System.out.println(buf);
    }
}
