package org.crazy.ch06_oop_2.sec03_static_members;

public class A_NullAcessStaticTest {
    private static void test() {
        System.out.println("static修饰的类方法");
    }

    public static void main(String[] args) {
        // 定义一个NullAccessStaticTest变量，其值为null
        A_NullAcessStaticTest nast = null;
        // 使用null对象调用所属类到静态方法
        nast.test();
    }
}
