package org.crazy.ch10_exception_handling.sec03_checked_runtime_exceptions;

import java.io.FileInputStream;
import java.io.IOException;

public class B_Throws2Test {
    public static void main(String[] args) throws Exception {
        test();
    }

    public static void test() throws IOException {
        // 因为FileInputStream的构造器声明抛出IOException异常
        // 所以调用FileInputStream的代码要么位于try...catch块中
        // 要么位于另一个带throws声明抛出的方法中
        var fis = new FileInputStream("noexist.txt");
    }
}
