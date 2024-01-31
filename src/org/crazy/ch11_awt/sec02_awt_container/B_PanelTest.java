package org.crazy.ch11_awt.sec02_awt_container;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextField;

public class B_PanelTest {
    public static void main(String[] args) {
        var f = new Frame("测试窗口");
        // 创建一个Panel容器
        var p = new Panel();
        // 向Panel容器中添加两个组件
        p.add(new TextField(20));
        p.add(new Button("单击我"));
        // 将Panel容器添加到Frame窗口中
        f.add(p);
        // 设置窗口的大小、位置
        f.setBounds(30, 30, 250, 120);
        // 将窗口显示出来(Frame对象默认处于隐藏状态)
        f.setVisible(true);
    }
}
