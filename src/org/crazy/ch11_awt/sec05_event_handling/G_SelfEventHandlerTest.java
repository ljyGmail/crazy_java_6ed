package org.crazy.ch11_awt.sec05_event_handling;

import java.awt.Frame;
import java.awt.TextArea;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

// GUI界面类继承WindowAdapter作为事件监听器类
public class G_SelfEventHandlerTest extends WindowAdapter {
    private Frame f = new Frame("类本身作为事件监听器类");
    private TextArea ta = new TextArea(6, 40);

    public void init() {
        // 将该类的默认对象作为事件监听器对象
        f.addWindowListener(this);

        f.add(ta);

        f.pack();
        f.setVisible(true);
    }

    // GUI界面类直接包含事件处理器方法
    public void windowClosing(WindowEvent e) {
        System.out.println("用户关闭窗口!");
        System.exit(0);
    }

    public static void main(String[] args) {
        new G_SelfEventHandlerTest().init();
    }
}
