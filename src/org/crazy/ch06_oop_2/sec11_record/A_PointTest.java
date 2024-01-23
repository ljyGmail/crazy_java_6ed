package org.crazy.ch06_oop_2.sec11_record;

final record A_Point(int x, int y) {
    // 成员变量只能是类变量
    private static String color;

    // 初始化块只能是类初始化块
    static {
        System.out.println("类初始化块");
    }

    // 可以定义方法
    public void info() {
        System.out.println("Point的info方法");
    }
}

public class A_PointTest {
    public static void main(String[] args) {
        // 声明变量、创建对象，该构造器由编译器自动提供
        A_Point p = new A_Point(2, 3);
        // 调用自动生成的x()方法(相当于getter方法)
        System.out.println(p.x());
        System.out.println(p);
    }
}
