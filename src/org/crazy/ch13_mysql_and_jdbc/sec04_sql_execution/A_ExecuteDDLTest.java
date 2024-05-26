package org.crazy.ch13_mysql_and_jdbc.sec04_sql_execution;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class A_ExecuteDDLTest {

    private String driver;
    private String url;
    private String user;
    private String pass;

    public void initParam(String paramFile)
        throws Exception {
        // 使用Properties类来加载属性文件
        var props = new Properties();
        props.load(new FileInputStream(paramFile));
        driver = props.getProperty("driver");
        url = props.getProperty("url");
        user = props.getProperty("user");
        pass = props.getProperty("pass");
    }

    public void createTable(String sql) throws Exception {
        // 加载驱动
        Class.forName(driver);
        try (
            // 获取数据库连接
            Connection conn = DriverManager.getConnection(url, user, pass);
            // 使用Connection来创建一个Statement对象
            Statement stmt = conn.createStatement())
        {
            // 执行DDL语句，创建数据表
            stmt.executeLargeUpdate(sql);
        }
    }

    public static void main(String[] args) throws Exception {
        var ed = new A_ExecuteDDLTest();
        ed.initParam("../data/ch13_mysql_and_jdbc/mysql.ini");
        ed.createTable("create table jdbc_test "
                + "(jdbc_id int auto_increment primary key, "
                + "jdbc_name varchar(255), "
                + "jdbc_desc text);");
        System.out.println("-----建表成功-----");
    }
}
