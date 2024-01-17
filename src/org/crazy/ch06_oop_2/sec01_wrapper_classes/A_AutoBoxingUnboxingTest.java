package org.crazy.ch06_oop_2.sec01_wrapper_classes;

public class A_AutoBoxingUnboxingTest {
    public static void main(String[] args) {
        // 直接把一个基本类型变量赋给Integer对象
        Integer intObj = 5;
        // 直接把一个boolean类型变量赋给Object类型变量
        Object boolObj = true;
        // 直接把一个Integer对象赋给int类型变量
        int it = intObj;
        if (boolObj instanceof Boolean boolWrap) {
            // 将Boolean类型变量赋给boolean变量
            boolean b = boolWrap;
            System.out.println(b);
        }
    }
}
