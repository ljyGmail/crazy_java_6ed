package org.crazy.ch11_awt.sec08_image_drawing;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

public class A_HandDrawTest {
    // 画图区的宽度
    private final int AREA_WIDTH = 500;
    // 画图区的高度
    private final int AREA_HEIGHT = 400;
    // 下面的preX、preY保存上一次鼠标拖动事件点的坐标
    private int preX = -1;
    private int preY = -1;

    // 定义一个右键菜单用于设置画笔颜色
    PopupMenu pop = new PopupMenu();
    MenuItem redItem = new MenuItem("红色");
    MenuItem greenItem = new MenuItem("绿色");
    MenuItem blueItem = new MenuItem("蓝色");

    // 定义一个BufferedImage对象
    BufferedImage image = new BufferedImage(AREA_WIDTH,
            AREA_HEIGHT, BufferedImage.TYPE_INT_RGB);

    // 获取image对象的Graphics
    Graphics g = image.getGraphics();

    private Frame f = new Frame("简单手绘程序");

    private DrawCanvas drawArea = new DrawCanvas();

    // 用于保存画笔颜色
    private Color foreColor = new Color(255, 0, 0);

    public void init() {
        // 定义右键菜单的事件监听器
        ActionListener menuListener = e -> {
            if ("绿色".equals(e.getActionCommand())) {
                foreColor = new Color(0, 255, 0);
            }
            if ("红色".equals(e.getActionCommand())) {
                foreColor = new Color(255, 0, 0);
            }
            if ("蓝色".equals(e.getActionCommand())) {
                foreColor = new Color(0, 0, 255);
            }
        };

        // 为三个菜单项添加事件监听器
        redItem.addActionListener(menuListener);
        greenItem.addActionListener(menuListener);
        blueItem.addActionListener(menuListener);

        // 将菜单项 组合成右键菜单
        pop.add(redItem);
        pop.add(greenItem);
        pop.add(blueItem);

        // 将右键菜单添加到drawArea对象中
        drawArea.add(pop);

        // 将image对象的背景色填充成白色
        g.fillRect(0, 0, AREA_WIDTH, AREA_HEIGHT);
        drawArea.setPreferredSize(new Dimension(AREA_WIDTH, AREA_HEIGHT));

        // 监听鼠标移动动作
        drawArea.addMouseMotionListener(new MouseMotionAdapter() {
            // 实现按下鼠标键并拖动的事件处理器
            public void mouseDragged(MouseEvent e) {
                // 如果preX和preY大于0
                if (preX > 0 && preY > 0) {
                    // 设置当前元素
                    g.setColor(foreColor);
                    // 绘制从上一次鼠标拖动事件点到本次鼠标拖动事件点的线段
                    g.drawLine(preX, preY, e.getX(), e.getY());
                }
                // 将当前鼠标事件点的X、Y坐标保存起来
                preX = e.getX();
                preY = e.getY();

                // 重绘drawArea对象
                drawArea.repaint();
            }
        });

        // 监听鼠标事件
        drawArea.addMouseListener(new MouseAdapter() {
            // 实现松开鼠标键的事件处理器
            public void mouseReleased(MouseEvent e) {
                // 弹出右键菜单
                if (e.isPopupTrigger()) {
                    pop.show(drawArea, e.getX(), e.getY());
                }
                // 当松开鼠标键时，把上一次鼠标拖动事件点 的X、Y坐标设为-1
                preX = -1;
                preY = -1;
            }
        });

        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        f.add(drawArea);

        f.pack();
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new  A_HandDrawTest().init();
    }

    class DrawCanvas extends Canvas {
        // 重写Canvas的paint方法，实现绘画
        public void paint(Graphics g) {
            g.drawImage(image, 0, 0, null);
        }
    }
}
