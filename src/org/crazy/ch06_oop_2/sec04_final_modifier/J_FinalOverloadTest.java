package org.crazy.ch06_oop_2.sec04_final_modifier;

public class J_FinalOverloadTest {
    // final修饰的方法只是不能被重写，但完全可以被重载
    public final void test() {}

    public final void test(String arg) {}

    public static void main(String[] args) {
        System.out.println("final修饰的方法只是不能被重写，但完全可以被重载");
    }
}
