package org.crazy.ch05_oop_1.sec04_info_hide_and_encapsulation;

import static java.lang.System.*;
import static java.lang.Math.*;

public class F_StaticImportTest {
    public static void main(String[] args) {
        // out是java.lang.System类的静态成员变量，代表标准输出
        // PI是java.lang.Math类的静态成员变量，表示pai常量
        out.println(PI);
        // 直接调用Math类的sqrt静态方法
        out.println(sqrt(256));
    }
}
