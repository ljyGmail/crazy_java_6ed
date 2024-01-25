package org.crazy.ch07_commonly_used_classes.sec07_i18n_and_data_format;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class I_SimpleDateFormatTest {
    public static void main(String[] args)
        throws ParseException {
        var d = new Date();
        // 创建一个SimpleDateFormat对象
        var sdf1 = new SimpleDateFormat("Gyyyy年中第D天");
        // 将d格式化成日期，输出、公元2017年中第#天
        var dateStr = sdf1.format(d);
        System.out.println(dateStr);
        // 一个非常特殊的日期字符串
        var str = "14###3월##21";
        var sdf2 = new SimpleDateFormat("y###MMM##d");
        // 将日期字符串解析成日期，输出Fri Mar 21 00:00:00 KST 2014
        System.out.println(sdf2.parse(str));
    }
}
