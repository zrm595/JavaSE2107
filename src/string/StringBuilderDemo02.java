package string;

public class StringBuilderDemo02 {
    public static void main(String[] args) {
        int n = 50000;
        //System.currentTimeMillis() 获取当前系统时间毫秒数
        long t1 = System.currentTimeMillis();
        String s = "";
        for(int i=0; i<n; i++){
            s = s+"A";
        }
        long t2 = System.currentTimeMillis();
        StringBuilder buf = new StringBuilder();
        for (int i=0; i<n; i++){
            buf.append("A");
        }
        long t3 = System.currentTimeMillis();
        System.out.println(t2-t1);
        System.out.println(t3-t2);

    }
}
