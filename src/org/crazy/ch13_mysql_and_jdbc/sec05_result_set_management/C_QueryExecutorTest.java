package org.crazy.ch13_mysql_and_jdbc.sec05_result_set_management;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Properties;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class C_QueryExecutorTest {

    JFrame jf = new JFrame("查询执行器");
    private JScrollPane scrollPane;
    private JButton execBn = new JButton("查询");
    // 用于输入查询语句的文本框
    private JTextField sqlField = new JTextField(45);

    private static Connection conn;
    private static Statement stmt;

    // 采用静态初始化块来初始化Connection, Statement
    static {
        try {
            var props = new Properties();
            props.load(new FileInputStream("../data/ch13_mysql_and_jdbc/mysql.ini"));
            String driver = props.getProperty("driver");
            String url = props.getProperty("url");
            String username = props.getProperty("user");
            String password = props.getProperty("pass");
            // 加载数据库驱动
            Class.forName(driver);
            // 取得数据库连接
            conn = DriverManager.getConnection(url, username, password);
            stmt = conn.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ----------初始化界面的方法----------
    public void init() {
        var top = new JPanel();
        top.add(new JLabel("输入查询语句: "));
        top.add(sqlField);
        top.add(execBn);

        // 为执行按钮、单行文本框添加事件监听器
        execBn.addActionListener(new ExecListener());
        sqlField.addActionListener(new ExecListener());
        jf.add(top, BorderLayout.NORTH);
        jf.setSize(780, 480);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }

    // 定义监听器
    class ExecListener implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
            // 删除原来的JTable (JTable使用scrollPane来包装)
            if (scrollPane != null) {
                jf.remove(scrollPane);
            }

            try (
                // 根据用户输入的SQL语句执行查询
                ResultSet rs = stmt.executeQuery(sqlField.getText()))
            {
                // 取出ResultSet的MetaData
                ResultSetMetaData rsmd = rs.getMetaData();
                Vector<String> columnNames = new Vector<>();
                Vector<Vector<String>> data = new Vector<>();
                // 把ResultSet中的所有列名添加到Vector里
                for (var i = 0; i < rsmd.getColumnCount(); i++) {
                    columnNames.add(rsmd.getColumnName(i + 1));
                }
                // 把ResultSet中的所有记录添加到Vector里
                while (rs.next()) {
                    Vector<String> v = new Vector<>();
                    for (var i = 0; i < rsmd.getColumnCount(); i++) {
                        v.add(rs.getString(i + 1));
                    }
                    data.add(v);
                }

                // 创建新的JTable
                var table = new JTable(data, columnNames);
                scrollPane = new JScrollPane(table);
                // 添加新的JTable
                jf.add(scrollPane);
                // 更新主窗口
                jf.validate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new C_QueryExecutorTest().init();
    }
}
