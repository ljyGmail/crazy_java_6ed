package org.crazy.ch07_commonly_used_classes.sec07_i18n_and_data_format;

import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import java.text.MessageFormat;

public class C_HelloArgTest {
    public static void main(String[] args) {
        // 定义一个Locale变量
        Locale currentLocale = null;
        // 如果运行程序指定了两个参数
        if (args.length == 2) {
            // 则使用运行程序的两个参数构造Locale实例
            currentLocale = new Locale(args[0], args[1]);
        } else {
            // 否则直接使用系统默认的Locale
            currentLocale = Locale.getDefault(Locale.Category.FORMAT);
        }

        // 根据Locale加载语言资源文件
        var bundle = ResourceBundle.getBundle("myMess", currentLocale);
        // 获得已加载的语句资源文件中msg对应的消息
        var msg = bundle.getString("msg");
        // 使用MessageFormat为带占位符的字符串传入参数
        System.out.println(MessageFormat.format(msg,
                "Zhou Huajian", new Date()));
    }
}
