package org.crazy.ch06_oop_2.sec08_lambda;

@FunctionalInterface
interface D_FkTest {
    void test();
}

public class D_LambdaTest {
    public static void main(String[] args) {
        Runnable r = () -> {
            for (var i = 0; i < 100; i++) {
                System.out.println(i);
            }
        };

        // 不兼容的类型: Object不是函数式接口
        /*
        Object obj = () -> {
            for (var i = 0; i < 100; i++) {
                System.out.println(i);
            }
        };
        */

        Object obj = (Runnable) () -> {
            for (var i = 0; i < 100; i++) {
                System.out.println(i);
            }
        };

        // 同样的Lambda表达式可以被当成不同的目标类型，唯一的要求是
        // Lambda表达式的形参列表与函数式接口中唯一的抽象方法的形参列表相同
        Object obj2 = (D_FkTest) () -> {
            for (var i = 0; i < 100; i++) {
                System.out.println(i);
            }
        };

        System.out.println("Lambda表达式与函数式接口");
    }
}
