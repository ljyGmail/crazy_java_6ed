package org.crazy.ch12_swing.sec03_swing_special_containers;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.beans.PropertyVetoException;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;

public class D_JInternalFrameTest {
    final int DESKTOP_WIDTH = 480;
    final int DESKTOP_HEIGHT = 360;
    final int FRAME_DISTANCE = 30;
    JFrame jf = new JFrame("MDI界面");
    // 定义一个虚拟桌面
    private MyJDesktopPane desktop = new MyJDesktopPane();
    // 保存下一个内部窗口的坐标点
    private int nextFrameX;
    private int nextFrameY;
    // 定义内部窗口为虚拟桌面的1/2大小
    private int width = DESKTOP_WIDTH / 2;
    private int height = DESKTOP_HEIGHT / 2;
    // 为窗口定义两个菜单
    JMenu fileMenu = new JMenu("文件");
    JMenu windowMenu = new JMenu("窗口");
    // 定义newAction，用于创建菜单和工具按钮
    Action newAction = new AbstractAction("新建",
            new ImageIcon("../data/ch12_swing/ico/new.png")) {
        public void actionPerformed(ActionEvent event) {
            // 创建内部窗口
            final var iframe = new JInternalFrame("新文档",
                    true, // 可改变大小
                    true, // 可关闭
                    true, // 可最小化
                    true); // 可最大化

            iframe.add(new JScrollPane(new JTextArea(8, 40)));
            // 将内部窗口添加到虚拟桌面中
            desktop.add(iframe);
            // 设置内部窗口的原始位置(内部窗口默认大小是0像素x0像素，位于(0, 0)位置)
            iframe.reshape(nextFrameX, nextFrameY, width, height);
            // 使该窗口可见，并尝试选中它
            iframe.show();
            // 计算下一个内部窗口的位置
            nextFrameX += FRAME_DISTANCE;
            nextFrameY += FRAME_DISTANCE;

            if (nextFrameX + width > desktop.getWidth()) {
                nextFrameX = 0;
            }

            if (nextFrameY + height > desktop.getHeight()) {
                nextFrameY = 0;
            }
        }
    };

    // 定义exitAction，用于创建菜单和工具按钮
    Action exitAction = new AbstractAction("退出",
            new ImageIcon("../data/ch12_swing/ico/exit.png")) {
        public void actionPerformed(ActionEvent event) {
            System.exit(0);
        }
    };

    public void init() {
        // 为窗口安装菜单条和工具条
        var menuBar = new JMenuBar();
        var toolBar = new JToolBar();
        jf.setJMenuBar(menuBar);
        menuBar.add(fileMenu);
        fileMenu.add(newAction);
        fileMenu.add(exitAction);
        toolBar.add(newAction);
        toolBar.add(exitAction);
        menuBar.add(windowMenu);

        var nextItem = new JMenuItem("下一个");
        nextItem.addActionListener(event -> desktop.selectNextWindow());
        windowMenu.add(nextItem);

        var cascadeItem = new JMenuItem("级联");
        cascadeItem.addActionListener(event ->
                // 级联显式窗口，内部窗口的大小是外部窗口的0.75倍
                desktop.cascadeWindows(FRAME_DISTANCE, 0.75));
        windowMenu.add(cascadeItem);

        var tileItem = new JMenuItem("平铺");
        // 平铺显式所有内部窗口
        tileItem.addActionListener(event -> desktop.tileWindows());
        windowMenu.add(tileItem);

        final var dragOutlineItem = new JCheckBoxMenuItem("仅显式拖动窗口的轮廓");
        dragOutlineItem.addActionListener(event -> {
            // 根据是否选择该菜单项来决定采用哪种拖动模式
            desktop.setDragMode(dragOutlineItem.isSelected()
                    ? JDesktopPane.OUTLINE_DRAG_MODE
                    : JDesktopPane.LIVE_DRAG_MODE);
        });
        windowMenu.add(dragOutlineItem);

        desktop.setPreferredSize(new Dimension(DESKTOP_WIDTH, DESKTOP_HEIGHT));

        // 将虚拟桌面添加到顶级JFrame容器中
        jf.add(desktop);
        jf.add(toolBar, BorderLayout.NORTH);

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new D_JInternalFrameTest().init();
    }
}

class MyJDesktopPane extends JDesktopPane {
    // 将所有的窗口以级联方式显式
    // 其中offset是两个窗口的位移距离
    // scale是内部窗口与JDesktopPane的大小比例
    public void cascadeWindows(int offset, double scale) {
        System.out.println("cascadeWindows");
        // 定义级联显示窗口时内部窗口的大小
        var width = (int) (getWidth() * scale);
        var height = (int) (getHeight() * scale);
        // 用于保存级联显示窗口时每个窗口的位置
        var x = 0;
        var y = 0;

        for (var frame : getAllFrames()) {
            try {
                // 取消内部窗口的最大化、最小化
                frame.setMaximum(false);
                frame.setIcon(false);
                // 把窗口重新放置在指定位置
                frame.reshape(x, y, width, height);
                x += offset;
                y += offset;
                // 如果到了虚拟桌面边界
                if (x + width > getWidth()) {
                    x = 0;
                }

                if (y + height > getHeight()) {
                    y = 0;
                }
            } catch (PropertyVetoException e) {
                e.printStackTrace();
            }
        }
    }

    // 将所有窗口以平铺方式显式
    public void tileWindows() {
        System.out.println("tileWindows");
        // 获得窗口的个数
        var frameCount = getAllFrames().length;

        // 计算需要多少行、多少列才可以平铺显示所有窗口
        var rows = (int) Math.sqrt(frameCount);
        var cols = frameCount / rows;
        System.out.println(rows + "@@" + cols);

        // 需要额外增加到其他列中的窗口数
        var extra = frameCount % rows;

        // 计算平铺显示时内部窗口的大小
        var width = getWidth() / cols;
        var height = getHeight() / rows;
        System.out.println(width + "##" + height);

        // 用于保存平铺显示窗口时每个窗口在横向、纵向上的索引
        var x = 0;
        var y = 0;

        for (var frame : getAllFrames()) {
            try {
                // 取消内部窗口的最大化、最小化
                frame.setMaximum(false);
                frame.setIcon(false);

                // 将窗口放在指定位置
                frame.reshape(x * width, y * height, width, height);
                y++;

                // 每排完一列窗口
                if (y == rows) {
                    // 开始排下一列窗口
                    y = 0;
                    x++;

                    // 如果额外多出的窗口与剩下的列数相等
                    // 则后面所有列都需要多排列一个窗口
                    if (extra == cols - x) {
                        rows++;
                        height = getHeight() / rows;
                    }
                }
            } catch (PropertyVetoException e) {
                e.printStackTrace();
            }
        }
    }

    // 选中下一个非最小化的窗口
    public void selectNextWindow() {
        System.out.println("selectNextWindow");
        JInternalFrame[] frames =  getAllFrames();
        for (var i = 0; i < frames.length; i++) {
            if (frames[i].isSelected()) {
                // 找出席一个非最小化的窗口，尝试选中它
                // 如果选中失败，则继续尝试选中下一个窗口
                int next = (i + 1) % frames.length;
                while (next != i) {
                    // 如果该窗口不是处于最小化状态
                    if (!frames[next].isIcon()) {
                        try {
                            frames[next].setSelected(true);
                            frames[next].toFront();
                            frames[i].toBack();
                            return;
                        } catch (PropertyVetoException e) {
                            e.printStackTrace();
                        }
                    }
                    next = (next + 1) % frames.length;
                }
            }
        }
    }
}
