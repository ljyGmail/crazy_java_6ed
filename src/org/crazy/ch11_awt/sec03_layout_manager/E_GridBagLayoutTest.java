package org.crazy.ch11_awt.sec03_layout_manager;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

public class E_GridBagLayoutTest {

    private Frame f = new Frame("测试窗口");
    private GridBagLayout gb = new GridBagLayout();
    private GridBagConstraints gbc = new GridBagConstraints();
    private Button[] bs = new Button[10];

    public void init() {
        f.setLayout(gb);

        for (var i = 0; i < bs.length; i++) {
            bs[i] = new Button("按钮" + i);
        }

        // 所有组件都可以在横向、纵向上扩大
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1;
        addButton(bs[0]);
        addButton(bs[1]);
        addButton(bs[2]);

        // 该GridBagConstraints控制的GUI组件将会成为横向上最后一个组件
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        addButton(bs[3]);
        
        // 该GridBagConstraints控制的GUI组件在横向上不会扩大
        gbc.weightx = 0;
        addButton(bs[4]);

        // 该GridBagConstraints控制的GUI组件将横跨两个网格
        gbc.gridwidth = 2;
        addButton(bs[5]);

        // 该GridBagConstraints控制的GUI组件将占一个网格
        gbc.gridwidth = 1;
        // 该GridBagConstraints控制的GUI组件将在纵向上跨越两个网格
        gbc.gridheight = 2;
        // 该GridBagConstraints控制的GUI组件将会成为横向上最后一个组件
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        addButton(bs[6]);

        // 该GridBagConstraints控制的GUI组件横向占据一个网格，纵向跨越两个网格
        gbc.gridwidth = 1;
        gbc.gridheight = 2;
        // 该GridBagConstraints控制的GUI组件纵向扩大的权重是1
        gbc.weighty = 1;
        addButton(bs[7]);

        // 设置下面的按钮在纵向上不会扩大
        gbc.weighty = 0;
        // 该GridBagConstraints控制的GUI组件将会成为横向上最后一个组件
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        // 该GridBagConstraints控制的GUI组件将在纵向上占据一个网格
        gbc.gridheight = 1;
        addButton(bs[8]);
        addButton(bs[9]);

        f.pack();
        f.setVisible(true);
    }

    private void addButton(Button button) {
        gb.setConstraints(button, gbc);
        f.add(button);
    }

    public static void main(String[] args) {
        new E_GridBagLayoutTest().init();
    }
}
