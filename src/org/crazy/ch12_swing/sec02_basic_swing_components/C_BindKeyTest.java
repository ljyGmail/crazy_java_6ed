package org.crazy.ch12_swing.sec02_basic_swing_components;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class C_BindKeyTest {
    JFrame jf = new JFrame("键盘绑定测试");
    JTextArea jta = new JTextArea(5, 30);
    JTextField jtf = new JTextField(15);
    JButton jb = new JButton("发送");

    public void init() {
        jf.add(jta);

        var jp = new JPanel();
        jp.add(jtf);
        jp.add(jb);
        
        jf.add(jp, BorderLayout.SOUTH);

        // 发送消息的Action，Action是ActionListener的子接口
        Action sendMsg = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                jta.append(jtf.getText() + "\n");
                jtf.setText("");
            }
        };

        // 添加事件监听器
        jb.addActionListener(sendMsg);

        // 将"Ctrl+Enter"快捷键和"send"关联
        jtf.getInputMap().put(KeyStroke.getKeyStroke('\n',
                    InputEvent.CTRL_DOWN_MASK), "send");
        jtf.getActionMap().put("send", sendMsg);

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jf.pack();
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new C_BindKeyTest().init();
    }
}
