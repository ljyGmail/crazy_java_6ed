package org.crazy.ch07_commonly_used_classes.sec07_i18n_and_data_format;

import java.util.Locale;
import java.util.ResourceBundle;

public class B_HelloTest {
    public static void main(String[] args) {
        // 获得系统默认的国家/语言环境
        var myLocale = Locale.getDefault(Locale.Category.FORMAT);
        // 根据指定的国家/语言环境加载资源文件
        var bundle = ResourceBundle.getBundle("mess", myLocale);
        // 打印从资源文件中获得的消息
        System.out.println(bundle.getString("hello"));
    }
}
