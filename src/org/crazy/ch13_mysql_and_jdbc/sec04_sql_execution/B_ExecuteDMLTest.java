package org.crazy.ch13_mysql_and_jdbc.sec04_sql_execution;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class B_ExecuteDMLTest {
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
        System.out.println(driver);
    }

    public long insertData(String sql) throws Exception {
        // 加载驱动
        Class.forName(driver);
        try (
                // 获取数据库连接
                Connection conn = DriverManager.getConnection(url, user, pass);
                // 使用Connection来创建一个Statement对象
                Statement stmt = conn.createStatement())
        {
            // 执行DML语句，返回受影响的记录条数
            return stmt.executeLargeUpdate(sql);
        }
    }

    public static void main(String[] args) throws Exception {
        var ed = new B_ExecuteDMLTest();
        ed.initParam("../data/ch13_mysql_and_jdbc/mysql.ini");
        var result = ed.insertData("insert into jdbc_test (jdbc_name, jdbc_desc)"
                + "select s.student_name, t.teacher_name "
                + "from student_table s, teacher_table t "
                + "where s.java_teacher = t.teacher_id;");
        System.out.println("--系统中共有" + result + "条记录受影响--");
    }
}
