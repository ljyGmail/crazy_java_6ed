package org.crazy.ch06_oop_2.sec10_sealed_classes;

sealed class K_Shape permits K_Triangle, K_Rectangle {}

final class  K_Triangle extends K_Shape {
    public void info() {
        System.out.println("三角形");
    }
}

final class K_Rectangle extends K_Shape {
    public void area() {
        System.out.println("面积等于长乘以宽");
    }
}

public class K_SealedSwitchTest {

    public static void test(K_Shape s) {
        /*
        // 对Shape执行模式匹配
        switch (s) {
            // 使用case可以覆盖所有可能的Shape类型及其后代类
            // 因此可以不需要defalut分支
            case K_Rectangle rect -> rect.area();
            case K_Triangle tri -> tri.info();
            case K_Shape shape -> System.out.println("通用Shape");
        }
        */
    }

    public static void main(String[] args) {
        /*
        test(new K_Triangle());
        test(new K_Rectangle());
        */
        System.out.println("该类需要使用enable-preview选项编译并运行");
    }
}
