package org.crazy.ch06_oop_2.sec04_final_modifier;

public final class K_FinalClassTest {
    public static void main(String[] args) {
        System.out.println("Final修饰的类不能被继承");
    }
}

// 下面的类定义将出现编译错误
// class K_Sub extends K_FinalClassTest {}
