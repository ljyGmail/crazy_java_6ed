package org.crazy.ch07_commonly_used_classes.sec04_date_time_classes;

import java.util.Calendar;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.DATE;

public class D_LazyTest {
    public static void main(String[] args) {
        var cal = Calendar.getInstance();
        cal.set(2003, 7, 31); // 2003-8-31
        // 将月份设为9，但9月31日不存在
        // 如果立即修改，系统将会把cal自动调整到10月1日
        cal.set(MONTH, 8);
        // 下面的代码输出10月1日
        // System.out.println(cal.getTime()); // 通过注释/取消注释可以看到延迟修改的效果
        // 设置DATE字段为5
        cal.set(DATE, 5);
        System.out.println(cal.getTime());
    }
}
