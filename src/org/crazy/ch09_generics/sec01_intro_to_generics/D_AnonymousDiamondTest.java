package org.crazy.ch09_generics.sec01_intro_to_generics;

import java.util.Date;

interface D_Foo<T> {
    void test(T t);
}

public class D_AnonymousDiamondTest {
    public static void main(String[] args) {
        // 指定Foo类中泛型为String类型
        D_Foo<String> f = new D_Foo<>() {
            public void test(String t) {
                System.out.println("test方法的t参数为: " + t);
            }
        };

        f.test("老梁");

        // 使用泛型通配符，此时相当于通配符的上限为Object
        D_Foo<?> fo = new D_Foo<>() {
            // test()方法的参数类型为Object
            public void test(Object t) {
                System.out.println("test方法的Object参数为: " + t);
            }
        };

        // 使用泛型通配符，通配符的上限为Number
        D_Foo<? extends Number> fn = new D_Foo<>() {
            // 此时test()方法的参数类型为Number
            public void test(Number t) {
                System.out.println("test方法的Number参数为: " + t);
            }
        };
    }
}
