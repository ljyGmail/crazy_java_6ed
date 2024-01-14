package org.crazy.ch05_oop_1.sec03_member_and_local_variables;

public class G_Scope3Test {
    public static void main(String[] args) {
        // 定义一个代码块局部变量作为循环变量
        for (var i = 0; i < 10; i++) {
            System.out.println("Hello");
        }
    }
}
