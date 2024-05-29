package org.crazy.ch13_mysql_and_jdbc.sec07_tranaction;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class B_BatchTest {
    private String driver;
    private String url;
    private String user;
    private String pass;

    public void initParam(String paramFile) throws Exception {
        // 使用Properties来加载属性文件
        var props = new Properties();
        props.load(new FileInputStream(paramFile));
        driver = props.getProperty("driver");
        url = props.getProperty("url");
        user = props.getProperty("user");
        pass = props.getProperty("pass");
    }

    public void insertBatch(String[] sqls) throws Exception {
        // 加载驱动
        Class.forName(driver);
        try (
            Connection conn = DriverManager.getConnection(url, user, pass))
        {
            // 保存当前的自动提交模式
            boolean autoCommit = conn.getAutoCommit();
            // 关闭自动提交，开启事务
            conn.setAutoCommit(false);
            try (
                // 使用Connection来创建一个Statement对象
                Statement stmt = conn.createStatement())
            {
                // 循环多次执行SQL语句
                for (var sql : sqls) {
                    stmt.addBatch(sql);
                }
                // 同时提交所有的SQL语句
                stmt.executeLargeBatch();
                // 提交修改
                conn.commit();
                // 恢复原有的自动提交模式
                conn.setAutoCommit(autoCommit);
            }
            // 提交事务
            // conn.commit(); // 书中有此行代码，带实际执行时会报错
        }
    }

    public static void main(String[] args) throws Exception {
        var  bt = new B_BatchTest();
        bt.initParam("../data/ch13_mysql_and_jdbc/mysql.ini");
        var sqls = new String[] {
            "insert into student_table values(null, 'ddd', 1)"
            , "insert into student_table values(null, 'eee', 1)"
            , "insert into student_table values(null, 'fff', 1)"
        };
        bt.insertBatch(sqls);
    }
}
