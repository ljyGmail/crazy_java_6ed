package org.crazy.ch07_commonly_used_classes.sec01_user_interactivity;

import java.util.Scanner;

public class C_ScannerLongTest {
    public static void main(String[] args) {
        // System.in代表标准输入，就是键盘输入
        var sc = new Scanner(System.in);
        // 判断是否还有下一个long类型整数
        /*
        while (sc.hasNextLong()) {
            // 输出输入项
            System.out.println("键盘输入的内容是: "
                    + sc.nextLong());
        }
        */
    }
}
