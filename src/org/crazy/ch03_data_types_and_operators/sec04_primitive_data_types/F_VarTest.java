package org.crazy.ch03_data_types_and_operators.sec04_primitive_data_types;

public class F_VarTest {
    public static void main(String[] args) {
        var a = 20; // 被赋值为20，因此a的类型是int
        System.out.println(a);
        // a = 1.6; // 这行代码会报错，不兼容的类型
        var b = 3.4; // 被赋值为3.4，因此b的类型是double
        System.out.println(b);
        var c = (byte) 13; // 被赋值为(byte) 13，因此c的类型是byte
        System.out.println(c);
        // c = a; // 这行代码会报错，不兼容的类型
        // var d; // 这行代码会报错，无法推断局部变量d的类型
        var st = "Hello"; // 被赋值"Hello",因此st的类型是String
        // st = 5; // 这行代码会报错，不兼容的类型
    }
}
