package org.crazy.ch07_commonly_used_classes.sec03_common_classes;

import java.util.Objects;

public class B_ObjectsTest {
    // 定义一个obj变量，它的默认值是null
    static B_ObjectsTest obj;

    public static void main(String[] args) {
        // 输出一个null对象的hashCode值，输出0
        System.out.println(Objects.hashCode(obj));
        // 输出一个null对象的toString，输出null
        System.out.println(Objects.toString(obj));
        // 要求obj不能为null，如果obj为null，则引发异常
        // System.out.println(Objects.requireNonNull(obj,
                    // "obj参数不能是null"));

        // Objects.requireNonNull()方法主要用来对方法形参进行输入校验
        public Foo(Bar bar) {
            // 校验bar参数，如果bar参数为null，则将引发异常，否则，this.bar被赋值为bar参数
            this.bar = Objects.requireNonNull(bar);
        }
    }
}
