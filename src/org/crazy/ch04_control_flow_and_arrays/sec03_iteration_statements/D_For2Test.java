package org.crazy.ch04_control_flow_and_arrays.sec03_iteration_statements;

public class D_For2Test {
    public static void main(String[] args) {
        // 同时定义了三个初始化变量，使用&&来组合多个boolean表达式
        for (int b = 0, s = 0, p = 0;
                b < 10 && s < 4 && p < 10; p++) {
            System.out.println(b++);
            System.out.println(++s + p);
        }
    }
}
