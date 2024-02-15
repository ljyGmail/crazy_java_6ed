package org.crazy.ch12_swing.sec04_swing_simplified_dnd;

import java.awt.BorderLayout;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.TransferHandler;

public class B_TransferHandlerTest {
    private JFrame jf = new JFrame("TransferHandler测试");
    JColorChooser chooser = new JColorChooser();
    JTextArea txt = new JTextArea("测试TransferHandler\n"
            + "直接将上面的颜色拖入以改变文本颜色");

    public void init() {
        // 启动颜色选择器面板和文本域的拖放功能
        chooser.setDragEnabled(true);
        txt.setDragEnabled(true);
        jf.add(chooser, BorderLayout.SOUTH);
        // 允许直接将一个Color对象拖入该JTextArea对象中
        // 并赋给它的foreground属性
        txt.setTransferHandler(new TransferHandler("foreground"));

        jf.add(new JScrollPane(txt));

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new B_TransferHandlerTest().init();
    }
}
