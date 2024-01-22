package org.crazy.ch06_oop_2.sec07_inner_classes;

public class E_InnerHasStaticTest {

    private class InnerClass {
        // 从Java 16开始，下面三个静态声明完全合法
        static {
            System.out.println("==================");
        }

        private static int inProp;
        private static void test() {
            System.out.println("inner test");
        }
    }
    
    public void test() {
        var inner = new InnerClass();
        System.out.println(InnerClass.inProp);
        InnerClass.test();
    }

    public static void main(String[] args) {
        System.out.println("从Java 16开始，Java允许在非静态内部类中定义静态成员");
        var outter = new E_InnerHasStaticTest();
        outter.test();
    }
}
