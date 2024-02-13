package org.crazy.ch12_swing.sec03_swing_special_containers;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;

public class B_JTabbedPaneTest {
    JFrame jf = new JFrame("Tab页面测试");
    // 创建一个标签页的标签放在左边，采用换行布局策略的JTabbedPane
    JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT,
            JTabbedPane.WRAP_TAB_LAYOUT);
    ImageIcon icon = new ImageIcon("../data/ch12_swing/ico/close.gif");

    String[] layouts = {"换行布局", "滚动条布局"};
    String[] positions = {"左边", "顶部", "右边", "底部"};

    Map<String, String> books = new LinkedHashMap<>();
    
    public void init() {
        books.put("疯狂Java讲义", "java.png");
        books.put("轻量级Java EE企业应用实战", "ee.png");
        books.put("疯狂Ajax讲义", "ajax.png");
        books.put("疯狂Android讲义", "android.png");
        books.put("经典Java EE企业应用实战", "classic.png");

        var tip = "可看到本书的封面照片";

        // 向JTabbedPane中添加5个标签页，指定了标题、图标和提示信息
        // 但该标签的组件为null
        for (var bookName : books.keySet()) {
            tabbedPane.addTab(bookName, icon, null, tip);
        }

        jf.add(tabbedPane, BorderLayout.CENTER);
        // 为JTabbedPane添加事件监听器
        tabbedPane.addChangeListener(event -> {
            // 如果被选择的组件依然是空
            if (tabbedPane.getSelectedComponent() == null) {
                // 获取所选标签页
                int n = tabbedPane.getSelectedIndex();
                // 为指定标签页加载内容
                loadTab(n);
            }
        });

        // 系统默认选择第一页，加载第一页内容
        loadTab(0);
        tabbedPane.setPreferredSize(new Dimension(500, 300));

        // 增加控制标签布局、标签位置的单选钮
        var buttonPanel = new JPanel();
        var action = new ChangeAction();
        buttonPanel.add(new B_ButtonPanel(action, "选择标签布局策略", layouts));
        buttonPanel.add(new B_ButtonPanel(action, "选择标签位置", positions));

        jf.add(buttonPanel, BorderLayout.SOUTH);

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);
    }

    // 为指定标签页加载内容
    private void loadTab(int n) {
        String title = tabbedPane.getTitleAt(n);
        // 根据标签页的标题获取对应的图书封面
        var bookImage = new ImageIcon("../data/ch12_swing/ico/"
               + books.get(title));
        tabbedPane.setComponentAt(n, new JLabel(bookImage));
        // 改变标签页的图标
        tabbedPane.setIconAt(n, new ImageIcon("../data/ch12_swing/ico/open.gif"));
    }

    // 定义改变标签页的布局策略、放置位置的监听器
    class ChangeAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            var source = (JRadioButton) event.getSource();
            String selection = source.getActionCommand();

            // 设置标签页的标题布局策略
            if (selection.equals(layouts[0])) {
                tabbedPane.setTabLayoutPolicy(JTabbedPane.WRAP_TAB_LAYOUT);
            } else if (selection.equals(layouts[1])) {
                tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
            } // 设置标签页的标题放置位置
            else if (selection.equals(positions[0])) {
                tabbedPane.setTabPlacement(JTabbedPane.LEFT);
            } else if (selection.equals(positions[1])) {
                tabbedPane.setTabPlacement(JTabbedPane.TOP);
            } else if (selection.equals(positions[2])) {
                tabbedPane.setTabPlacement(JTabbedPane.RIGHT);
            } else if (selection.equals(positions[3])) {
                tabbedPane.setTabPlacement(JTabbedPane.BOTTOM);
            }
        }
    }

    public static void main(String[] args) {
        new B_JTabbedPaneTest().init();
    }
}

// 定义一个JPanel类的扩展类，该类的对象包含多个纵向排列的JRadioButton控件
// 且JPanel扩展类可以指定一个字符串作为TitledBorder
class B_ButtonPanel extends JPanel {
    private ButtonGroup group;

    public B_ButtonPanel(B_JTabbedPaneTest.ChangeAction action,
            String title, String[] labels) {
        setBorder(BorderFactory.createTitledBorder(BorderFactory
                    .createEtchedBorder(), title));
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        group = new ButtonGroup();

        for (var i = 0; labels != null && i < labels.length; i++) {
            var b = new JRadioButton(labels[i]);
            this.add(b);
            b.addActionListener(action);
            group.add(b);
            b.setSelected(i == 0);
        }
    }
}
