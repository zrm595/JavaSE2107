package object;

public class ToStringDemo {
    public static void main(String[] args) {
        /*
         * toString()
         * - println(obj) 方法会自动调用obj的toString(),输出对象信息
         * - Object定义了toString()方法, 所有子类都继承了toString()
         * - Object提供的toString()默认返回值: 类全名(全限定名)@散列值
         * - 经常重写toString()方法, 返回对象的描述
         * - 开发工具提供了快速重写toString()的功能, 重写时候利用此功能即可
         */
        Ship ship = new Ship();//大船
        System.out.println(ship);
        Boat boat = new Boat();//小船
        System.out.println(boat);
        Bomb bomb = new Bomb(4,5,6,7);
        System.out.println(bomb);
    }
}
class Bomb{
    private double x;
    private double y;
    private double w;
    private double h;
    public Bomb(double x, double y, double w, double h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }
    @Override
    public String toString() {
        return "Bomb{" +
                "x=" + x +
                ", y=" + y +
                ", w=" + w +
                ", h=" + h +
                '}';
    }
}
class Ship{
}
class Boat{
    @Override //注解 Override 重写, 通知编译器检查后续方法是否符合重写语法
    public String toString() {
        return "小船";
    }
}

