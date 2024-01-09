package org.crazy.ch03_data_types_and_operators.sec07_operators;

public class K_TernaryTest {
    public static void main(String[] args) {
        String str = 5 > 3 ? "5大于3" : "5不大于3";
        System.out.println(str);

        // 大部分时候，三目运算符都作为if else的精简写法:
        String str2 = null;
        if (5 > 3) {
            str2 = "5大于3";
        } else {
            str2 = "5不大于3";
        }
        System.out.println(str2);

        // 三目运算符可以嵌套
        var a = 11;
        var b = 12;
        System.out.println(a > b ? 
                "a大于b" : (a < b ? "a小于b" : "a等于b"));
    }
}
