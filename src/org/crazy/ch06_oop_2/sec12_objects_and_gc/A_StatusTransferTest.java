package org.crazy.ch06_oop_2.sec12_objects_and_gc;

public class A_StatusTransferTest {
    public static void test() {
        var a = new String("轻量级Java EE企业应用实战");
        a = new String("疯狂Java讲义");
    }

    public static void main(String[] args) {
        System.out.println("对象在内存中的状态:");
        System.out.println("\t可达状态\n\t可恢复状态\n\t不可达状态");
        test();
    }
}
