package org.crazy.ch06_oop_2.sec07_inner_classes;

public class F_StaticInnerClassTest {
    private int prop1 = 5;
    private static int prop2 = 9;

    static class StaticInnerClass {
        public void accessOuterProp() {
            // 下面的代码出现错误
            // 静态内部类无法访问外部类的实例变量
            // System.out.println(prop1);
            // 下面的代码正常
            System.out.println(prop2);
        }
    }

    public static void main(String[] args) {
        var inner = new F_StaticInnerClassTest.StaticInnerClass();
        inner.accessOuterProp();
    }
}
