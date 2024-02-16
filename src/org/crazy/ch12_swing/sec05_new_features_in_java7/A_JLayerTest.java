package org.crazy.ch12_swing.sec05_new_features_in_java7;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Graphics;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLayer;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.plaf.LayerUI;

class A_FirstLayerUI extends LayerUI<JComponent> {

    public void paint(Graphics g, JComponent c) {
        super.paint(g, c);
        var g2 = (Graphics2D) g.create();
        // 设置透明效果
        g2.setComposite(AlphaComposite.getInstance(
            AlphaComposite.SRC_OVER, .5f));
        // 使用渐变画笔绘图
        g2.setPaint(new GradientPaint(0, 0, Color.RED,
            0, c.getHeight(), Color.BLUE));
        // 绘制一个与被装饰组件具有相同大小的组件
        g2.fillRect(0, 0, c.getWidth(), c.getHeight());
        g2.dispose();
    }
}

public class A_JLayerTest {

    public void init() {
        var f = new JFrame("JLayer测试");
        var p = new JPanel();
        var group = new ButtonGroup();

        JRadioButton radioButton;
        // 创建3个RadioButton，并将它们添加成一组
        p.add(radioButton = new JRadioButton("网络购买", true));
        group.add(radioButton);
        p.add(radioButton = new JRadioButton("书店购买"));
        group.add(radioButton);
        p.add(radioButton = new JRadioButton("图书馆借阅"));
        group.add(radioButton);
        
        // 添加4个JCheckBox
        p.add(new JCheckBox("疯狂Java讲义"));
        p.add(new JCheckBox("疯狂Android讲义"));
        p.add(new JCheckBox("疯狂Ajax讲义"));
        p.add(new JCheckBox("轻量级Java EE企业应用"));

        var orderButton = new JButton("投票");
        p.add(orderButton);

        // 创建LayerUI对象
        LayerUI<JComponent> layerUI = new A_FirstLayerUI();

        // 使用layerUI来装饰指定的JPanel组件
        var layer = new JLayer<JComponent>(p, layerUI);

        // 将装饰后的JPanel组件添加到容器中
        f.add(layer);
        f.setSize(300, 170);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new A_JLayerTest().init();
    }
}
