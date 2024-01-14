package org.crazy.ch05_oop_1.sec03_member_and_local_variables;

public class B_BlockTest {
    public static void main(String[] args) {
        {
            // 定义一个代码块局部变量a
            int a;
            // 下面的代码将出现 错误，因为a变量还未初始化
            // System.out.println("代码块局部变量a的值: " + a);
            a = 5;
            System.out.println("代码块局部变量a的值: " + a);
        }
        // 下面试图访问的a变量并不存在
        // System.out.println(a);
    }
}
