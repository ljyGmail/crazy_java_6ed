package org.crazy.ch03_data_types_and_operators.sec07_operators;

public class D_IncrementDecrementTest {
    public static void main(String[] args) {
        var a = 5;
        // 让a先执行算术运算，然后自加
        var b = a++ + 6;
        // 输出a的值为6，b的值为11
        System.out.println(a + "\n" + b);

        a = 5;
        // 让a先自加，然后执行算术运算
        b = ++a + 6;
        // 输出a的值为6，b的值为12
        System.out.println(a + "\n" + b);
    }
}
