package org.crazy.ch06_oop_2.sec10_sealed_classes;

// 定义密封接口
sealed interface J_Celestial {
    void fly();
}

// 密封接口的子接口，只能用sealed或non-sealed修饰
non-sealed interface J_Artificial extends J_Celestial {}

non-sealed class J_Star implements J_Celestial {
    public void fly() {
        System.out.println("恒星在星系内转动");
    }
}

final class J_Planet implements J_Celestial {
    public void fly() {
        System.out.println("行星绕恒星转动");
    }
}
