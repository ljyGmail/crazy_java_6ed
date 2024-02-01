package org.crazy.ch11_awt.sec05_event_handling;

import java.awt.Frame;
import java.awt.Button;
import java.awt.TextField;
import java.awt.BorderLayout;

public class F_SendMailerTest {
    private Frame f = new Frame("测试");
    private TextField tf = new TextField(40);
    private Button send = new Button("发送" );

    public void init() {
        // 使用MailListener对象作为事件监听器
        send.addActionListener(new E_MailerListener(tf));

        f.add(tf);
        f.add(send, BorderLayout.SOUTH);

        f.pack();
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new F_SendMailerTest().init();
    }
}
