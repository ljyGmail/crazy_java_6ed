package org.crazy.ch09_generics.sec02_deep_dive_into_generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class D_R<T> {
    // 下面的代码错误， 不能在静态变量的声明中使用泛型形参
    // static T info;
    T age;

    public void foo(T msg) {
    }

    // 下面的代码错误，不能在静态方法的声明中使用泛型形参
    // public static void bar(T msg) {}
}

public class D_NotExistGenericsClassTest {
    public static void main(String[] args) {
        // 分别创建List<String>对象和List<Integer>对象
        List<String> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        // 调用getClass()方法来比较l1和l2的类是否相等
        System.out.println(l1.getClass() == l2.getClass());

        Collection<Integer> cs = new ArrayList<>();

        // 下面的代码在Java 16以前是错误的
        if (cs instanceof ArrayList<Integer>) {
            System.out.println("该集合的类型为ArrayList<Integer>");
        }

        if (cs instanceof ArrayList) {
            System.out.println("该集合的类型为ArrayList");
        }
    }
}
