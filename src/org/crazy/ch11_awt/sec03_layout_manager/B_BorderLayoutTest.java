package org.crazy.ch11_awt.sec03_layout_manager;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import static java.awt.BorderLayout.EAST;
import static java.awt.BorderLayout.NORTH;
import static java.awt.BorderLayout.SOUTH;
import static java.awt.BorderLayout.WEST;

public class B_BorderLayoutTest {
    public static void main(String[] args) {
        var f = new Frame("测试窗口");
        // 设置Frame容器使用BorderLayout布局管理器
        f.setLayout(new BorderLayout(30, 5));
        f.add(new Button("南"), SOUTH);
        f.add(new Button("北"), NORTH);
        // 默认添加到中间区域
        f.add(new Button("中"));
        f.add(new Button("东"), EAST);
        f.add(new Button("西"), WEST);
        // 设置窗口为最佳大小
        f.pack();
        // 将窗口显示出来
        f.setVisible(true);
    }
}
