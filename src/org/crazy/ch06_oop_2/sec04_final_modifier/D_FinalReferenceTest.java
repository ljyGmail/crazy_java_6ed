package org.crazy.ch06_oop_2.sec04_final_modifier;

import java.util.Arrays;

class D_Person {
    private int age;

    public D_Person() {}

    // 有参数的构造器
    public D_Person(int age) {
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

public class D_FinalReferenceTest {
    public static void main(String[] args) {
        // 使用final修饰数组变量，iArr是一个引用变量
        final int[] iArr = {5, 6, 12, 9};
        System.out.println(Arrays.toString(iArr));
        // 对数组元素进行排序，合法
        Arrays.sort(iArr);
        System.out.println(Arrays.toString(iArr));
        // 对数组元素赋值，合法
        iArr[2] = -8;
        System.out.println(Arrays.toString(iArr));
        // 下面的语句对iArr重新赋值，非法
        // iArr = null;
        // 使用final修饰Person变量，p是一个引用变量
        final var p = new D_Person();
        // 改变Person对象的age实例变量，合法
        p.setAge(23);
        System.out.println(p.getAge());
        // 下面的语句对p重新赋值，非法
        // p = null;
    }
}
