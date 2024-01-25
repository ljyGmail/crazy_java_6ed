package org.crazy.ch07_commonly_used_classes.sec07_i18n_and_data_format;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class E_LoggerI18NTest {
    public static void main(String[] args) throws Exception {
        // 加载国际化资源包
        var resourceBundle = ResourceBundle.getBundle("logMess",
                Locale.getDefault(Locale.Category.FORMAT));
        // 获取System.Logger对象
        var logger = System.getLogger("fkjava", resourceBundle);
        // 设置系统日志级别
        Logger.getLogger("fkjava").setLevel(Level.INFO);
        // 设置使用a.xml保存日志记录
        Logger.getLogger("fkjava").addHandler(new FileHandler("b.xml"));
        // 下面三个方法的第二个参数是国际化消息key
        logger.log(System.Logger.Level.DEBUG, "debug");
        logger.log(System.Logger.Level.INFO, "info");
        logger.log(System.Logger.Level.ERROR, "error");
    }
}
