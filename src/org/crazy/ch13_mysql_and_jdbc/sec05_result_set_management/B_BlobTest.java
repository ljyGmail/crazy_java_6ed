package org.crazy.ch13_mysql_and_jdbc.sec05_result_set_management;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.filechooser.FileFilter;

public class B_BlobTest {
    JFrame jf = new JFrame("图片管理程序");
    private static Connection conn;
    private static PreparedStatement insert;
    private static PreparedStatement query;
    private static PreparedStatement queryAll;

    // 定义一个DefaultListModel对象
    private DefaultListModel imageModel = new DefaultListModel();
    private JList<ImageHolder> imageList = new JList<>(imageModel);
    private JTextField filePath = new JTextField(26);
    private JButton browserBn = new JButton("...");
    private JButton uploadBn = new JButton("上传");
    private JLabel imageLabel = new JLabel();
    // 以当前路径创建文件选择器
    JFileChooser chooser = new JFileChooser(".");
    // 创建文件过滤器
    ExtensionFileFilter filter = new ExtensionFileFilter();

    static {
        try {
            var props = new Properties();
            props.load(new FileInputStream("../data/ch13_mysql_and_jdbc/mysql.ini"));
            var driver = props.getProperty("driver");
            var url = props.getProperty("url");
            var user = props.getProperty("user");
            var pass = props.getProperty("pass");
            Class.forName(driver);
            // 获取数据库连接
            conn = DriverManager.getConnection(url, user, pass);
            // 创建执行插入的PreparedStatement对象
            // 该对象执行插入后可以返回自动生成的主键
            insert = conn.prepareStatement("insert into img_table"
                    + " values(null, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            // 创建两个PreparedStatement对象，用于查询指定的图片，查询所有图片
            query = conn.prepareStatement("select img_data from img_table"
                    + " where img_id = ?");
            queryAll = conn.prepareStatement("select img_id, "
                    + "img_name from img_table");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void init() throws SQLException {
        // -------初始化文件过滤器-------
        filter.addExtension("jpg");
        filter.addExtension("jpeg");
        filter.addExtension("gif");
        filter.addExtension("png");
        filter.setDescription("图片文件(*.jpg, *.jpeg, *.gif, *.png)");
        chooser.addChoosableFileFilter(filter);
        // 禁止在"文件类型"下拉列表中显示"所有文件"选项
        chooser.setAcceptAllFileFilterUsed(false);

        // -------初始化程序界面-------
        fillListModel();
        filePath.setEditable(false);
        // 只能单选
        imageList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        var jp = new JPanel();
        jp.add(filePath);
        jp.add(browserBn);
        browserBn.addActionListener(event -> {
            // 显示文件对话框
            int result = chooser.showDialog(jf, "浏览图片文件上传");
            // 如果用户选择了APPROVE(赞同)按钮，也就是打开、保存等效按钮
            if (result == JFileChooser.APPROVE_OPTION) {
                filePath.setText(chooser.getSelectedFile().getPath());
            }
        });
        jp.add(uploadBn);
        uploadBn.addActionListener(event -> {
            // 如果上传文件的文本框有内容
            if (filePath.getText().trim().length() > 0) {
                upload(filePath.getText());
                // 清空文本框内容
                filePath.setText("");
            }
        });

        var left = new JPanel();
        left.setLayout(new BorderLayout());
        left.add(new JScrollPane(imageLabel), BorderLayout.CENTER);
        left.add(jp, BorderLayout.SOUTH);
        jf.add(left);
        imageList.setFixedCellWidth(160);
        jf.add(new JScrollPane(imageList), BorderLayout.EAST);
        imageList.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                // 如果鼠标双击
                if (e.getClickCount() == 2) {
                    // 取出鼠标双击
                    ImageHolder cur = (ImageHolder) imageList.getSelectedValue();
                    try {
                        // 显示选中项对应的图片Image
                        showImage(cur.getId());
                    } catch (SQLException sqle) {
                        sqle.printStackTrace();
                    }
                }
            }
        });

        jf.setSize(720, 400);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }

    // ----------查找img_table填充ListModel----------
    public void fillListModel() throws SQLException {
        try (
            // 执行查询
            ResultSet rs = queryAll.executeQuery())
        {
            // 先清除所有元素
            imageModel.clear();
            // 把查询的全部记录添加到ListModel中
            while (rs.next()) {
                imageModel.addElement(new ImageHolder(rs.getInt(1),
                            rs.getString(2)));
            }
        }
    }

    // ----------将指定的图片放入数据库中----------
    public void upload(String fileName) {
        // 截取文件名
        String imageName = fileName.substring(fileName.lastIndexOf('/') + 1, fileName.lastIndexOf('.'));
        var f = new File(fileName);
        try (
            var is = new FileInputStream(f)) {
            // 设置图片名参数
            insert.setString(1, imageName);
            // 设置二进制流参数
            insert.setBinaryStream(2, is, (int) f.length());
            var affect = insert.executeLargeUpdate();
            if (affect == 1) {
                // 重新更新ListModel，将会让JList显示最新的图片列表
                fillListModel();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ----------根据图片ID来显示图片----------
    public void showImage(int id) throws SQLException {
        // 设置参数
        query.setInt(1, id);
        try (
            // 执行查询
            ResultSet rs = query.executeQuery()) {
            if (rs.next()) {
                // 取出Blob列
                Blob imgBlob = rs.getBlob(1);
                // 取出Blob列中的数据
                var icon = new ImageIcon(imgBlob.getBytes(1L, (int) imgBlob.length()));
                imageLabel.setIcon(icon);
            }
        }
    }

    public static void main(String[] args) throws SQLException {
        new B_BlobTest().init();
    }
}

// 创建FileFilter的子类，用于实现文件过滤功能
class ExtensionFileFilter extends FileFilter {
    private String description = "";
    private ArrayList<String> extensions = new ArrayList<>();

    // 自定义方法，用于添加文件扩展名
    public void addExtension(String extension) {
        if (!extension.startsWith(".")) {
            extension = "." + extension;
            extensions.add(extension.toLowerCase());
        }
    }

    // 用于设置该文件过滤器的描述文本
    public void setDescription(String aDescription) {
        description = aDescription;
    }

    // 继承FileFilter类必须实现的抽象方法，返回该文件过滤器的描述文本
    public String getDescription() {
        return description;
    }

    // 继承FileFilter必须实现的抽象方法，判断该文件过滤器是否接收该文件
    public boolean accept(File f) {
        // 如果该文件是路径，则接受该文件
        if (f.isDirectory()) return true;
        // 将文件名转为小写的(全部转为小写后比较，用于忽略文件名大小写)
        String name = f.getName().toLowerCase();
        // 遍历所有可接受的扩展名，如果扩展名相同，则该文件就可被接受
        for (var extension : extensions) {
            if (name.endsWith(extension)) {
                return true;
            }
        }

        return false;
    }
}

// 创建一个ImageHolder类，用于封装图片ID、图片名
class ImageHolder {
    // 封装图片ID
    private int id;
    // 封装图片名
    private String name;

    public ImageHolder() {}
    public ImageHolder(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // id的setter和getter方法
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    // name的setter和getter方法
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    // 重写toString()方法，返回图片名
    public String toString() {
        return name;
    }
}