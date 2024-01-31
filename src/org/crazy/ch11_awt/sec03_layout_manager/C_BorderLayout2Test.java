package org.crazy.ch11_awt.sec03_layout_manager;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextField;

import static java.awt.BorderLayout.EAST;
import static java.awt.BorderLayout.NORTH;
import static java.awt.BorderLayout.SOUTH;

public class C_BorderLayout2Test {
    public static void main(String[] args) {
        var f = new Frame("测试窗口");
        // 设置Frame容器使用BorderLayout布局管理器
        f.setLayout(new BorderLayout(30, 5));
        f.add(new Button("南"), SOUTH);
        f.add(new Button("北"), NORTH);
        // 创建一个Panel大小
        var p = new Panel();
        // 向Panel大小中添加两个组件
        p.add(new TextField(20));
        p.add(new Button("单击我"));
        // 默认添加到中间区域，向中间区域添加一个Panel容器
        f.add(p);
        f.add(new Button("东"), EAST);
        // 设置窗口为最佳大小
        f.pack();
        // 将窗口显示出来
        f.setVisible(true);
    }
}
