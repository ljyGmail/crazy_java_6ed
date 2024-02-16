package org.crazy.ch12_swing.sec05_new_features_in_java7;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
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

class A_BlurLayerUI extends LayerUI<JComponent> {
    private BufferedImage screenBlurImage;
    private BufferedImageOp operation;

    public A_BlurLayerUI() {
        var ninth = 1.0f / 9.0f;
        // 定义模糊参数
        float[] blurKernel = {
            ninth, ninth, ninth,
            ninth, ninth, ninth,
            ninth, ninth, ninth
        };

        // ConvolveOp代表进行模糊处理，它将原图片的每一个像素的颜色与周围
        // 像素的颜色进行混合，从而计算出当前像素的颜色值
        operation = new ConvolveOp(
            new Kernel(3, 3, blurKernel),
            ConvolveOp.EDGE_NO_OP, null);
    }

    public void paint(Graphics g, JComponent c) {
        var w = c.getWidth();
        var h = c.getHeight();
        // 如果被装饰窗口大小为0像素x0像素，则直接返回
        if (w == 0 || h == 0)
            return;
        // 如果screenBlurImage没有初始化、或它的尺寸不对
        if (screenBlurImage == null
            || screenBlurImage.getWidth() != w
            || screenBlurImage.getHeight() != h) {
            // 重新创建新的BufferedImage
            screenBlurImage = new BufferedImage(w,
                    h, BufferedImage.TYPE_INT_RGB);
        }

        Graphics2D ig2 = screenBlurImage.createGraphics();
        // 把被装饰组件的界面绘制到当前screenBlurImage上
        ig2.setClip(g.getClip());
        super.paint(ig2, c);
        ig2.dispose();
        var g2 = (Graphics2D) g;
        // 对JLayer装饰的组件进行模糊处理
        g2.drawImage(screenBlurImage, operation, 0, 0);
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
        // LayerUI<JComponent> layerUI = new A_FirstLayerUI();
        LayerUI<JComponent> layerUI = new A_BlurLayerUI();

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
