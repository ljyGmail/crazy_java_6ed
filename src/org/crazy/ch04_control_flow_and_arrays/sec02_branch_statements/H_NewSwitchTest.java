package org.crazy.ch04_control_flow_and_arrays.sec02_branch_statements;

public class H_NewSwitchTest {
    public static void main(String[] args) {
        // 声明变量score，并为其赋值为'C'
        var score = 'C';
        // 执行switch分支语句
        switch (score) {
            // case后的代码块有多条语句，不能省略花括号
            case 'A', 'B' -> {
                System.out.println("成绩还不错，希望继续保持");
                System.out.println("后续给你颁发奖状");
            }
            // case后的代码只有一条语句，省略花括号
            case 'C', 'D', 'F' -> System.out.println("成绩不足，还需努力!");
            default -> System.out.println("成绩输入错误");
        }
    }
}
