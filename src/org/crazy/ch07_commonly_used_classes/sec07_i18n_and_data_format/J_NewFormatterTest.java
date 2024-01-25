package org.crazy.ch07_commonly_used_classes.sec07_i18n_and_data_format;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class J_NewFormatterTest {
    public static void main(String[] args) {
        var formatters = new DateTimeFormatter[] {
            // 直接使用常量创建DateTimeFormatter格式器
            DateTimeFormatter.ISO_LOCAL_DATE,
            DateTimeFormatter.ISO_LOCAL_TIME,
            DateTimeFormatter.ISO_LOCAL_DATE_TIME,
            // 使用本地化的不同风格来创建DateTimeFormatter格式器
            DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM),
            DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG),
            // 根据模式字符串来创建DateTimeFormatter格式器
            DateTimeFormatter.ofPattern("Gyyyy%%MM%%dd B HH:mm:ss")
        };

        var date = LocalDateTime.now();

        // 依次使用不同的格式器对LocalDateTime进行格式化
        for (var i = 0; i < formatters.length; i++) {
            // 下面两行代码的作用相同
            System.out.println(date.format(formatters[i]));
            System.out.println(formatters[i].format(date));
        }
    }
}
