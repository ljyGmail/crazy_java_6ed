package org.crazy.ch05_oop_1.sec09_initialization_block;

public class D_StaticInitTest {
    // 先执行类初始化块将a类变量赋值为6
    static {
        a = 6;
    }

    // 再将a类变量赋值为9
    static int a = 9;

    public static void main(String[] args) {
        // 下面的代码将输出9
        System.out.println(D_StaticInitTest.a);
    }
}
