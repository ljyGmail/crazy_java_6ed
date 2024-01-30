package org.crazy.ch09_generics.sec06_generics_and_arrays;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class A_GenericAndArray {
    public static void main(String[] args) {
        // 下面的代码在编译时有"[unchecked]未经检查的转换"警告
        List<String>[] lsa = new ArrayList[10];
        // 将lsa向上转型为Object[]类型的变量
        Object[] oa = lsa;
        List<Integer> li = new ArrayList<>();
        li.add(3);
        oa[1] = li;
        // 下面的代码将引起ClassCastException异常
        // String s = lsa[1].get(0);

        List<?>[] lsa2 = new ArrayList<?>[10];
        Object[] oa2 = lsa2;
        List<Integer> li2 = new ArrayList<>();
        li2.add(3);
        oa2[1] = li2;
        Object target = lsa2[1].get(0);
        if (target instanceof String s) {
            System.out.println(s);
        } else {
            System.out.println("target不是字符串类型");
        }
    }

    <T> T[] makeArray(Collection<T> coll) {
        // 下面的代码将导致编译错误
        // return new T[coll.size()];
        return null;
    }
}
