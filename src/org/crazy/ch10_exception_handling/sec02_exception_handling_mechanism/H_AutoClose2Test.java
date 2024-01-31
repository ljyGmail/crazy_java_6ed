package org.crazy.ch10_exception_handling.sec02_exception_handling_mechanism;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

public class H_AutoClose2Test {
    public static void main(String[] args)
        throws IOException {
        // 有final修饰的资源
        final var br = new BufferedReader(
                new FileReader("../src/org/crazy/ch10_exception_handling/sec02_exception_handling_mechanism/G_AutoCloseTest.java"));
        // 没有显式使用final修饰，但只要不对该变量重新赋值，该变量就是有效的final
        var ps = new PrintStream(
                new FileOutputStream("b.txt"));

        // 只要将两个资源放在try后的圆括号内即可
        try (br; ps) {
            // 使用两个资源
            System.out.println(br.readLine());
            ps.println("庄生晓梦迷蝴蝶");
        }
    }
}
