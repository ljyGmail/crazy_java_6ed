package org.crazy.ch07_commonly_used_classes.sec07_i18n_and_data_format;

import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.Level;

public class D_LoggerTest {
    public static void main(String[] args) throws Exception {
        // 获取System.Logger对象
        var logger = System.getLogger("fkjava");
        // 设置系统日志级别(FINE对应于DEBUG)
        Logger.getLogger("fkjava").setLevel(Level.FINE);
        // 设置使用a.xml保存日志记录
        Logger.getLogger("fkjava").addHandler(new FileHandler("a.xml"));
        logger.log(System.Logger.Level.DEBUG, "debug信息");
        logger.log(System.Logger.Level.INFO, "info信息");
        logger.log(System.Logger.Level.ERROR, "error信息");
    }
}
