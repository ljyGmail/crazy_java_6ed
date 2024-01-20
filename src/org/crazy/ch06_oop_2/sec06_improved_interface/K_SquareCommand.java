package org.crazy.ch06_oop_2.sec06_improved_interface;

public class K_SquareCommand implements H_Command {
    public void process(int element) {
        System.out.println("数组元素的平方是: " + element * element);
    }
}
