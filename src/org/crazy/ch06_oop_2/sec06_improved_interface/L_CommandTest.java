package org.crazy.ch06_oop_2.sec06_improved_interface;

public class L_CommandTest {
    public static void main(String[] args) {
        var pa = new I_ProcessArray();
        int[] target = {3, -4, 6, 4};
        // 第一次处理数组，具体的处理行为取决于PrintCommand
        pa.process(target, new J_PrintCommand());
        System.out.println("---------------------");
        // 第二次处理数组，具体的处理行为取决于SquareCommand
        pa.process(target, new K_SquareCommand());
    }
}
