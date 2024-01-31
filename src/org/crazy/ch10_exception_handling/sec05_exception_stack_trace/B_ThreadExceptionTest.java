package org.crazy.ch10_exception_handling.sec05_exception_stack_trace;

public class B_ThreadExceptionTest implements Runnable {
    public void run() {
        firstMethod();
    }

    public void firstMethod() {
        secondMethod();
    }

    public void secondMethod() {
        var a = 5;
        var b = 0;
        var c = a / b;
    }

    public static void main(String[] args) {
        new Thread(new B_ThreadExceptionTest()).start();
    }
}
