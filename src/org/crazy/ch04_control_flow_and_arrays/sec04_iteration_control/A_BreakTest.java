package org.crazy.ch04_control_flow_and_arrays.sec04_iteration_control;

public class A_BreakTest {
    public static void main(String[] args) {
        // 一个简单的for循环
        for (var i = 0; i < 10; i++) {
            System.out.println("i的值是" + i);
            if (i == 2) {
                // 执行该语句将结束循环
                break;
            }
        }
    }
}
