package org.crazy.ch07_commonly_used_classes.sec04_date_time_classes;

import java.util.Calendar;
import static java.util.Calendar.YEAR;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.DATE;

public class B_CalendarTest {
    public static void main(String[] args) {
        var c  = Calendar.getInstance();
        // 取出年
        System.out.println(c.get(YEAR));
        // 取出月份
        System.out.println(c.get(MONTH));
        // 取出日
        System.out.println(c.get(DATE));
        // 分别设置年、月、日、小时、分钟、秒
        c.set(2003, 10, 23, 12, 32, 23); // 2003-11-23 12:32:23
        System.out.println(c.getTime());
        // 将Calendar的念前推1年
        c.add(YEAR, -1); // 2002-11-23 12:32:23
        System.out.println(c.getTime());
        // 将Calendar的月前推8个月
        c.roll(MONTH, -8); // 2002-03-23 12:32:23
        System.out.println(c.getTime());

        // 对Calendar类需要注意的部分
        // 1. add与roll的区别
        // add(int field, int amount)有如下两条规则:
        // 当被修改的字段超出它允许的范围时，会发生进位，即上一级字段也会增大:
        var cal1 = Calendar.getInstance();
        cal1.set(2003, 7, 23, 0, 0, 0); // 2003-8-23
        cal1.add(MONTH, 6);
        System.out.println("cal1: " + cal1.getTime());

        // 如果下一级字段也需要改变，那么该字段会被修正到变化最小的值:
        var cal2 = Calendar.getInstance();
        cal2.set(2003, 7, 31, 0, 0, 0); // 2003-8-31
        // 因为进位后月份改为2月，2月没有31日，自动变成29日
        cal2.add(MONTH, 6); // 2003-8-31 -> 2004-2-29
        System.out.println("cal2: " + cal2.getTime());

        // roll()的规则与add()的规则不同
        // 当被修改的字段超出它允许的范围时，上一级字段不会增大
        var cal3 = Calendar.getInstance();
        cal3.set(2003, 7, 23, 0, 0, 0); // 2003-8-23
        // MONTH字段"进位"，但YEAR字段并不增大
        cal3.roll(MONTH, 6); // 2003-8-23 -> 2003-2-23
        System.out.println("cal3: " + cal3.getTime());

        // 对下一级字段的处理与add()相似
        var cal4 = Calendar.getInstance();
        cal4.set(2003, 7, 31, 0, 0, 0); // 2003-8-31
        // MONTH字段"进位"后变成2，2月没有31日
        // YEAR字段不会改变，2003年2月只有28天
        cal4.roll(MONTH, 6);  // 2003-8-31 -> 2002-2-28
        System.out.println("cal4: " + cal4.getTime());

        // 2. 设置Calendar的容错性 -> C_LenientTest.java

        // 3. set()方法延迟修改 -> D_LazyTest.java
    }
}
