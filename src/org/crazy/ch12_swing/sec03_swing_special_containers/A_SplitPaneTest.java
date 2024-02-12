package org.crazy.ch12_swing.sec03_swing_special_containers;

import java.awt.Dimension;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;

class A_Book {
    private String name;
    private Icon icon;
    private String desc;

    public A_Book() {}

    public A_Book(String name, Icon icon, String desc) {
        this.name = name;
        this.icon = icon;
        this.desc = desc;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Icon getIcon() {
        return this.icon;
    }

    public void  setIcon(Icon icon) {
        this.icon = icon;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return  this.name;
    }
}

public class A_SplitPaneTest {
    A_Book[] books = new A_Book[] {
        new A_Book("疯狂Java讲义", new ImageIcon("../data/ch12_swing/ico/java.png"),
                "国内关于Java编程最全面的图书\n看得懂，学得会"),
        new A_Book("轻量级Java EE企业应用实战", new ImageIcon("../data/ch12_swing/ico/ee.png"),
                "SSH整合开发的经典图书，值的拥有"),
        new A_Book("疯狂Android讲义", new ImageIcon("../data/ch12_swing/ico/android.png"),
                "全面介绍Android平台应用程序\n开发的各方面知识")
    };

    JFrame jf = new JFrame("JSplitPane测试");
    JList<A_Book> bookList = new JList<>(books);
    JLabel bookCover = new JLabel();
    JTextArea bookDesc = new JTextArea();

    public void init() {
        // 为三个组件设置最佳大小
        bookList.setPreferredSize(new Dimension(150, 300));
        bookCover.setPreferredSize(new Dimension(300, 150));
        bookDesc.setPreferredSize(new Dimension(300, 150));

        // 为下拉列表添加事件监听器
        bookList.addListSelectionListener(event -> {
            var book = bookList.getSelectedValue();
            bookCover.setIcon(book.getIcon());
            bookDesc.setText(book.getDesc());
        });

        // 创建一个垂直的分割面板
        // 将bookCover放在上边，将bookDesc放在下边，支持连续布局
        var left =  new JSplitPane(JSplitPane.VERTICAL_SPLIT,
                true, bookCover, new JScrollPane(bookDesc));
        // 打开"一键即展"特性
        left.setOneTouchExpandable(true);
        // 下面的代码设置分割条的大小
        // left.setDividerSize(50);
        // 设置该分割面板根据所包含组件的最佳大小来调整布局
        left.resetToPreferredSizes();

        // 创建一个水平的分割面板
        // 将left组件放在左边，将bookList组件放在右边
        var content = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
                left, bookList);

        jf.add(content);

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new A_SplitPaneTest().init();
    }
}
