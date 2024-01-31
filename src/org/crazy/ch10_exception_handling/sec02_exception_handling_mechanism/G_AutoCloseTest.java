package org.crazy.ch10_exception_handling.sec02_exception_handling_mechanism;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

public class G_AutoCloseTest {
    public static void main(String[] args)
        throws IOException {
        try (
            // 声明、初始化两个可关闭的资源
            // try语句会自动关闭这两个资源
            var br = new BufferedReader(
                new FileReader("../src/org/crazy/ch10_exception_handling/sec02_exception_handling_mechanism/G_AutoCloseTest.java"));
            var ps = new PrintStream(
                new FileOutputStream("../data/ch10_exception_handling/a.txt"))
        ) {
            // 使用两个资源
            System.out.println(br.readLine());
            ps.println("庄生晓梦迷蝴蝶");
        }
    }
}
