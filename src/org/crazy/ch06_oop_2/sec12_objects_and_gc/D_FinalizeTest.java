package org.crazy.ch06_oop_2.sec12_objects_and_gc;

public class D_FinalizeTest {
    private static D_FinalizeTest ft = null;

    public void info() {
        System.out.println("测试资源清理的finalize方法");
    }

    public static void main(String[] args) {
        // 创建FinalizeTest对象，它立即进入可恢复状态
        new D_FinalizeTest();
        // 通知系统进行资源回收
        System.gc();
        // 强制立即回收机制调用可恢复的finalize()方法
        // Runtime.getRuntime().runFinalization();
        System.runFinalization();
        ft.info();
    }

    public void finalize() {
        // 让ft引用到试图回收的可恢复对象，即可恢复对象重新变成可达状态
        ft = this;
    }
}
