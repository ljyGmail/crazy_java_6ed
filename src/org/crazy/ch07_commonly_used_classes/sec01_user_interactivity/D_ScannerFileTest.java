package org.crazy.ch07_commonly_used_classes.sec01_user_interactivity;

import java.util.Scanner;
import java.io.File;

public class D_ScannerFileTest {
    public static void main(String[] args) 
            throws Exception {
        // 将一个File对象作为Scanner的构造器参数，Scanner读取文件内容
        var sc = new Scanner(new File("../src/org/crazy/ch07_commonly_used_classes/sec01_user_interactivity/D_ScannerFileTest.java"));
        System.out.println("D_ScannerFileTest.java文件内容如下: ");
        // 判断是否还有下一行
        while (sc.hasNextLine()) {
            // 输出文件中的下一行
            System.out.println(sc.nextLine());
        }
    }
}
