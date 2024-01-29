package org.crazy.ch09_generics.sec03_type_wildcard;

import java.util.ArrayList;
import java.util.List;

public class A_ArrayErrTest {
    public static void main(String[] args) {
        // 定义一个Integer[]数组
        Integer[] ia = new Integer[5];
        // 可以把一个Integer[]数组赋值给Number[]变量
        Number[] na = ia;
        // 下面的代码编译正常，但在运行时会引发ArrayStoreException异常
        // 因为0.5并不是Integer
        // na[0] = 0.5;
        System.out.println("该示例把一个Integer[]赋值给Number[]变量后，试图把一个Double对象保存到该Number[]数组中，"
                + "编译时不会报错，但运行时会引发ArrayStoreException异常");

        List<Integer> iList = new ArrayList<>();
        // 下面的代码导致编译错误
        // List<Number> nList = iList;
        List<?> c = new ArrayList<String>();
        // 下面代码将引起编译错误
        // c.add(new Object());
        // 唯一可传入的参数是null，因为它是所有引用类型的实例
        c.add(null);
    }
}
