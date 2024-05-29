package org.crazy.ch13_mysql_and_jdbc.sec06_rowset;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class B_CachedRowSetTest {
    private static String driver;
    private static String url;
    private static String user;
    private static String pass;

    public void initParam(String paramFile) throws Exception {
        // 使用Properties类来加载属性文件
        var props = new Properties();
        props.load(new FileInputStream(paramFile));
        driver = props.getProperty("driver");
        url = props.getProperty("url");
        user = props.getProperty("user");
        pass = props.getProperty("pass");
    }

    public CachedRowSet query(String sql) throws Exception {
        // 加载驱动
        Class.forName(driver);
        // 获取数据库连接
        Connection conn = DriverManager.getConnection(url, user, pass);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        // 使用RowSetProvider创建RowSetFactory
        RowSetFactory factory = RowSetProvider.newFactory();
        // 创建默认的CachedRowSet实例
        CachedRowSet cachedRs = factory.createCachedRowSet();
        // 使用Result装填RowSet
        cachedRs.populate(rs);
        rs.close();
        stmt.close();
        conn.close();
        return cachedRs;
    }

    public static void main(String[] args) throws Exception {
        var brst = new B_CachedRowSetTest();
        brst.initParam("../data/ch13_mysql_and_jdbc/mysql.ini");
        CachedRowSet rs = brst.query("select * from student_table");
        rs.afterLast();
        // 向前滚动结果集
        while (rs.previous()) {
            System.out.println(rs.getString(1)
                + "\t" + rs.getString(2)
                + "\t" + rs.getString(3));

            if (rs.getInt("student_id") == 2) {
                rs.updateString("student_name", "猪八戒");
                rs.updateRow();
            }
        }
        // 重新获取数据库连接
        Connection conn = DriverManager.getConnection(url, user, pass);
        conn.setAutoCommit(false);
        // 把对RowSet所做的修改同步到底层数据库
        rs.acceptChanges(conn);
    }
}
