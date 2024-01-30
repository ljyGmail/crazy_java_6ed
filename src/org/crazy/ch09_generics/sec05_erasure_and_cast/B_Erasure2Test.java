package org.crazy.ch09_generics.sec05_erasure_and_cast;

import java.util.ArrayList;
import java.util.List;

public class B_Erasure2Test {
    public static void main(String[] args) {
        List<Integer> li = new ArrayList<>();
        li.add(6);
        li.add(9);

        List list = li;
        // 下面的代码引起"未经检查的转换"警告，在编译、运行时完全正常
        List<String> ls = list;
        // 但只要访问ls里的元素，如下代码就会引起运行时异常
        // System.out.println(ls.get(0));

        System.out.println("该示例表明将被擦除泛型信息的变量赋给其他类型的泛型变量是，"
                + "编译，运行都不会报错，但一旦访问其中的元素就会引发ClassCastException");
    }
}