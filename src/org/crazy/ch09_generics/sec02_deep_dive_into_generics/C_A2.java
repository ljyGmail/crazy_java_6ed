package org.crazy.ch09_generics.sec02_deep_dive_into_generics;

public class C_A2 extends A_AppleTest {
    // 重写父类的方法
    public String getInfo() {
        return super.getInfo().toString();
    }
}
