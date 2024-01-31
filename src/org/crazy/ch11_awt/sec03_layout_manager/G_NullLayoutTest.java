package org.crazy.ch11_awt.sec03_layout_manager;

import java.awt.Button;
import java.awt.Frame;

public class G_NullLayoutTest {
    Frame f = new Frame();
    Button b1 = new Button("第一个按钮");
    Button b2 = new Button("第二个按钮");

    public void init() {
        // 设置使用null布局管理器
        f.setLayout(null);
        // 下面强制设置每个按钮的大小、位置
        b1.setBounds(20, 30, 90, 28);
        f.add(b1);
        b2.setBounds(50, 45, 120, 35);
        f.add(b2);

        f.setBounds(50, 50, 200, 200);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new G_NullLayoutTest().init();
    }
}
