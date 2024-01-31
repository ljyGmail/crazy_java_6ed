package org.crazy.ch11_awt.sec03_layout_manager;

import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.Button;
import java.awt.GridLayout;
import static java.awt.BorderLayout.NORTH;

public class D_GridLayoutTest {
    public static void main(String[] args) {
        var f = new Frame("计算器");
        var p1 = new Panel();
        p1.add(new TextField(30));
        f.add(p1, NORTH);

        Panel p2 = new Panel();
        // 设置Panel使用GridLayout布局管理器
        p2.setLayout(new GridLayout(3, 5, 4, 4));
        String[] names = {"0", "1", "2", "3",
            "4", "5", "6", "7", "8", "9",
            "+", "-", "*", "/", "."};

        // 向Panel中依次添加15个按钮
        for (var i = 0; i < names.length; i++) {
            p2.add(new Button(names[i]));
        }
        // 默认将Panel对象添加到Frame窗口的中间
        f.add(p2);
        // 设置窗口为最佳大小
        f.pack();
        // 将窗口显示出来
        f.setVisible(true);
    }
}
