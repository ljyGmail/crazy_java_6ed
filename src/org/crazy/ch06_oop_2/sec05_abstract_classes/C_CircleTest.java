package org.crazy.ch06_oop_2.sec05_abstract_classes;

public class C_CircleTest extends A_Shape {

    private double radius;

    public C_CircleTest(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    // 重写Shape类的计算周长的抽象方法
    public double calPerimeter() {
        return 2 * Math.PI * radius;
    }

    // 重写Shape类的返回形状的抽象方法
    public String getType() {
        return getColor() + "圆形";
    }

    public static void main(String[] args) {
        A_Shape s1 = new B_Triangle("黑色", 3, 4, 5);
        A_Shape s2 = new C_CircleTest("黄色", 3);
        System.out.println(s1.getType());
        System.out.println(s1.calPerimeter());
        System.out.println(s2.getType());
        System.out.println(s2.calPerimeter());
    }
}
