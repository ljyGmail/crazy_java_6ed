package org.crazy.ch09_generics.sec04_generic_method;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class B_GenericMethodErrorTest {
    // 声明一个泛型方法，该泛型方法中带一个T泛型形参
    static <T> void test(Collection<T> from, Collection<T> to) {
        for (var ele : from) {
            to.add(ele);
        }
    }

    public static void main(String[] args) {
        List<Object> lo = new ArrayList<>();
        List<String> ls = new ArrayList<>();

        // 下面的代码将产生编译错误
        // test(ls, lo);
        System.out.println("该实例表明编译器无法准确地推断出泛型方法中泛型形参的类型时，会发生编译错误");
    }
}
