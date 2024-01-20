package org.crazy.ch06_oop_2.sec06_improved_interface;

public class I_ProcessArray {
    public void process(int[] target, H_Command cmd) {
        for (var t : target) {
            cmd.process(t);
        }
    }
}
