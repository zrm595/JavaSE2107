package string;

public class SplitDemo {
    /*
     * 将字符串按照正则匹配的位置劈开
     * split 劈开
     * - 将匹配到的符号劈掉
     * - 将劈开的数据保存到数组
     * - 如果有连续的分割符号, 会劈出来空串""
     * - 如果连续的分割符号在最后出现, 将被忽略舍弃
     */
    public static void main(String[] args) {
        String str = "1,老王,15610101234,tom@tedu.cn";
        String[] data = str.split(",");
        System.out.println(data[1]);
        System.out.println(data[2]);
        System.out.println(data[3]);

        str = "2,老李,,tom@tedu.cn";
        data = str.split(",");
        System.out.println(data[1]);
        System.out.println(data[2]); //空字符串 "", 表示这个位置没有数据
        System.out.println(data[3]);

        str = "2,老赵,,tom@tedu.cn,,,,,,,,,,,,,,,,";
        data = str.split(",");
        System.out.println(data[1]);
        System.out.println(data[2]); //空字符串 "", 表示这个位置没有数据
        System.out.println(data[3]);
        System.out.println(data.length);

    }
}
