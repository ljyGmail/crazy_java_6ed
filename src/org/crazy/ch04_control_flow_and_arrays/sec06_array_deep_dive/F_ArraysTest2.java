package org.crazy.ch04_control_flow_and_arrays.sec06_array_deep_dive;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;
import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;
import java.util.function.IntPredicate;

public class F_ArraysTest2 {
    public static void main(String[] args) {
        var arr1 = new int[] {3, -4, 25, 16, 30, 18};
        // 对数组arr1进行并发排序
        Arrays.parallelSort(arr1);
        System.out.println(Arrays.toString(arr1));
        var arr2 = new int[] {3, -4, 25, 16, 30, 18};
        Arrays.parallelPrefix(arr2, new IntBinaryOperator() {
            // left代表新数组中前一个索引处的元素，right代表原数组中当前索引处的元素
            // 新数组的第一个元素总等于原数组的第一个元素
            public int applyAsInt(int left, int right) {
                System.out.println("left: " + left);
                System.out.println("right: " + right);
                return left * right;
            }
        });
        System.out.println(Arrays.toString(arr2));
        var arr3 = new int[5];
        Arrays.parallelSetAll(arr3, new IntUnaryOperator() {
            public int applyAsInt(int operand) {
                System.out.println("operand: " + operand);
                return operand * 5;
            }
        });
        System.out.println(Arrays.toString(arr3));
        // 将arr3数组转换成IntStream
        IntStream arr3Stream = Arrays.stream(arr3);
        // 对arr3Stream进行过滤，只保留数值大于10的元素
        int result = arr3Stream.filter(new IntPredicate() {
            public boolean test(int ele) {
                return ele > 10;
            }
        }).sum(); // 结束总和
        System.out.println(result);
    }
}
