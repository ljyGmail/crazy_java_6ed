package org.crazy.ch06_oop_2.sec04_final_modifier;

public class F_FinalConstantReplaceTest {
    public static void main(String[] args) {
        // 下面定义了4个final"宏变量"
        final var a = 5 + 2;
        final var b = 1.2 / 3;
        final var str = "疯狂" + "Java";
        final var book = "疯狂Java讲义: " + 99.0;
        // 下面的book2变量的值因为调用了方法，所以无法在编译时被确定下来
        final var book2 = "疯狂Java讲义: " + String.valueOf(99.0);
        System.out.println(book == "疯狂Java讲义: 99.0");
        System.out.println(book2 == "疯狂Java讲义: 99.0");
    }
}
