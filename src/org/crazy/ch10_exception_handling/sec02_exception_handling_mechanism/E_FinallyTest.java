package org.crazy.ch10_exception_handling.sec02_exception_handling_mechanism;

import java.io.FileInputStream;
import java.io.IOException;

public class E_FinallyTest {
    public static void main(String[] args) {
        FileInputStream fis = null;

        try {
            fis = new FileInputStream("noexist.txt");
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
            // return语句强制方法返回
            // return;
            // 使用exit退出虚拟机
            System.exit(1);
        } finally {
            // 关闭磁盘文件，回收资源
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
            System.out.println("执行finally块里的资源回收");
        }
    }
}
