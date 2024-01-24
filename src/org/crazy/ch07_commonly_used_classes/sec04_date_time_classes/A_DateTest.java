package org.crazy.ch07_commonly_used_classes.sec04_date_time_classes;

import java.util.Date;

public class A_DateTest {
    public static void main(String[] args) {
        var d1 = new Date();
        // 获取当前时间之后100ms的时间
        var d2 = new Date(System.currentTimeMillis() + 100);
        System.out.println(d2);
        System.out.println(d1.compareTo(d2));
        System.out.println(d1.before(d2));
    }
}
