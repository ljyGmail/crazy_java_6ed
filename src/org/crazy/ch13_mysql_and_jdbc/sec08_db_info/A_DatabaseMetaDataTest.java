package org.crazy.ch13_mysql_and_jdbc.sec08_db_info;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Properties;

public class A_DatabaseMetaDataTest {
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

    public void info() throws Exception {
        // 加载驱动
        Class.forName(driver);
        try (
            // 获取数据库连接
            Connection conn = DriverManager.getConnection(url, user, pass))
        {
            // 获取DatabaseMetaData对象
            DatabaseMetaData dbmd = conn.getMetaData();
            // 获取MySQL支持的所有表类型
            ResultSet rs = dbmd.getTableTypes();
            System.out.println("--MySQL支持的表类型信息--");
            printResultSet(rs);

            // 获取当前数据库的全部数据表
            rs = dbmd.getTables("ssardb", null, "%", new String[] {"TABLE"});
            System.out.println("--当前数据库里的数据表信息--");
            printResultSet(rs);

            // 获取student_table表的主键
            rs = dbmd.getPrimaryKeys("ssardb", null, "student_table");
            System.out.println("--student_table表的主键信息--");
            printResultSet(rs);

            // 获取当前数据库的全部存储过程
            rs = dbmd.getProcedures("ssardb", null, "%");
            System.out.println("--当前数据库里的存储过程信息--");
            printResultSet(rs);

            // 获取teacher_table表和student_table表之间的外键约束
            rs = dbmd.getCrossReference("ssardb", null, "teacher_table",
                null, null, "student_table");
            System.out.println("--teacher_table表和student_table表之间的外键约束--");
            printResultSet(rs);

            // 获取student_table表的全部数据列
            rs = dbmd.getColumns("ssardb", null, "student_table", "%");
            System.out.println("--student_table表的全部数据列--");
            printResultSet(rs);
        }
    }

    public void printResultSet(ResultSet rs) throws SQLException {
        ResultSetMetaData rsmd = rs.getMetaData();
        // 打印ResultSet的所有列标题
        for (var i = 0; i < rsmd.getColumnCount(); i++) {
            System.out.print(rsmd.getColumnName(i + 1) + "\t");
        }
        System.out.println();

        // 打印ResultSet里的全部数据
        while (rs.next()) {
            for (var i = 0; i < rsmd.getColumnCount(); i++) {
                System.out.print(rs.getString(i + 1) + "\t");
            }
            System.out.println();
        }
        rs.close();
    }

    public static void main(String[] args) throws Exception {
        var dt = new A_DatabaseMetaDataTest();
        dt.initParam("../data/ch13_mysql_and_jdbc/mysql.ini");
        dt.info();
    }
}
