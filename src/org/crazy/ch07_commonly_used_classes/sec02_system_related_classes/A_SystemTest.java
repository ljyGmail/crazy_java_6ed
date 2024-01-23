package org.crazy.ch07_commonly_used_classes.sec02_system_related_classes;

import java.util.Map;
import java.util.Properties;
import java.io.FileOutputStream;

public class A_SystemTest {
    public static void main(String[] args) throws Exception {
        // 输出操作系统的字符集
        System.out.println(System.getProperty("native.encoding"));

        // 获取系统所有的环境变量
        Map<String, String> env = System.getenv();
        for (var name : env.keySet()) {
            System.out.println(name + " -----> " + env.get(name));
        }

        // 获取指定环境变量的值
        System.out.println("JAVA_HOME: " + System.getenv("JAVA_HOME"));

        // 获取所有的系统属性
        Properties props = System.getProperties();

        // 将所有的系统属性保存到props.txt文件中
        props.store(new FileOutputStream("../data/ch07_commonly_used_classes/props.txt"),
                "System Properties");

        // 输出特定的系统属性
        System.out.println("os.name: " + System.getProperty("os.name"));
    }
}
