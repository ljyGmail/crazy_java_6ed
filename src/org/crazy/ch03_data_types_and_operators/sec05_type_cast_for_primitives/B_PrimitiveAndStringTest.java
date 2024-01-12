package org.crazy.ch03_data_types_and_operators.sec05_type_cast_for_primitives;

public class B_PrimitiveAndStringTest {
    public static void main(String[] args) {
        // 下面的代码是错误的，因为5是一个整数，不能被直接赋给一个字符串
        // String str1 = 5;
        // 当一个基本类型的值和字符串进行连接运算时，基本类型的值将自动转换为字符串
        String str2 = 3.5f + "";
        // 下面语句输出3.5
        System.out.println(str2);
        // 下面语句输出7Hello!
        System.out.println(3 + 4 + "Hello!");
        // 下面语句输出Hello!34，因为"Hello!" + 3会把3当成字符串处理
        // 而后再把4当成字符串处理
        System.out.println("Hello!" + 3 + 4);
    }
}
