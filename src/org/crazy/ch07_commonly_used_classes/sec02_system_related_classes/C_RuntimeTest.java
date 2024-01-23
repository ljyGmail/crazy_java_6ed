package org.crazy.ch07_commonly_used_classes.sec02_system_related_classes;

public class C_RuntimeTest {
    public static void main(String[] args) {
        // 获取与Java程序关联的运行时对象
        var rt = Runtime.getRuntime();
        System.out.println("处理器的数量: "
                + rt.availableProcessors());

        System.out.println("空闲内存数: "
                + rt.freeMemory());

        System.out.println("总内存数: "
                + rt.totalMemory());

        System.out.println("可用最大内存数: "
                + rt.maxMemory());
    }
}
