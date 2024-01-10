package org.crazy.ch04_control_flow_and_arrays.sec03_iteration_statements;

public class H_NestedLoopTest {
    public static void main(String[] args) {
        // 外层循环
        for (var i = 0; i < 5; i++) {
            // 内层循环
            for (var j = 0; j < 3; j++) {
                System.out.println("i的值为: " + i + " j的值为: " + j);
            }
        }
    }
}
