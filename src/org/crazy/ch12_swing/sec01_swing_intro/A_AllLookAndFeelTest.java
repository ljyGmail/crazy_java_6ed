package org.crazy.ch12_swing.sec01_swing_intro;

import javax.swing.UIManager;

public class A_AllLookAndFeelTest {
    public static void main(String[] args) {
        System.out.println("当前系统可用的所有LAF:");
        for (var info : UIManager.getInstalledLookAndFeels()) {
            System.out.println(info.getName()
                    + "--->" + info);
        }
    }
}
