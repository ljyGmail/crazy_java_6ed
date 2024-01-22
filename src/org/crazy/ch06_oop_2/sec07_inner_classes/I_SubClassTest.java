package org.crazy.ch06_oop_2.sec07_inner_classes;

public class I_SubClassTest extends H_Out.In {

    public I_SubClassTest(H_Out out) {
        out.super("hello");
    }

    public static void main(String[] args) {
        System.out.println("在外部定义内部类的子类");
        new I_SubClassTest(new H_Out());
    }
}
