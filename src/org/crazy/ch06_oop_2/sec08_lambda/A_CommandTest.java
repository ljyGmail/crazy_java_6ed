package org.crazy.ch06_oop_2.sec08_lambda;

import org.crazy.ch06_oop_2.sec06_improved_interface.H_Command;
import org.crazy.ch06_oop_2.sec06_improved_interface.I_ProcessArray;

public class A_CommandTest {
    public static void main(String[] args) {
        var pa = new I_ProcessArray();
        int[] target = {3, -4, 6, 4};
        // 处理数组，具体的处理行为取决与匿名内部类
        pa.process(target, new H_Command() {
            public void process(int element) {
                System.out.println("数组运算的平方是: " + element * element);
            }
        });
    }
}
