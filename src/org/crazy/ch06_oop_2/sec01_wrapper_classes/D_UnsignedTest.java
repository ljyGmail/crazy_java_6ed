package org.crazy.ch06_oop_2.sec01_wrapper_classes;

public class D_UnsignedTest {
    public static void main(String[] args) {
        byte b = -3;
        // 将byte类型的-3转换为无符号整数
        System.out.println("byte类型的-3对应的无符号整数: "
                + Byte.toUnsignedInt(b)); // 输出253

        byte b1 = (byte) 0b1111_1101;
        System.out.println(b1);

        // 指定使用十六进制解析无符号整数
        var val = Integer.parseUnsignedInt("ab", 16);
        System.out.println(val); // 输出171
        // 将-12转换为无符号int类型，然后转换为十六进制形式的字符串
        System.out.println(Integer.toUnsignedString(-12, 16)); // 输出fffffff4
        // 将两个数转换为无符号整数后相除
        System.out.println(Integer.divideUnsigned(-2, 3));
        // 将两个数转换为无符号整数后求余
        System.out.println(Integer.remainderUnsigned(-2, 7));
        // 将-2按无符号的形式转换为long类型
        System.out.println(Integer.toUnsignedLong(-2));
    }
}
