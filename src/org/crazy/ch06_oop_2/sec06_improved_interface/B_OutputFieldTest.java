package org.crazy.ch06_oop_2.sec06_improved_interface;

public class B_OutputFieldTest {
    public static void main(String[] args) {
        // 访问Output接口的MAX_CACHE_LINE，即使是在别的包也可以访问
        System.out.println(A_Output.MAX_CACHE_LINE);
        // 下面的语句将引发"为final变量赋值"的编译异常
        // A_Output.MAX_CACHE_LINE = 20;
        // 使用接口来调用类方法
        System.out.println(A_Output.staticTest());
    }
}
