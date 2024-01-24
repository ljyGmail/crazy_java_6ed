package org.crazy.ch07_commonly_used_classes.sec03_common_classes;

import java.math.BigDecimal;

public class L_BigDecimalTrapTest {
    public static void main(String[] args) {
        var f1 = new BigDecimal("2.0");
        var f2 = new BigDecimal("2");
        System.out.println(f1.equals(f2)); // 输出false

        var f3 = new BigDecimal("0.00");
        System.out.println(f3.equals(BigDecimal.ZERO));

        System.out.println(f1.compareTo(f2)); // 输出0
        System.out.println(f3.compareTo(BigDecimal.ZERO)); // 输出0
    }
}
