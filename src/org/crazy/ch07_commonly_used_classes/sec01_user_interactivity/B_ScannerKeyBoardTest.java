package org.crazy.ch07_commonly_used_classes.sec01_user_interactivity;

import java.util.Scanner;

public class B_ScannerKeyBoardTest {
    public static void main(String[] args) {
        // System.in代表标准输入，就是键盘输入
        var sc = new Scanner(System.in);
        // 增加下面一行，只把会车符作为分隔符
        sc.useDelimiter("\n");
        /*
        // 判断是否还有下一个输入项
        while (sc.hasNext()) {
            // 输出输入项
            System.out.println("键盘输入的内容是: "
                    + sc.next());
        }
        */
    }
}
