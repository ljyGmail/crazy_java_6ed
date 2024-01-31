package org.crazy.ch10_exception_handling.sec03_checked_runtime_exceptions;

import java.io.FileInputStream;
import java.io.IOException;

public class C_OverrideThrowsTest {

    public void test() throws IOException {
        var fis = new FileInputStream("noexist.txt");
    }

    public static void main(String[] args) {
        System.out.println("该示例表明在子类中重写父类的方法时不可以抛出比父类方法抛出的异常更大的异常");
    }
}

class Sub extends C_OverrideThrowsTest {
    // 子类方法声明抛出的异常比父类方法声明抛出的异常大
    // 所以下面的方法出错
    public void test() 
        // throws Exception {
        throws IOException {
    }
}
