package org.crazy.ch04_control_flow_and_arrays.sec03_iteration_statements;

public class C_ForTest {
    public static void main(String[] args) {
        // 循环的初始化条件、循环条件、循环迭代语句都在下面一行
        for (var count = 0; count < 10; count++) {
            System.out.println(count);
        }
        System.out.println("循环结束！");
    }
}
