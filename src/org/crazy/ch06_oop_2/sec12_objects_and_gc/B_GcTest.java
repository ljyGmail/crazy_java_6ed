package org.crazy.ch06_oop_2.sec12_objects_and_gc;

public class B_GcTest {
    public static void main(String[] args) {
        for (var i = 0; i < 4; i++) {
            new B_GcTest();
            System.out.println("i=" + i);
        }
    }

    public void finalize() {
        System.out.println("系统正在清理GcTest对象的资源...");
    }
}
