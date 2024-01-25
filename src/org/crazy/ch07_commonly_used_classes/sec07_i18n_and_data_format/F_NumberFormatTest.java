package org.crazy.ch07_commonly_used_classes.sec07_i18n_and_data_format;

import java.util.Locale;
import java.text.NumberFormat;

public class F_NumberFormatTest {
    public static void main(String[] args) {
        // 需要被格式化的数值
        var db = 1234000.567;
        // 创建5个Locale，分别代表中国、日本、德国、美国、韩国
        Locale[] locales = {Locale.CHINA, Locale.JAPAN,
            Locale.GERMAN, Locale.US, Locale.KOREA};

        var nf = new NumberFormat[4 * locales.length];
        // 为上面的5个Locale创建20个NumberFormat对象
        // 每个Locale分别有通用数值的数值格式器、百分比格式器、货币格式器、紧凑格式器
        for (var i = 0; i < locales.length; i++) {
            nf[i * 4] = NumberFormat.getNumberInstance(locales[i]);
            nf[i * 4 + 1] = NumberFormat.getPercentInstance(locales[i]);
            nf[i * 4 + 2] = NumberFormat.getCurrencyInstance(locales[i]);
            nf[i * 4 + 3] = NumberFormat.getCompactNumberInstance(locales[i],
                    NumberFormat.Style.SHORT);
        }

        for (var i = 0; i < locales.length; i++) {
            var tip = i == 0 ? "----中国的格式----" :
                i == 1 ? "----日本的格式----" :
                i == 2 ? "----德国的格式----" :
                i == 3 ? "----美国的格式----" : "----韩国的格式----";

            System.out.println(tip);
            System.out.println("通用数值格式: " + nf[i * 4].format(db));
            System.out.println("百分比数值格式: " + nf[i * 4 + 1].format(db));
            System.out.println("货币数值格式: " + nf[i * 4 + 2].format(db));
            System.out.println("紧凑数值格式: " + nf[i * 4 + 3].format(db));
        }
    }
}
