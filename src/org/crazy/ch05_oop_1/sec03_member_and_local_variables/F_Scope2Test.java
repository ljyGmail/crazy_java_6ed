package org.crazy.ch05_oop_1.sec03_member_and_local_variables;

public class F_Scope2Test {
    public static void main(String[] args) {
        // 定义一个方法局部变量作为 循环变量
        int i;
        for (i = 0; i < 10; i++) {
            System.out.println("Hello");
        }
    }
}
