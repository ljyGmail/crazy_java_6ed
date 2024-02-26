package org.crazy.ch12_swing.sec09_list_and_combobox;

import java.awt.BorderLayout;
import java.util.List;
import java.util.Vector;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class A_ListTest {

    private JFrame mainWin = new JFrame("列表框测试");
    String[] books = new String[] {
        "疯狂Java讲义",
        "轻量级Java EE企业应用实战",
        "疯狂Android讲义",
        "疯狂Ajax讲义",
        "经典Java EE企业应用实战"
    };

    // 用一个字符串数组来创建一个JList对象
    JList<String> bookList = new JList<>(books);
    JComboBox<String> bookSelector;

    // 定义布局选择按钮所在的面板
    JPanel layoutPanel = new JPanel();
    ButtonGroup layoutGroup = new ButtonGroup();

    // 定义选择模式按钮所在的面板
    JPanel selectionModePanel = new JPanel();
    ButtonGroup selectionModeGroup = new ButtonGroup();

    JTextArea favorite = new JTextArea(4, 40);

    public void init() {
        // 设置JList的可视高度可同时显示3个列表项
        bookList.setVisibleRowCount(3);
        // 默认选中第3项到第5项(第1项的索引是0)
        bookList.setSelectionInterval(2, 4);

        addLayoutButton("纵向滚动", JList.VERTICAL);
        addLayoutButton("纵向换行", JList.VERTICAL_WRAP);
        addLayoutButton("横向换行", JList.HORIZONTAL_WRAP);

        addSelectionModeButton("无限制", ListSelectionModel
            .MULTIPLE_INTERVAL_SELECTION);
        addSelectionModeButton("单选", ListSelectionModel
            .SINGLE_SELECTION);
        addSelectionModeButton("单范围", ListSelectionModel
            .SINGLE_INTERVAL_SELECTION);

        var listBox = new Box(BoxLayout.Y_AXIS);
        // 将JList组件放在JScrollPane中，再将该JScrollPane添加到listBox容器中
        listBox.add(new JScrollPane(bookList));
        // 添加布局选择按钮面板、选择模式按钮面板
        listBox.add(layoutPanel);
        listBox.add(selectionModePanel);

        // 为JList添加事件监听器
        bookList.addListSelectionListener(e -> {
            // 获取用户所选择的所有图书
            List<String> books = bookList.getSelectedValuesList();
            favorite.setText("");
            for (var book : books) {
                favorite.append(book + "\n");
            }
        });

        Vector<String> bookCollection = new Vector<>();
        bookCollection.add("疯狂Java讲义");
        bookCollection.add("轻量级Java EE企业应用实战");
        bookCollection.add("疯狂Android讲义");
        bookCollection.add("疯狂Ajax讲义");
        bookCollection.add("经典Java EE企业应用实战");

        // 用一个Vector对象来创建一个JComboBox对象
        bookSelector = new JComboBox<>(bookCollection);
        // 为JComboBox添加事件监听器
        bookSelector.addItemListener(e -> {
            // 获取JComboBox所选中的项
            Object book = bookSelector.getSelectedItem();
            favorite.setText(book.toString());
        });
        // 设置可以直接编辑
        bookSelector.setEditable(true);
        // 设置下拉列表框的可视高度可同时显示4个列表项
        bookSelector.setMaximumRowCount(4);

        var p = new JPanel();
        p.add(bookSelector);
        
        var box = new Box(BoxLayout.X_AXIS);
        box.add(listBox);
        box.add(p);

        mainWin.add(box);

        var favoritePanel = new JPanel();
        favoritePanel.setLayout(new BorderLayout());
        favoritePanel.add(new JScrollPane(favorite));
        favoritePanel.add(new JLabel("您喜欢的图书: "), BorderLayout.SOUTH);

        mainWin.add(favoritePanel, BorderLayout.SOUTH);

        mainWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWin.pack();
        mainWin.setVisible(true);
    }

    private void addLayoutButton(String label, final int orientation) {
        layoutPanel.setBorder(new TitledBorder(new EtchedBorder(),
            "确定选项布局"));
        var button = new JRadioButton(label);
        // 把该单选按钮添加到layoutPanel面板中
        layoutPanel.add(button);
        // 默认选中第一个按钮
        if (layoutGroup.getButtonCount() == 0) {
            button.setSelected(true);
        }
        layoutGroup.add(button);
        button.addActionListener(event -> {
            // 改变列表框里列表项的布局方向
            bookList.setLayoutOrientation(orientation);
        });
    }

    private void addSelectionModeButton(String label, final int selectionMode) {
        selectionModePanel.setBorder(new TitledBorder(new EtchedBorder(),
            "确定选项模式"));
        var button = new JRadioButton(label);
        // 把该单选按钮添加到selectionModePanel面板中
        selectionModePanel.add(button);
        // 默认选中第一个按钮
        if (selectionModeGroup.getButtonCount() == 0) {
            button.setSelected(true);
        }
        selectionModeGroup.add(button);

        button.addActionListener(event -> {
            // 改变列表框里的选择模式
            bookList.setSelectionMode(selectionMode);
        });
    }

    public static void main(String[] args) {
        new A_ListTest().init();
    }
}
