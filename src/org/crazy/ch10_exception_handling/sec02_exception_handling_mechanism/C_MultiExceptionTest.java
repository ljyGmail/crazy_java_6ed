package org.crazy.ch10_exception_handling.sec02_exception_handling_mechanism;

public class C_MultiExceptionTest {
    public static void main(String[] args) {
        try {
            var a  = Integer.parseInt(args[0]);
            var b  = Integer.parseInt(args[1]);
            var c = a / b;
            System.out.println("您输入的两个数相除的结果是: " + c);
        } catch (IndexOutOfBoundsException | NumberFormatException | ArithmeticException me) {
            System.out.println("程序发生了数组越界、数字格式异常、算术异常之一");
            // 当捕捉多种类型的异常时，异常变量默认有final修饰
            // 所以下面的代码有错
            // me = new ArithmeticException("test");
        } catch (Exception e) {
            System.out.println("未知异常");
            // 当捕捉一种类型的异常时，异常变量没有final修饰
            // 所以下面的代码完全正确
            e = new RuntimeException("test");
        }
    }
}
