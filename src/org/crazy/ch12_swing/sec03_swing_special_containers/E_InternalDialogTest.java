package org.crazy.ch12_swing.sec03_swing_special_containers;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class E_InternalDialogTest {
    private JFrame jf = new JFrame("内部对话框测试");
    private JDesktopPane desktop = new JDesktopPane();
    private JButton internalBn = new JButton("内部窗口的对话框");
    private JButton deskBn = new JButton("虚拟桌面的对话框");
    // 定义一个内部窗口，该窗口可拖动，但不可最大化、最小化、关闭
    private JInternalFrame iframe = new JInternalFrame("内部窗口");

    public void init() {
        // 向内部窗口中添加组件
        iframe.add(new JScrollPane(new JTextArea(8, 40)));
        desktop.setPreferredSize(new Dimension(400, 300));
        // 把虚拟桌面添加到JFrame窗口中
        jf.add(desktop);
        // 设置内部窗口的大小、位置
        iframe.reshape(0, 0, 300, 200);
        // 显示并选中内部窗口
        iframe.show();

        desktop.add(iframe);

        var jp = new JPanel();

        deskBn.addActionListener(event -> {
            // 弹出内部对话框，以虚拟桌面作为父组件
            JOptionPane.showInternalMessageDialog(desktop,
                    "属于虚拟桌面的对话框");
        });

        internalBn.addActionListener(event -> {
            // 弹出内部对话框，以内部窗口作为父组件
            JOptionPane.showInternalMessageDialog(iframe,
                    "属于内部窗口的对话框");
        });

        jp.add(deskBn);
        jp.add(internalBn);

        jf.add(jp, BorderLayout.SOUTH);

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new E_InternalDialogTest().init();
    }
}
