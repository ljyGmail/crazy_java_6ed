package org.crazy.ch09_generics.sec02_deep_dive_into_generics;

import org.crazy.ch04_control_flow_and_arrays.sec04_iteration_control.D_ContinueLabelTest;

public class A_AppleTest<T> {
    // 使用T类型定义实例变量
    private T info;

    public A_AppleTest() {
    }

    // 在下面的方法中使用T类型来定义构造器
    public A_AppleTest(T info) {
        this.info = info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public T getInfo() {
        return this.info;
    }

    public static void main(String[] args) {
        // 由于传给T形参的是String，所以构造器参数只能是String
        A_AppleTest<String> a1 = new A_AppleTest<>("苹果");
        System.out.println(a1.getInfo());
        // 由于传给T形参的是Double，所以构造器参数只能是Double或double
        A_AppleTest<Double> a2 = new A_AppleTest<>(5.67);
        System.out.println(a2.getInfo());
    }
}
