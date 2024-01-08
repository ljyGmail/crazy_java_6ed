package org.crazy.ch03_data_types_and_operators.sec06_literal;

public class A_LiteralTest {
    public static void main(String[] args) {
        var a = 5;
        var c = 'a';
        var b = true;
        var f = 5.12f;
        var d = 4.12;
        var author = "李刚";
        var book = "疯狂Android讲义";

        var s0 = "hello";
        var s1 = "hello";
        var s2 = "he" + "llo";

        System.out.println(s0 == s1);
        System.out.println(s0 == s2);
    }
}
