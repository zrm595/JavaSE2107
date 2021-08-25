package object;

import java.util.Objects;

public class EqualsDemo {
    public static void main(String[] args) {
        /*
         * 对象相等问题
         * - == 用于比较两个变量的值是否相等, 引用变量时候
         *      比较的是变量中存储的对象地址值是否一样
         * - 如果两个引用变量存储的地址是不同对象的地址 ==
         *      比较的结果为false
         * - 得到一个结论: == 不能用于比较对象是否相等!
         * - Object 上定义了equals方法, 用于比较对象是否相等
         *    - 其默认规则与 == 一致, 建议利用重写进行修改!
         *    - 可以利用开发工具重写equals方法,实现根据属性比较
         *      对象是否相等
         */
        Point p1 = new Point(4,5);
        Point p2 = new Point(4,5);
        //p1点和p2点在逻辑上应该是相等的点
        System.out.println(p1 == p2); //false
        System.out.println(p1.equals(p2));//true
    }
}
//Point 点
class Point{
    int x;
    int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x &&
                y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
