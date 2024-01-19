package org.crazy.ch06_oop_2.sec06_improved_interface;

interface C_InterfaceA {
    int PROP_A = 5;

    void testA();
}

interface C_InterfaceB {
    int PROP_B = 6;

    static void testA() {
    }

    void testB();
}

interface C_InterfaceC extends C_InterfaceA, C_InterfaceB {
    int PROP_C = 7;

    void testC();
}

public class C_InterfaceExtendsTest {
    public static void main(String[] args) {
        System.out.println(C_InterfaceC.PROP_A);
        System.out.println(C_InterfaceC.PROP_B);
        System.out.println(C_InterfaceC.PROP_C);
    }
}
