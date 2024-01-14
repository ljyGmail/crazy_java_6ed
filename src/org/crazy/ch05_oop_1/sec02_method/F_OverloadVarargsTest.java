package org.crazy.ch05_oop_1.sec02_method;

public class F_OverloadVarargsTest {
    public void test(String msg) {
        System.out.println("只有一个字符串参数的test方法");
    }

    // 因为前面已经有了一个test()方法，在test()方法中有一个字符串参数
    // 此处个数可变的形参中不包含一个字符串参数的形式
    public void test(String... books) {
        System.out.println("*****形参 个数可变的test方法");
    }

    public static void main(String[] args) {
        var olv = new F_OverloadVarargsTest();
        // 下面的两次调用将执行第二个test()方法
        olv.test();
        olv.test("aa", "b");
        // 下面的调用将执行第一个test()方法
        olv.test("aa");
        // 下面的调用将执行第二个test()方法
        olv.test(new  String[] {"aa"});
    }
}
