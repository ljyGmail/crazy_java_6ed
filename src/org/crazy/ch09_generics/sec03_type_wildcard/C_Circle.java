package org.crazy.ch09_generics.sec03_type_wildcard;

// 定义Shape的子类Circle
public class C_Circle extends B_Shape {
    // 实现画图方法，以打印字符串来模拟画图方法实现
    public void draw(E_Canvas c) {
        System.out.println("在画布" + c + "上画一个圆");
    }
}
