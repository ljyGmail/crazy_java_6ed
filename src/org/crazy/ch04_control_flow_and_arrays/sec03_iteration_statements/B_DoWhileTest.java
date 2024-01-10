package org.crazy.ch04_control_flow_and_arrays.sec03_iteration_statements;

public class B_DoWhileTest {
    public static void main(String[] args) {
        // 定义变量count
        var count = 1;
        // 执行do while循环
        do {
            System.out.println(count);
            // 循环迭代语句
            count++;
            // 循环条件紧跟while关键字
        } while (count < 10);
        System.out.println("循环结束！");

        // do while循环的循环体至少执行一次
        // 定义变量count2
        var count2 = 20;
        // 执行do while循环
        do
            // 这行代码把循环体和迭代部分合并成一行代码
            System.out.println(count2++);
        while (count < 10);
        System.out.println("循环结束！");
    }
}
