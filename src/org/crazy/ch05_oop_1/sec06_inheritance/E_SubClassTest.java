package org.crazy.ch05_oop_1.sec06_inheritance;

class E_BassClass {
    public int a = 5;
}

public class E_SubClassTest extends E_BassClass {
    public int a = 7;

    public void accessOwner() {
        System.out.println(a);
    }

    public void accessBase() {
        // 通过super来限定访问从父类继承得到的a实例变量
        System.out.println(super.a);
    }

    public static void main(String[] args) {
        var sc = new E_SubClassTest();
        sc.accessOwner(); // 输出7
        sc.accessBase(); // 输出5
    }
}
