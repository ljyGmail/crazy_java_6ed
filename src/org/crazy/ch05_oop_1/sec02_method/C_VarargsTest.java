package org.crazy.ch05_oop_1.sec02_method;

public class C_VarargsTest {
    // 定义了形参个数可变的方法
    public static void test(int a, String... books) {
        // books被当成数组处理
        for (var tmp : books) {
            System.out.println(tmp);
        }
        // 输出整数变量a的值
        System.out.println(a);
    }

    public static void main(String[] args) {
        // 调用test方法
        test(5, "疯狂Java讲义", "轻量级Java EE企业应用实战");

        // 定义test方法时传入一个数组
        test(23, new String[] {"疯狂Java讲义", "轻量级Java EE企业应用实战"});
    }
}
