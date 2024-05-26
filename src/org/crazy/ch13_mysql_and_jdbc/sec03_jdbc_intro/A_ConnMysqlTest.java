package org.crazy.ch13_mysql_and_jdbc.sec03_jdbc_intro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class A_ConnMysqlTest {
    public static void main(String[] args) throws Exception {
        // 1. 加载驱动，使用反射知识，现在记住这么写
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (
            // 2. 使用DriverManager获取数据库连接
            // 其中返回的Connection就代表了Java程序和数据库的连接
            // 不同数据库的URL写法需要查看驱动文档，用户名、密码由DBA分配
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3307/ssardb?useSSL=false&serverTimezone=UTC",
                "ssar", "ssar1234");
            // 3. 使用Connection来创建一个Statement对象
            Statement stmt = conn.createStatement();
            // 4. 执行SQL语句
            /*
            Statement有三种执行SQL语句的方法:
            1. execute()可执行任何SQL语句 - 返回一个boolean值
                如果执行后第一个结果是ResultSet，则返回true，否则返回false
            2. executeQuery()执行select语句 - 返回查询到的结果集
            3. executeUpdate()或executeLargeUpdate()用于执行DML语句 - 返回一个整数
                代表被SQL语句影响的记录条数
            */
            ResultSet rs = stmt.executeQuery("select s.*, teacher_name"
                + " from student_table s, teacher_table t"
                + " where t.teacher_id = s.java_teacher")) {
            while (rs.next()) {
                // ResultSet有一系列getXXX(列索引| 列名)方法，用于获取记录指针
                // 指向行、特定列的值，不断地使用next()将记录指针下移一行
                // 如果移动之后记录指针依然指向有效行，则next()方法返回true
                System.out.println(rs.getInt(1) + "\t"
                    + rs.getString(2) + "\t"
                    + rs.getString(3) + "\t"
                    + rs.getString(4));
            }
        }
    }
}
