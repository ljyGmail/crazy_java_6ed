package org.crazy.ch07_commonly_used_classes.sec02_system_related_classes;

import java.util.concurrent.CompletableFuture;

public class E_ProcessHandleTest {
    public static void main(String[] args)
        throws Exception {
        var rt = Runtime.getRuntime();
        // 运行记事本程序 (Windows)
        String osName = System.getProperty("os.name").toLowerCase();

        if (osName.contains("windows")) {
            Process p = rt.exec("notepad.exe");
            ProcessHandle ph = p.toHandle();
            System.out.println("进程是否运行: " + ph.isAlive());
            System.out.println("进程ID: " + ph.pid());
            System.out.println("父进程: " + ph.parent());
            // 获取ProcessHandle.Info信息
            ProcessHandle.Info info = ph.info();
            // 通过ProcessHandle.Info信息获取进程相关信息
            System.out.println("进程命令: " + info.command());
            System.out.println("进程参数: " + info.arguments());
            System.out.println("进程启动时间: " + info.startInstant());
            System.out.println("进程累计运行时间: " + info.totalCpuDuration());
            // 通过CompletableFuture在进程结束时运行某个任务
            CompletableFuture<ProcessHandle> cf = ph.onExit();
            cf.thenRunAsync(() -> {
                System.out.println("程序退出");
            });
            Thread.sleep(5000);
        } else {
            System.out.println("该程序需要在Windows中运行");
        }
    }
}
