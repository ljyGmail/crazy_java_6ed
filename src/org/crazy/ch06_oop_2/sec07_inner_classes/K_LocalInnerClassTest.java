package org.crazy.ch06_oop_2.sec07_inner_classes;

public class K_LocalInnerClassTest {
    public static void main(String[] args) {
        // 定义局部内部类
        class InnerBase {
            int a;
        }

        // 定义局部内部类的子类
        class InnerSub extends InnerBase {
            int b;
        }

        // 创建局部内部类的对象
        var is = new InnerSub();
        is.a = 5;
        is.b = 8;
        System.out.println("InnerSub对象a和b实例变量是: "
                + is.a + ", " + is.b);
    }
}
