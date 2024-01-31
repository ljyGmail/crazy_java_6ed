package org.crazy.ch10_exception_handling.sec05_exception_stack_trace;

class SelfException extends RuntimeException {
    SelfException() {}

    SelfException(String msg) {
        super(msg);
    }
}

public class A_PrintStackTraceTest {
    public static void main(String[] args) {
        firstMethod();
    }

    public static void firstMethod() {
        secondMethod();
    }

    public static void secondMethod() {
        thirdMethod();
    }

    public static void thirdMethod() {
        throw new SelfException("自定义预测信息");
    }
}
