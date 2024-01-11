package org.crazy.ch04_control_flow_and_arrays.sec06_array_deep_dive;

public class B_PrimitiveArrayTest {
    public static void main(String[] args) {
        // 定义一个int[] 类型的数组变量
        int[] iArr;
        // 动态初始化数组，数组的长度为5
        iArr = new int[5];
        // 遍历该数组(默认初始化)
        System.out.println("默认初始化后:");
        for (int i : iArr) {
            System.out.println(i);
        }

        // 采用循环方式为每个数组元素赋值
        for (var i = 0; i < iArr.length; i++) {
            iArr[i] = i + 10;
        }

        // 遍历该数组(显式初始化)
        System.out.println("显式初始化后:");
        for (int i : iArr) {
            System.out.println(i);
        }
    }
}
