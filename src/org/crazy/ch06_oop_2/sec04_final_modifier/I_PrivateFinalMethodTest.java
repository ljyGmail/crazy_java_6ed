package org.crazy.ch06_oop_2.sec04_final_modifier;

public class I_PrivateFinalMethodTest {
    private final void test() {}

    public static void main(String[] args) {
        System.out.println("对于父类中private final修饰的方法，子类可以定义\n具有相同方法名、"
                + "相同参数列表、相同返回值的方法");
    }
}

class I_Sub extends I_PrivateFinalMethodTest {
    // 下面的方法定义不会出现问题
    public void test() {}
}
