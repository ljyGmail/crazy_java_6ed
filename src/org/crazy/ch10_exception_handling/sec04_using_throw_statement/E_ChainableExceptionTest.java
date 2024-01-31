package org.crazy.ch10_exception_handling.sec04_using_throw_statement;

public class E_ChainableExceptionTest {
    public static void main(String[] args) {
        System.out.println("该示例演示如何封装原始异常，从而实现对异常的链式处理");
    }
}

class SalException extends Exception {
    public SalException() {}

    public SalException(String msg) {
        super(msg);
    }

    // 创建一个可以接收Throwable参数的构造器
    public SalException(Throwable t) {
        super(t);
    }
}
