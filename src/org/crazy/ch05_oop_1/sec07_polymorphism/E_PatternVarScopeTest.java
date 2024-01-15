package org.crazy.ch05_oop_1.sec07_polymorphism;

public class E_PatternVarScopeTest {
    public static void main(String[] args) {
        Object obj = "疯狂Spring Boot终极讲义";
        if (obj instanceof E_PatternVarScopeTest ps) {
            System.out.println(ps);
            // 变量ps的作用域仅到此处有效
        }

        // 变量ps到此处已不可访问，因此下面可以重新声明变量ps
        if (obj instanceof String ps) {
            System.out.println(ps.toUpperCase());
        }
    }
}
