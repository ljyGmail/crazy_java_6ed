package org.crazy.ch11_awt.sec05_event_handling;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class B_MultiListenerTest {
    private Frame f = new Frame("测试");
    private TextArea ta = new TextArea(6, 40);
    private Button b1 = new Button("按钮一");
    private Button b2 = new Button("按钮二");

    public void init() {
        // 创建FirstListener监听器的示例
        var fl = new FirstListener();
        // 给b1按钮注册两个事件监听器
        b1.addActionListener(fl);
        b1.addActionListener(new SecondListener());

        // 将fl事件监听器注册给b2按钮
        b2.addActionListener(fl);

        f.add(ta);

        var p = new Panel();
        p.add(b1);
        p.add(b2);
        f.add(p, BorderLayout.SOUTH);

        f.pack();
        f.setVisible(true);
    }

    class FirstListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            ta.append("第一个事件监听器被触发，事件源是: "
                    + e.getActionCommand() + "\n");
        }
    }

    class SecondListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            ta.append("单击了 '"
                    + e.getActionCommand() + "'按钮\n");
        }
    }

    public static void main(String[] args) {
        new B_MultiListenerTest().init();
    }
}
