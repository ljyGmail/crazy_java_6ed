package org.crazy.ch06_oop_2.sec04_final_modifier;

public class L_ImmutableStringTest {
    public static void main(String[] args) {
        var str1 = new String("Hello");
        var str2 = new String("Hello");
        System.out.println(str1 == str2);  // 输出false
        System.out.println(str1.equals(str2)); // 输出true
        // 下面两次输出的hashCode相同
        System.out.println(str1.hashCode());
        System.out.println(str2.hashCode());
    }
}
