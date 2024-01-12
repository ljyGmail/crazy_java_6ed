package org.crazy.ch03_data_types_and_operators.sec05_type_cast_for_primitives;

public class C_NarrowConversionTest {
    public static void main(String[] args) {
        var iValue = 233;
        // 强制把一个int类型的值转换为byte类型的值
        byte bValue = (byte) iValue;
        // 将输出-23
        System.out.println(bValue);
        var dValue = 3.98;
        // 强制把一个double类型的值转换为int类型的值
        int toI = (int) dValue;
        // 将输出3
        System.out.println(toI);
    }
}
