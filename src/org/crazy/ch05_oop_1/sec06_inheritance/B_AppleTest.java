package org.crazy.ch05_oop_1.sec06_inheritance;

public class B_AppleTest extends A_Fruit {
    public static void main(String[] args) {
        // 创建Apple对象
        var a = new B_AppleTest();
        // Apple对象本身没有weight成员变量
        // 因为Apple的父类有weight成员变量，也可以访问Apple对象的weight成员变量
        a.weight = 56;
        // 调用Apple对象的info()方法
        a.info();
    }
}
