package org.crazy.ch06_oop_2.sec07_inner_classes;

public class D_StaticTest {
    // 定义一个非静态内部类，它是一个空类
    private class In {}

    // 外部类的静态方法
    public static void main(String[] args) {
        // 下面的代码引发编译异常，因为静态成员(main()方法)
        // 无法访问非静态成员(In类)
        // new In();
        System.out.println("外部类的静态方法、静态代码块不能访问非静态内部类");
    }
}
