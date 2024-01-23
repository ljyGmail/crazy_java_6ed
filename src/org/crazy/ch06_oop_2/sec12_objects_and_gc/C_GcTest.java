package org.crazy.ch06_oop_2.sec12_objects_and_gc;

public class C_GcTest {
    public static void main(String[] args) {
        for (var i = 0; i < 4; i++) {
            new C_GcTest();
            // 下面两行代码的作用完全相同，强制系统进行垃圾回收
            // System.gc();
            // System.out.println("i=" + i);
            Runtime.getRuntime().gc();
        }
    }

    public void finalize() {
        System.out.println("系统正在清理GcTest对象的资源...");
    }
}
