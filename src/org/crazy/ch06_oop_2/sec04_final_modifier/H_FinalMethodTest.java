package org.crazy.ch06_oop_2.sec04_final_modifier;

public class H_FinalMethodTest {
    public final void test() {}

    public static void main(String[] args) {
        System.out.println("不能重写父类中被final修饰的方法");
    }
}

class H_Sub extends H_FinalMethodTest {
    // 下面的方法定义将出现编译错误，不能重写final方法
    // public void test() {}
}
