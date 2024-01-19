package org.crazy.ch06_oop_2.sec05_abstract_classes;

public abstract class A_Shape {
    {
        System.out.println("执行Shape的初始化块...");
    }

    private String color;

    // 定义一个计算周长的抽象方法
    public abstract double calPerimeter();

    // 定义一个返回形状的抽象方法
    public abstract String getType();

    // 定义Shape的构造器，该构造器并不是用于创建Shape对象的
    // 而是用于被子类调用
    public A_Shape() {}

    public A_Shape(String color) {
        System.out.println("执行Shape的构造器...");
        this.color = color;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
