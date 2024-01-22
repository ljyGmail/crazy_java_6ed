package org.crazy.ch06_oop_2.sec07_inner_classes;

interface N_A {
    void test();
}

public class N_AnonymousAccessLocalVarsTest {
    public static void main(String[] args) {
        int age = 8;

        var a = new N_A() {
            public void test() {
                // 下面语句会导致编译错误
                // 由于age局部变量被匿名内部类访问了，因此age相当于被final修饰了
                // age = 5; // effective final

                // 在Java 8以前，下面的语句将提示错误，age必须使用final修饰
                // 从Java 8开始，允许匿名内部类、局部内部类访问非final的局部变量
                System.out.println(age);
            }
        };

        a.test();
    }
}
