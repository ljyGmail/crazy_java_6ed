package org.crazy.ch06_oop_2.sec07_inner_classes;

class J_StaticOut {
    // 定义一个静态内部类，不使用访问控制修饰符
    // 即同一个包中的其他类可访问该内部类
    static class StaticIn {
        public StaticIn() {
            System.out.println("静态内部类的构造器");
        }
    }
}

public class J_CreateStaticInnerClassInstanceTest {
    public static void main(String[] args) {
        J_StaticOut.StaticIn in = new J_StaticOut.StaticIn();
        // 上面的代码可被改为如下两行代码
        // 使用OuterClass.InnerClass的形式定义内部类变量
        J_StaticOut.StaticIn in2;
        // 通过new调用内部类的构造器来创建静态内部类实例
        in2 = new J_StaticOut.StaticIn();
    }
}
