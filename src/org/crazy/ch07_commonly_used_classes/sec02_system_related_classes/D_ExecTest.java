package org.crazy.ch07_commonly_used_classes.sec02_system_related_classes;

public class D_ExecTest {
    public static void main(String[] args) 
        throws Exception {
        var rt = Runtime.getRuntime();
        // 运行文件浏览窗口
        String osName = System.getProperty("os.name").toLowerCase();

        if (osName.contains("mac")) {
            rt.exec("open .");
        } else if (osName.contains("windows")) {
            rt.exec("explorer .");
        } else {
            System.out.println("该操作系统不是Windows或Mac OS");
        }
    }
}
