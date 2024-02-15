package org.crazy.ch12_swing.sec04_swing_simplified_dnd;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class A_SwingDndSupportTest {
    JFrame jf = new JFrame("Swing的拖放支持");
    JTextArea srcTxt = new JTextArea(8, 30);
    JTextField jtf = new JTextField(34);

    public void init() {
        srcTxt.append("Swing的拖放支持.\n");
        srcTxt.append("将该文本域的内容拖入其他程序.\n");
        // 启动多行文本域和单行文本框的拖放支持
        srcTxt.setDragEnabled(true);
        jtf.setDragEnabled(true);

        jf.add(new JScrollPane(srcTxt));
        jf.add(jtf, BorderLayout.SOUTH);
        
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new A_SwingDndSupportTest().init();
    }
}
