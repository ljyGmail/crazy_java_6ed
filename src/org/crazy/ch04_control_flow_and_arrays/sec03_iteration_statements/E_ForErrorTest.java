package org.crazy.ch04_control_flow_and_arrays.sec03_iteration_statements;

public class E_ForErrorTest {
    public static void main(String[] args) {
        // 在循环体中修改count的值，导致该程序变成了死循环
        // 循环的初始化条件、循环条件、循环迭代语句都在下面一行
        /*
        for (var count = 0; count < 10; count++) {
            System.out.println(count);
            // 再次修改循环变量
            count *= 0.1;
        }
        */
        System.out.println("循环结束！");
    }
}
