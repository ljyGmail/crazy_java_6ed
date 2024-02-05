package org.crazy.ch11_awt.sec09_clipboard;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.PopupMenu;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;


public class C_CopyImageTest {
    // 系统剪贴板
    private Clipboard clipboard = Toolkit
        .getDefaultToolkit().getSystemClipboard();

    // 使用ArrayList保存所有粘贴进来的 Image - 就是当成图层处理
    List<Image> imageList = new ArrayList<>();

    // 画图区的宽度
    private final int AREA_WIDTH = 600;
    // 画图区的高度
    private final int AREA_HEIGHT = 400;

    private Frame f = new Frame("手绘图像的复制与粘贴");

    // 定义一个右键菜单用于设置画笔颜色
    private PopupMenu pop = new PopupMenu();
    private MenuItem redItem = new MenuItem("红色");
    private MenuItem greenItem = new MenuItem("绿色");
    private MenuItem blueItem = new MenuItem("蓝色");
    private Button copyBtn = new Button("复制");
    private Button pasteBtn = new Button("粘贴");

    private DrawArea drawArea = new DrawArea();

    // 定义一个BufferedImage对象
    private BufferedImage image = new BufferedImage(AREA_WIDTH,
            AREA_HEIGHT, BufferedImage.TYPE_INT_RGB);
    // 获取image对象的Graphics
    private Graphics g = image.getGraphics();
    
    // 用于保存画笔颜色
    private Color foreColor = new Color(255, 0, 0);

    // 下面的preX、preY保存了上一次鼠标拖动事件的鼠标坐标
    private int preX = -1;
    private int preY = -1;

    public void init() {
        // 定义右键菜单的事件监听器
        ActionListener menuListener = e -> {
            var selectedColor = e.getActionCommand();
            if ("红色".equals(selectedColor)) {
                foreColor = new Color(255, 0, 0);
            } else if ("绿色".equals(selectedColor)) {
                foreColor = new Color(0, 255, 0);
            } else if ("蓝色".equals(selectedColor)) {
                foreColor = new Color(0, 0, 255);
            }
        };

        // 为三个菜单添加事件监听器
        redItem.addActionListener(menuListener);
        greenItem.addActionListener(menuListener);
        blueItem.addActionListener(menuListener);

        // 将菜单项组合到右键菜单
        pop.add(redItem);
        pop.add(greenItem);
        pop.add(blueItem);

        // 将右键添加到drawArea对象中
        drawArea.add(pop);

        // 将image对象的背景色填充成白色
        g.fillRect(0, 0, AREA_WIDTH, AREA_HEIGHT);
        drawArea.setPreferredSize(new Dimension(AREA_WIDTH, AREA_HEIGHT));

        // 监听鼠标移动动作
        drawArea.addMouseMotionListener(new MouseMotionAdapter() {
            // 实现按下鼠标键并拖动的事件处理器
            public void mouseDragged(MouseEvent e) {
                System.out.println(e.getX() + "-->" + e.getY());

                // 如果preX和preY大于0
                if (preX > 0 && preY > 0) {
                    // 设置当前元素
                    g.setColor(new Color(255, 0, 0));
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
            // 实现鼠标键松开的事件处理器
            public void mouseReleased(MouseEvent e) {
                // 弹出右键菜单
                if (e.isPopupTrigger()) {
                    pop.show(drawArea, e.getX(), e.getY());
                }

                // 松开鼠标键时，把上一次鼠标拖动事件的X、Y坐标设为-1
                preX = -1;
                preY = -1;
            }
        });

        f.add(drawArea);

        var p = new Panel();

        p.add(copyBtn);
        p.add(pasteBtn);

        copyBtn.addActionListener(event -> {
            // 将image对象封装成ImageSelection
            var contents = new B_ImageSelection(image);
            // 将ImageSelection对象放入剪贴板中
            clipboard.setContents(contents, null);
        });

        pasteBtn.addActionListener(event -> {
            // 如果剪贴板包含imageFlavor内容
            if (clipboard.isDataFlavorAvailable(DataFlavor.imageFlavor)) {
                try {
                    // 取出剪贴板中的imageFlavor内容，并将其添加到List集合中
                    imageList.add((Image) clipboard
                            .getData(DataFlavor.imageFlavor));
                    drawArea.repaint();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        f.add(p, BorderLayout.SOUTH);

        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        f.pack();
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new C_CopyImageTest().init();
    }

    class DrawArea extends Canvas {
        // 重写Canvas的paint方法，实现绘画
        public void paint(Graphics g) {
            // 将image绘制到该组件上
            g.drawImage(image, 0, 0, null);
            System.out.println(imageList.size());
            // 将List里的所有Image对象都绘制出来
            for (var img : imageList) {
                g.drawImage(img, 0, 0, null);
            }
        }
    }
}
