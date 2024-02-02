package org.crazy.ch11_awt.sec07_awt_drawing;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Panel;
import java.util.Random;

public class A_SimpleDrawTest {

    private final String RECT_SHAPE = "rect";
    private final String OVAL_SHAPE = "oval";
    private Frame f = new Frame("简单绘图");
    private Button rect = new Button("绘制矩形");
    private Button oval = new Button("绘制椭圆形");
    private MyCanvas drawArea = new MyCanvas();

    // 用于保存需要绘制什么图形的变量
    private String shape = "";

    public void init() {
        rect.addActionListener(e -> {
            // 设置shape变量为RECT_SHAPE
            shape = RECT_SHAPE;
            // 重画MyCanvas对象，即调用它的repaint()方法
            drawArea.repaint();
        });

        oval.addActionListener(e -> {
            // 设置shape变量为OVAL_SHAPE
            shape = OVAL_SHAPE;
            // 重画MyCanvas对象，即调用它的repaint()方法
            drawArea.repaint();
        });

        var p = new Panel();
        p.add(rect);
        p.add(oval);
        drawArea.setPreferredSize(new Dimension(250, 180));

        f.add(drawArea);
        f.add(p, BorderLayout.SOUTH);

        f.pack();
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new A_SimpleDrawTest().init();
    }

    class MyCanvas extends Canvas {
        // 重写Canvas的paint()方法，实现绘画
        public void paint(Graphics g) {
            var rand = new Random();
            if (RECT_SHAPE.equals(shape)) {
                // 设置画笔颜色
                g.setColor(new Color(220, 100, 80));
                // 随机绘制一个矩形
                g.drawRect(rand.nextInt(200), rand.nextInt(120), 40, 60);
            }
            if (OVAL_SHAPE.equals(shape)) {
                // 设置画笔颜色
                g.setColor(new Color(80, 100, 200));
                // 随机填充一个椭圆形区域
                g.fillOval(rand.nextInt(200), rand.nextInt(120), 50, 40);
            }
        }
    }
}
