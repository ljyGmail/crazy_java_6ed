package org.crazy.ch11_awt.sec03_layout_manager;

import java.awt.Button;
import java.awt.Frame;
import javax.swing.BoxLayout;

public class H_BoxLayoutTest {
    private Frame f = new Frame("测试");

    public void init() {
        f.setLayout(new BoxLayout(f, BoxLayout.Y_AXIS));
        // 下面的按钮将会垂直排列
        f.add(new Button("第一个按钮"));
        f.add(new Button("按钮二"));
        f.pack();
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new H_BoxLayoutTest().init();
    }
}
