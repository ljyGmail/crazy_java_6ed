package org.crazy.ch03_data_types_and_operators.sec05_type_cast_for_primitives;

public class E_AutoPromoteTest {
    public static void main(String[] args) {
        // 定义一个short类型的变量
        short sValue = 5;
        // 表达式中的sValue将被自动提升到int类型，故右边的表达式类型为int
        // 将一个int类型的值赋给short类型的变量将方式错误
        // sValue = sValue - 2;

        byte b = 40;
        var c = 'a';
        var i = 23;
        var d = .314;
        // 右边表达式最高等级的操作数为d (double类型)
        // 故右边表达式的类型为double，赋给一个double类型的变量
        double result = b + c + i * d;
        // 将输出144.222
        System.out.println(result);

        var val = 3;
        // 右边表达式中的两个操作数都是int类型，故右边表达式的类型为int
        // 虽然23/3不能除尽，但依然得到一个int类型的整数
        int intResult = 23 / val;
        System.out.println(intResult); // 将输出7

        // 输出字符串Hello!a7
        System.out.println("Hello!" + 'a' + 7);
        // 输出字符串104Hello!
        System.out.println('a' + 7 + "Hello!");
    }
}
