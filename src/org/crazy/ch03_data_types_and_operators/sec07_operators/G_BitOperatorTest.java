package org.crazy.ch03_data_types_and_operators.sec07_operators;

public class G_BitOperatorTest {
    public static void main(String[] args) {
        System.out.println(5 & 9); // 将输出1
        System.out.println(5 | 9); // 将输出13

        System.out.println(~-5); // 将输出4
        System.out.println(5 ^ 9); // 将输出12

        System.out.println(5 << 2); // 输出20
        System.out.println(-5 << 2); // 输出-20

        System.out.println(-5 >> 2); // 输出-2
        System.out.println(-5 >>> 2); // 输出1073741822
    }
}
