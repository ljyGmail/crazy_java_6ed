package org.crazy.ch06_oop_2.sec08_lambda;

import org.crazy.ch06_oop_2.sec06_improved_interface.I_ProcessArray;

public class B_Command2Test {
    public static void main(String[] args) {
        var pa = new I_ProcessArray();
        int[] array = {3, -4, 6, 4};
        // 处理数组，具体的处理行为取决于Lambda表达式
        pa.process(array, (int element) -> {
            System.out.println("数组元素的平方是: " + element * element);
        });
    }
}
