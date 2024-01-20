package org.crazy.ch06_oop_2.sec06_improved_interface;

public class E_Computer {
    private A_Output out;

    public E_Computer(A_Output out) {
        this.out = out;
    }

    // 定义一个模拟获取字符串输入的方法
    public void keyIn(String msg) {
        out.getData(msg);
    }

    // 定义 一个模拟打印的方法
    public void print() {
        out.out();
    }
}
