package org.crazy.ch07_commonly_used_classes.sec03_common_classes;

import java.util.Optional;

public class C_OptionalTest {
    public static void main(String[] args) {
        test("fkjava");
        System.out.println("--------------------");
        test(null);
    }

    public static void test(String str) {
        var op = Optional.ofNullable(str);
        // 只有当被包装的变量不为null时才执行Lambda表达式
        op.ifPresent(s -> System.out.println(s.length()));
        // 当被包装的变量不为null时，执行第1个Lambda表达式
        // 否则执行第2个Lambda表达式
        op.ifPresentOrElse(s -> System.out.println(s.length()),
                () -> System.out.println("为空"));
        // 如果被包装的变量不为null，则返回值包装的变量，否则返回默认值
        System.out.println(op.orElse("默认值"));
        // 如果被包装的变量不为null，则返回true
        System.out.println(op.isPresent());
        // 如果被包装的变量为null，则返回true
        System.out.println(op.isEmpty());
    }
}
