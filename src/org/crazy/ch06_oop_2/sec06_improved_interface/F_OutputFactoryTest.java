package org.crazy.ch06_oop_2.sec06_improved_interface;

public class F_OutputFactoryTest {

    public A_Output getOutput() {
        // return new D_PrinterTest();
        // 只要改成如下代码，即可实现使用BetterPrinter对象，而不再是Printer对象
        return new G_BetterPrinter();
    }

    public static void main(String[] args) {
        var of = new F_OutputFactoryTest();
        var c = new E_Computer(of.getOutput());
        c.keyIn("轻量级Java EE企业应用实战");
        c.keyIn("疯狂Java讲义");
        c.print();
    }
}
