package org.crazy.ch05_oop_1.sec07_polymorphism;

public class F_PatternVarFlowTest {
    public static void main(String[] args) {
        Object obj = "疯狂Spring Boot终极讲义";
        // &&要求两个条件都为true才返回true，当Java计算s.length() > 5时
        // 前面的条件必须为true，因此s变量必须是有效的。所以，下面的代码正确
        if (obj instanceof String s && s.length() > 5) {
            System.out.println(s.toUpperCase());
        }

        // ||只要求一个条件为true就返回true，当Java计算s.length() > 5时
        // 前面的条件必然为false，因此s变量其实并不存在。所以，下面的代码报错
        // if (obj instanceof String s || s.length() > 5) {
            // System.out.println(s.toUpperCase());
        // }

        Object obj2 = "疯狂Java讲义 ";
        // 如果obj2的类型不是String，程序抛出异常终止
        if (!(obj2 instanceof String s))
            throw new RuntimeException();
        // 此处还可以访问模式变量s
        System.out.println(s.toUpperCase());
    }
}
