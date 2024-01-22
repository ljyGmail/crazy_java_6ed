package org.crazy.ch06_oop_2.sec08_lambda;

@interface NotNull {}

@FunctionalInterface
interface E_Predator {
    void prey(@NotNull String animal);
}

public class E_VarInLambdaTest {
    public static void main(String[] args) {
        // 使用Lambda表达式对var变量赋值
        // 必须显式指定Lambda表达式的目标类型
        var run = (Runnable) () -> {
            for (var i = 0; i < 100; i++) {
                System.out.println(i);
            }
        };

        // 使用var声明Lambda表达式的形参类型
        // 这样即可为Lambda表达式的形参添加@NotNull注解
        E_Predator predator = (@NotNull var animal) -> {
            System.out.println("老鹰正在猎捕" + animal);
        };

        predator.prey("兔子");
    }
}
