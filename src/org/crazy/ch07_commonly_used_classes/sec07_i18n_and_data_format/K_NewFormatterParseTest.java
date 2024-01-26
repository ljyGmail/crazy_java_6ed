package org.crazy.ch07_commonly_used_classes.sec07_i18n_and_data_format;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class K_NewFormatterParseTest {
    public static void main(String[] args) {
        // 定义一个任意格式的日期、时间字符串
        var str1 = "2014==04==12 01时06分09秒";
        // 根据需要解析的日期、时间字符串定义解析所用的格式器
        var formatter1 = DateTimeFormatter
            .ofPattern("yyyy==MM==dd HH时mm分ss秒");
        // 执行解析
        var dt1 = LocalDateTime.parse(str1, formatter1);
        System.out.println(dt1); // 输出2014-04-12T01:06:09
        // ---下面的代码再次解析另一个字符串---
        // var str2 = "2014$$$4月$$$13 20小时";
        // var formatter2 = DateTimeFormatter
        //     .ofPattern("yyy$$$MMM$$$dd HH小时");
        // var dt2 = LocalDateTime.parse(str2, formatter2);
        // System.out.println(dt2); // 输出 2014-04-13T20:00
    }
}
