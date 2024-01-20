package org.crazy.ch06_oop_2.sec06_improved_interface;

public class J_PrintCommand implements H_Command {
    public void process(int element) {
        System.out.println("迭代输出目标数组的元素: " + element);
    }
}
