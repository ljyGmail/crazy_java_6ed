package org.crazy.ch06_oop_2.sec07_inner_classes;

public class G_AccessStaticInnerClassTest {
    static class StaticInnerClass {
        private static int prop1 = 5;
        private int prop2 = 9;
    }

    public void accessInnerProp() {
        // 下面的代码出现错误
        // System.out.println(prop1);
        // 应该改为通过类名访问静态内部类的类成员
        System.out.println(StaticInnerClass.prop1);
        // 下面的代码出现错误
        // System.out.println(prop2);
        // 应该改为通过内部类的实例访问其成员
        System.out.println(new StaticInnerClass().prop2);
    }

    public static void main(String[] args) {
        new G_AccessStaticInnerClassTest().accessInnerProp();
    }
}
