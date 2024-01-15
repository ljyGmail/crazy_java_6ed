package org.crazy.ch05_oop_1.sec07_polymorphism;

public class D_InstanceofMatchTest {
    public static void main(String[] args) {
        Object obj = "疯狂Spring Boot终极讲义";
        // 传统instanceof的用法: 先判断类型，再做类型转换
        if (obj instanceof String) {
            String s = (String) obj;
            System.out.println(s.toUpperCase());
        }

        // 模式匹配的instanceof，同时进行类型判断和类型转换
        if (obj instanceof String s) {
            System.out.println(s.toUpperCase());
        }
    }
}
