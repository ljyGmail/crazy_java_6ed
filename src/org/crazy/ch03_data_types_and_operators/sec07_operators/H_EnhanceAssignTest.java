package org.crazy.ch03_data_types_and_operators.sec07_operators;

public class H_EnhanceAssignTest {
    public static void main(String[] args) {
        // 定义一个byte类型的变量
        byte a = 5;
        // 下面的语句出错，因为5默认是int类型，a + 5就是int类型
        // 把int类型的值赋给byte类型的变量，所以会出错
        // a = a + 5;
        // 定义一个byte类型的变量
        byte b = 5;
        // 下面的语句不会出现错误
        b += 5;
        System.out.println(b);
    }
}
