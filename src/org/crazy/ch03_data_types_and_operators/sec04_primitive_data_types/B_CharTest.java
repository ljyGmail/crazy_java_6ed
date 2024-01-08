package org.crazy.ch03_data_types_and_operators.sec04_primitive_data_types;

public class B_CharTest {
    public static void main(String[] args) {
        // 直接指定单个字符作为字符值
        char aChar = 'a';
        // 使用转义字符作为字符值
        char enterChar = '\r';
        // 使用Unicode编码值来指定字符值
        char ch = '\u9999';
        // 将输出一个香字
        System.out.println(ch);
        // 定义一个'疯'字符值
        char zhong = '疯';
        // 直接将一个char类型的变量当成int类型的变量使用
        int zhongValue = zhong;
        System.out.println(zhongValue);
        // 直接把0~65535范围内的一个int类型的整数赋给char类型的变量
        char c = 97;
        System.out.println(c);
        // 下面代码定义了一个s变量，它是一个字符串实例的引用，是一个引用类型的变量
        String s = "沧海月明珠有泪，蓝田日暖玉生烟";
        System.out.println(s);
    }
}
