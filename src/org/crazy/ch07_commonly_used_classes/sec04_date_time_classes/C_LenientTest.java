package org.crazy.ch07_commonly_used_classes.sec04_date_time_classes;

import java.util.Calendar;
import static java.util.Calendar.MONTH;

public class C_LenientTest {
    public static void main(String[] args) {
        var cal = Calendar.getInstance();
        // 结果是YEAR字段加1，MONTH字段为1 (2月)
        cal.set(MONTH, 13);
        System.out.println(cal.getTime());

        // 关闭容错性
        cal.setLenient(false);
        // 导致运行时异常
        cal.set(MONTH, 13); // 此行代码不会抛出异常，因为set()方法延迟修改
        // System.out.println(cal.getTime());
    }
}
