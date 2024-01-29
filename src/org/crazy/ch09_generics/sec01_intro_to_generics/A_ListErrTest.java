package org.crazy.ch09_generics.sec01_intro_to_generics;

import java.util.ArrayList;

public class A_ListErrTest {
    public static void main(String[] args) {
        // 创建一个只想保存字符串的List集合
        var strList = new ArrayList();
        strList.add("疯狂Java讲义");
        strList.add("疯狂Android讲义");
        // "不小心"把一个Integer对象"丢进"了集合中
        strList.add(5);
        // 下面代码引发ClassCaseException
        // strList.forEach(str -> System.out.println(((String) str).length()));
        System.out.println("该示例表明向没有泛型声明的集合里放入元素，取出元素后的操作可能引发类型转换异常");
    }
}
