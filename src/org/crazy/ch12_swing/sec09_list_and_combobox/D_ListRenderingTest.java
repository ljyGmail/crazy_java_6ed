package org.crazy.ch12_swing.sec09_list_and_combobox;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;

public class D_ListRenderingTest {

    private JFrame mainWin = new JFrame("好友列表");

    private String[] friends = new String[] {
        "李清照",
        "苏格拉底",
        "李白",
        "弄玉",
        "虎头"
    };

    // 定义一个JList对象
    private JList friendList = new JList(friends);

    public void init() {
        // 设置该JList使用ImageCellRenderer作为列表项绘制器
        friendList.setCellRenderer(new ImageCellRenderer());
        mainWin.add(new JScrollPane(friendList));
        mainWin.pack();
        mainWin.setVisible(true);
    }

    public static void main(String[] args) {
        new D_ListRenderingTest().init();
    }
}

class ImageCellRenderer extends JPanel
    implements ListCellRenderer {

    private ImageIcon icon;
    private String name;
    // 定义绘制单元格时的背景色
    private Color background;
    // 定义绘制单元格时的前景色
    private Color foreground;

    public Component getListCellRendererComponent(JList list,
        Object value, int index,
        boolean isSelected, boolean cellHasFocus) {

        icon = new ImageIcon("../data/ch12_swing/ico/list_rendering/" + value + ".gif");
        name = value.toString();
        background = isSelected ? list.getSelectionBackground()
            : list.getBackground();
        foreground = isSelected ? list.getSelectionForeground()
            : list.getForeground();
        // 返回该JPanel对象作为列表项绘制器
        return this;
    }

    // 重写paintComponent()方法，改变JPanel的外观
    public void paintComponent(Graphics g) {
        int imageWidth = icon.getImage().getWidth(null);
        int imageHeight = icon.getImage().getHeight(null);
        g.setColor(background);
        g.fillRect(0, 0,  getWidth(), getHeight());
        g.setColor(foreground);
        // 绘制好友图标
        g.drawImage(icon.getImage(), getWidth() / 2
            - imageWidth / 2, 10, null);
        // 绘制好友用户名
        g.drawString(name, getWidth() / 2
            - name.length() * 10, imageHeight + 30);
    }

    // 通过该方法设置该ImageCellRenderer的最佳大小
    public Dimension getPreferredSize() {
        return new Dimension(60, 80);
    }
}
