package org.crazy.ch03_data_types_and_operators.sec04_primitive_data_types;

public class E_BooleanTest {
    public static void main(String[] args) {
        // 定义b1的值为true
        boolean b1 = true;
        // 定义b2的值为false
        boolean b2 = false;
        System.out.println("b1 = " + b1);
        System.out.println("b2 = " + b2);
        // 使用boolean类型的值和字符串进行运算，boolean类型的值会被自动转换成字符串
        String str = true + "";
        // 下面将输出true
        System.out.println(str);
    }
}
