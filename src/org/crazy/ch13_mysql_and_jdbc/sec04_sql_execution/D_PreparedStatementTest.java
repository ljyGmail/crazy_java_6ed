package org.crazy.ch13_mysql_and_jdbc.sec04_sql_execution;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Properties;

public class D_PreparedStatementTest {
    private String driver;
    private String url;
    private String user;
    private String pass;

    public void initParam(String paramFile) throws Exception {
        // 使用Properties类来加载属性文件
        var props = new Properties();
        props.load(new FileInputStream(paramFile));
        driver = props.getProperty("driver");
        url = props.getProperty("url");
        user = props.getProperty("user");
        pass = props.getProperty("pass");
    }

    public void insertUserStatement() throws Exception {
        long start = System.currentTimeMillis();
        try (
            // 获取数据库连接
            Connection conn = DriverManager.getConnection(url, user, pass);
            // 使用Connection来创建一个Statement对象
            Statement stmt = conn.createStatement())
        {
            // 需要使用100条SQL语句来插入100条记录
            for (var i = 0; i < 100; i++) {
                stmt.executeLargeUpdate("insert into student_table values("
                        + " null, '姓名" + i + "', 1)");
            }

            System.out.println("使用Statement费时: "
                    + (System.currentTimeMillis() - start));
        }
    }

    public void insertUserPrepare() throws Exception {
        long start = System.currentTimeMillis();
        try (
            // 获取数据库连接
            Connection conn = DriverManager.getConnection(url, user, pass);
            // 使用Connection来创建一个PreparedStatement对象
            PreparedStatement pstmt = conn.prepareStatement(
                "insert into student_table values(null, ?, 1)"))
        {
            // 为PreparedStatement的参数设值100次，就可以输入100条记录
            for (var i = 0; i < 100; i++) {
                pstmt.setString(1, "姓名" + i);
                pstmt.executeLargeUpdate();
            }

            System.out.println("使用PreparedStatement费时: "
                    + (System.currentTimeMillis() - start));
        }
    }

    public static void main(String[] args) throws Exception {
        var pt = new D_PreparedStatementTest();
        pt.initParam("../data/ch13_mysql_and_jdbc/mysql.ini");
        pt.insertUserStatement();
        pt.insertUserPrepare();
    }
}
