package org.crazy.ch10_exception_handling.sec04_using_throw_statement;

public class B_CustomExceptionTest {
    public static void main(String[] args) {
        System.out.println("该示例演示如何自定义一个异常类");
    }
}

class AuctionException extends Exception {
    // 无参数的构造器
    public AuctionException() {}

    // 带一个字符串参数的构造器
    public AuctionException(String msg) {
        super(msg);
    }
}
