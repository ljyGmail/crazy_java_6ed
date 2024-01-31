package org.crazy.ch10_exception_handling.sec03_checked_runtime_exceptions;

import java.io.FileInputStream;
import java.io.IOException;

public class A_ThrowsTest {
    public static void main(String[] args) throws IOException {
        var fis = new FileInputStream("noexist.txt");
    }
}
