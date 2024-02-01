package org.crazy.ch11_awt.sec05_event_handling;

import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class H_AnonymousEventHandlerTest {
    private Frame f = new Frame("使用匿名内部类或Lambda表达式实现事件监听器");
    private TextArea ta = new TextArea(6, 40);

    public void init() {
        // 以匿名内部类的形式来创建事件监听器对象
        f.addWindowListener(new WindowAdapter() {
            // 实现事件处理方法
            public void windowClosing(WindowEvent e) {
                System.out.println("用户试图关闭窗口!");
                System.exit(0);
            }
        });

        f.add(ta);

        f.pack();
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new H_AnonymousEventHandlerTest().init();
    }
}
