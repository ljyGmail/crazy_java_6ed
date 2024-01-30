package org.crazy.ch09_generics.sec04_generic_method;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class C_GenericMethodCorrectTest {
    // 声明一个泛型方法，该泛型方法中带一个T形参
    static <T> void test(Collection<? extends T> from, Collection<T> to) {
        for (var ele : from) {
            to.add(ele);
        }
    }

    public static void main(String[] args) {
        List<Object> lo = new ArrayList<>();
        List<String> ls = new ArrayList<>();

        // 下面的代码完全正常
        test(ls, lo);
    }
}
