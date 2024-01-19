package org.crazy.ch06_oop_2.sec05_abstract_classes;

public class B_Triangle extends A_Shape {
    // 定义三角形的三个边
    private double a;
    private double b;
    private double c;

    public B_Triangle(String color, double a, double b, double c) {
        super(color);
        this.setSides(a, b, c);
    }

    public void setSides(double a, double b, double c) {
        if(a >= b + c || b >= a + c || c >= a + b) {
            System.out.println("三角形的两边之和必须大于第三边");
            return;
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    // 重写Shape类的计算周长的抽象方法
    public double calPerimeter() {
        return a + b + c;
    }

    // 重写Shape类的返回形状的抽象方法
    public String getType() {
        return "三角形";
    }
}
