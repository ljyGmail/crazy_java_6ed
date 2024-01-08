package org.crazy.ch03_data_types_and_operators.sec07_operators;

public class B_DivTest {
    public static void main(String[] args) {
        var a = 5.2;
        var b = 3.1;
        var div = a / b;
        // div的值是1.6774193548487097
        System.out.println(div);
        // 输出正无穷大: Infinity
        System.out.println("5除以0.0的结果是：" + 5 / 0.0);
        // 输出负无穷大: -Infinity
        System.out.println("-5除以0.0的结果是：" + -5 / 0.0);
        System.out.println("5除以0.0的结果是：" + 5 / 0.0);
        // 下面的代码将出现异常
        // java.lang.ArithmeticException: / by zero
        System.out.println("-5除以0的结果是：" + -5 / 0);
    }
}
